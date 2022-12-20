package main

import (
	"context"
	"fmt"
	"log"
	"math/rand"
	"net"
	"sync/atomic"
	"time"

	"golang.org/x/time/rate"
)

const (
	ServerHost = "localhost"
	ServerPort = "9000"
	ServerType = "tcp"
	MaxClients = 10
	SalarioMax = 1000
	SalarioMin = 100
)

var (
	cargos = map[int]string{
		0: "operador",
		1: "programador",
	}
)

func main() {
	var (
		ctx, cancel = context.WithTimeout(context.Background(), 5*time.Second)
		limiter     = rate.NewLimiter(10, MaxClients)
		fail        = Int64ToPointer(0)
		success     = Int64ToPointer(0)
		now         = time.Now()
	)
	defer cancel()
	for i := 0; i < MaxClients; i++ {
		go func(index int64) {
			for {
				sendRequest(limiter, Int64ToPointer(index+1), fail, success)
			}
		}(int64(i))
	}
	<-ctx.Done()
	fmt.Printf("\nsuccessful requests: %d\nfailed requests: %d\nit took: %s\n", *success, *fail, time.Since(now))
}

func sendRequest(limiter *rate.Limiter, index, fail, success *int64) {
	r := limiter.Reserve()
	if !r.OK() {
		return
	}
	time.Sleep(r.Delay())

	go func() {
		connection, err := net.Dial(ServerType, ServerHost+":"+ServerPort)
		if err != nil {
			log.Println(err)
			return
		}

		_, _ = connection.Write([]byte(fmt.Sprintf("socket-client_%.2d,%s,%d\n", *index, randCargo(), randSalario())))

		buffer := make([]byte, 1024)
		read, err := connection.Read(buffer)
		if err != nil {
			atomic.AddInt64(fail, 1)
			fmt.Print("Error reading:", err.Error())
		} else {
			fmt.Print("Received: ", string(buffer[:read]))
			atomic.AddInt64(success, 1)
		}

		defer func(connection net.Conn) {
			if err := connection.Close(); err != nil {
				log.Println(err)
			}
		}(connection)
	}()
	atomic.AddInt64(index, 1)
}

func randCargo() string {
	rand.Seed(time.Now().UnixNano())
	return cargos[rand.Intn(2)]
}

func randSalario() int {
	rand.Seed(time.Now().UnixNano())
	salario := rand.Intn(SalarioMax-SalarioMin) + SalarioMin
	return salario - (salario % 100)
}

func Int64ToPointer(i int64) *int64 {
	return &i
}

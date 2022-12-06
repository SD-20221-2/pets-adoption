package rpc;

import io.grpc.ServerBuilder;

import java.io.IOException;

public class MainServerRPC {

    public static void main(String[] args) throws InterruptedException, IOException {
        var server = ServerBuilder
                .forPort(9001)
                .addService(new FuncionarioServiceImpl())
                .build();

        server.start();
        System.out.println("Server RPC init...");
        server.awaitTermination();
    }

}

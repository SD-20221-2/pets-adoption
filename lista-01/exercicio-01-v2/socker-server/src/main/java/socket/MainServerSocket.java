package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainServerSocket {

    public static void main(String[] args) {
        var executor = Executors.newCachedThreadPool();
        try (var server = new ServerSocket(9000, 2000)) {
            scheduleServerEnd(executor, server);
            System.out.println("Socket Server init...");
            while (!server.isClosed() && !executor.isShutdown()) {
                try {
                    var socket = server.accept();
                    executor.execute(answerAsync(socket));
                } catch (IOException ignored) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Socket Server ended...");
        System.exit(0);
    }

    private static void scheduleServerEnd(ExecutorService executor, ServerSocket server) {
        var scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(() -> {
            executor.shutdown();
            System.out.println("Socket Server closing...");
            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }

            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 300, TimeUnit.SECONDS);
    }

    private static Runnable answerAsync(Socket socket) {
        return () -> {
            try (var output = new PrintWriter(socket.getOutputStream(), true);
                 var input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                var params = input.readLine().split(",");
                var funcionario = new FuncionarioImpl();

                var salario = funcionario.recalcularSalario(params[1], Double.parseDouble(params[2]));
                output.printf("%.2f\n", salario);
                System.out.printf("%s replied\n", params[0]);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}

package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class MainServerSocket {

    public static void main(String[] args) {
        try (var serverSocket = new ServerSocket(9000)) {
            System.out.println("Socket Server init...");
            while (true) {
                try (var socket = serverSocket.accept();
                     var output = new PrintWriter(socket.getOutputStream(), true);
                     var input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                    var params = input.readLine().split(",");
                    var funcionario = new FuncionarioImpl();

                    var salario = funcionario.recalcularSalario(params[0], Double.parseDouble(params[1]));
                    output.printf("%.2f\n", salario);
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

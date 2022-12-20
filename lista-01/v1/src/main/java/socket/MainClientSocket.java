package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class MainClientSocket {

    public static void main(String[] args) {

        try (var scanner = new Scanner(System.in)) {
            System.out.println("Informe os dados do funcionário: ");
            System.out.print("Nome: ");
            var nome = scanner.nextLine();
            System.out.print("Cargo: ");
            var cargo = scanner.nextLine();
            System.out.print("Salário: ");
            var salario = scanner.nextDouble();

            try (var socket = new Socket(InetAddress.getLocalHost(), 9000);
                 var saida = new PrintWriter(socket.getOutputStream(), true);
                 var entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                System.out.println("Client Socket init...");

                saida.printf("%s,%f\n", cargo, salario);

                System.out.printf("\nSalário reajustado\nFuncionário: %s\nSalário: %s\n", nome, entrada.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package rpc;

import io.grpc.ManagedChannelBuilder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

import br.ufg.lista01.rpc.FuncionarioServiceGrpc;
import br.ufg.lista01.rpc.FuncionarioRequest;

public class MainClientRPC {

    public static void main(String[] args) throws UnknownHostException {
        var channel = ManagedChannelBuilder
                .forAddress(InetAddress.getLocalHost().getHostName(), 9001)
                .usePlaintext()
                .build();

        var stub = FuncionarioServiceGrpc.newBlockingStub(channel);

        try (var scanner = new Scanner(System.in)) {
            System.out.println("Informe os dados do funcionário: ");
            System.out.print("Nome: ");
            var nome = scanner.nextLine();
            System.out.print("Cargo: ");
            var cargo = scanner.nextLine();
            System.out.print("Salário: ");
            var salario = scanner.nextDouble();

            var response = stub.recalcularSalario(
                    FuncionarioRequest
                            .newBuilder()
                            .setCargo(cargo)
                            .setSalario(salario)
                            .build()
            );

            System.out.printf("\nSalário reajustado\nFuncionário: %s\nSalário: %.2f\n", nome, response.getSalario());
        }

        channel.shutdown();
    }
}

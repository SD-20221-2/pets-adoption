package rpc;

import br.ufg.lista01.rpc.AlunoAprovadoRequest;
import br.ufg.lista01.rpc.AlunoAprovadoServiceGrpc;
import br.ufg.lista01.rpc.Carta;
import br.ufg.lista01.rpc.CartaBaralhoRequest;
import br.ufg.lista01.rpc.CartaBaralhoServiceGrpc;
import br.ufg.lista01.rpc.ClassificacaoNadadorRequest;
import br.ufg.lista01.rpc.ClassificacaoNadadorServiceGrpc;
import br.ufg.lista01.rpc.FuncionarioRequest;
import br.ufg.lista01.rpc.FuncionarioServiceGrpc;
import br.ufg.lista01.rpc.MaiorIdadeRequest;
import br.ufg.lista01.rpc.MaiorIdadeServiceGrpc;
import br.ufg.lista01.rpc.PesoIdealRequest;
import br.ufg.lista01.rpc.PesoIdealServiceGrpc;
import br.ufg.lista01.rpc.PodeAposentarRequest;
import br.ufg.lista01.rpc.PodeAposentarServiceGrpc;
import br.ufg.lista01.rpc.SalarioLiquidoRequest;
import br.ufg.lista01.rpc.SalarioLiquidoServiceGrpc;
import br.ufg.lista01.rpc.ValorCreditoRequest;
import br.ufg.lista01.rpc.ValorCreditoServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClientRPC {

    public static void main(String[] args) throws UnknownHostException {
        var channel = ManagedChannelBuilder
                .forAddress(InetAddress.getLocalHost().getHostName(), 9001)
                .usePlaintext()
                .build();

        try (var scanner = new Scanner(System.in)) {
            System.out.print("Escolha qual exercício executar. Digite de 1 a 9: ");
            int exercicio = scanner.nextInt();
            scanner.nextLine();

            switch (exercicio) {
                case 1 -> exercicio01(channel, scanner);
                case 2 -> exercicio02(channel, scanner);
                case 3 -> exercicio03(channel, scanner);
                case 4 -> exercicio04(channel, scanner);
                case 5 -> exercicio05(channel, scanner);
                case 6 -> exercicio06(channel, scanner);
                case 7 -> exercicio07(channel, scanner);
                case 8 -> exercicio08(channel, scanner);
                case 9 -> exercicio09(channel);
            }
        }

        channel.shutdown();
    }

    private static void exercicio01(ManagedChannel channel, Scanner scanner) {
        var stub = FuncionarioServiceGrpc.newBlockingStub(channel);
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

    private static void exercicio02(ManagedChannel channel, Scanner scanner) {
        var stub = MaiorIdadeServiceGrpc.newBlockingStub(channel);
        System.out.println("Informe os dados da pessoa:");
        System.out.print("Nome: ");
        var nome = scanner.nextLine();
        System.out.print("Sexo (M ou F): ");
        var sexo = scanner.nextLine();
        System.out.print("Idade: ");
        var idade = scanner.nextInt();

        var response = stub.isMaiorIdade(
                MaiorIdadeRequest
                        .newBuilder()
                        .setSexo(sexo)
                        .setIdade(idade)
                        .build()
        );

        System.out.printf("Nome: %s\nMaior Idade: %s\n", nome, response.getMaiorIdade());
    }

    private static void exercicio03(ManagedChannel channel, Scanner scanner) {
        var stub = AlunoAprovadoServiceGrpc.newBlockingStub(channel);
        System.out.println("Informe os dados do aluno:");
        System.out.print("Nota N1: ");
        var n1 = scanner.nextDouble();
        System.out.print("Nota N2: ");
        var n2 = scanner.nextDouble();
        System.out.print("Nota N3: ");
        var n3 = scanner.nextDouble();


        var response = stub.isAprovado(
                AlunoAprovadoRequest
                        .newBuilder()
                        .setN1(n1)
                        .setN2(n2)
                        .setN3(n3)
                        .build()
        );

        System.out.println("Aluno aprovado: " + response.getAprovado());
    }

    private static void exercicio04(ManagedChannel channel, Scanner scanner) {
        var stub = PesoIdealServiceGrpc.newBlockingStub(channel);
        System.out.println("Informe os dados da pessoa:");
        System.out.print("Altura: ");
        var altura = scanner.nextDouble();
        System.out.print("Sexo: ");
        var sexo = scanner.nextLine();

        var response = stub.calcularPesoIdeal(
                PesoIdealRequest
                        .newBuilder()
                        .setAltura(altura)
                        .setSexo(sexo)
                        .build()
        );

        System.out.println("Peso ideal: " + response.getPesoIdeal());
    }

    private static void exercicio05(ManagedChannel channel, Scanner scanner) {
        var stub = ClassificacaoNadadorServiceGrpc.newBlockingStub(channel);
        System.out.println("Informe os dados do nadador:");
        System.out.print("Idade: ");
        var idade = scanner.nextInt();

        var response = stub.classificar(
                ClassificacaoNadadorRequest
                        .newBuilder()
                        .setIdade(idade)
                        .build()
        );

        System.out.println("Categoria: " + response.getCategoria());
    }

    private static void exercicio06(ManagedChannel channel, Scanner scanner) {
        var stub = SalarioLiquidoServiceGrpc.newBlockingStub(channel);
        System.out.println("Informe os dados do funcionario:");
        System.out.print("Nome: ");
        var nome = scanner.nextLine();
        System.out.print("Nível: ");
        var nivel = scanner.nextLine();
        System.out.print("Salário Bruto: ");
        var salarioBruto = scanner.nextDouble();
        System.out.print("Número de Dependentes: ");
        var nDependentes = scanner.nextInt();

        var response = stub.calcularSalarioLiquido(
                SalarioLiquidoRequest
                        .newBuilder()
                        .setSalarioBruto(salarioBruto)
                        .setNivel(nivel)
                        .setNDependentes(nDependentes)
                        .build()
        );

        System.out.printf("Nome: %s\nNível: %s\nSalário Líquido: %.2f\n", nome, nivel, response.getSalarioLiquido());

    }

    private static void exercicio07(ManagedChannel channel, Scanner scanner) {
        var stub = PodeAposentarServiceGrpc.newBlockingStub(channel);
        System.out.println("Informe os dados do funcionario:");
        System.out.print("Idade: ");
        var idade = scanner.nextInt();
        System.out.print("Tempo de Serviço: ");
        var tempoServico = scanner.nextInt();

        var response = stub.isPodeAposentar(
                PodeAposentarRequest
                        .newBuilder()
                        .setIdade(idade)
                        .setTempoServico(tempoServico)
                        .build()
        );

        System.out.println("Pode aponsentar: " + response.getPodeAposentar());

    }

    private static void exercicio08(ManagedChannel channel, Scanner scanner) {
        var stub = ValorCreditoServiceGrpc.newBlockingStub(channel);
        System.out.println("Informe os dados do cliente:");
        System.out.print("Saldo médio: ");
        var saldoMedio = scanner.nextDouble();

        var response = stub.calcularCredito(
                ValorCreditoRequest
                        .newBuilder()
                        .setSaldoMedio(saldoMedio)
                        .build()
        );

        System.out.printf("Saldo médio: %.2f\nValor do crédito: %.2f", saldoMedio, response.getValorCredito());

    }

    private static void exercicio09(ManagedChannel channel) {
        var stub = CartaBaralhoServiceGrpc.newBlockingStub(channel);
        var cartas = new ArrayList<Carta>();
        for (int naipe = 1; naipe <= 4; naipe++) {
            for (int valor = 1; valor <= 13; valor++) {
                cartas.add(
                        Carta.newBuilder()
                                .setValor(valor)
                                .setNaipe(naipe)
                                .build()
                );
            }
        }

        System.out.println("Cartas: ");
        cartas.forEach(carta -> {
            var response = stub.nomeCarta(
                    CartaBaralhoRequest
                            .newBuilder()
                            .setCarta(carta)
                            .build()
            );

            System.out.println("\t" + response.getNome());
        });
    }
}

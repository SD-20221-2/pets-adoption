package rmi;

import rmi.ex01.Funcionario;
import rmi.ex02.MaiorIdade;
import rmi.ex03.AlunoAprovado;
import rmi.ex04.PesoIdeal;
import rmi.ex05.ClassificacaoNadador;
import rmi.ex06.SalarioLiquido;
import rmi.ex07.PodeAposentar;
import rmi.ex08.ValorCredito;
import rmi.ex09.Carta;
import rmi.ex09.CartaBaralho;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClientRMI {

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            var hostname = InetAddress.getLocalHost().getHostName();
            var registry = LocateRegistry.getRegistry(1098);

            System.out.print("Escolha qual exercício executar. Digite de 1 a 9: ");
            int exercicio = scanner.nextInt();
            scanner.nextLine();

            switch (exercicio) {
                case 1 -> exercicio01(scanner, hostname, registry);
                case 2 -> exercicio02(scanner, hostname, registry);
                case 3 -> exercicio03(scanner, hostname, registry);
                case 4 -> exercicio04(scanner, hostname, registry);
                case 5 -> exercicio05(scanner, hostname, registry);
                case 6 -> exercicio06(scanner, hostname, registry);
                case 7 -> exercicio07(scanner, hostname, registry);
                case 8 -> exercicio08(scanner, hostname, registry);
                case 9 -> exercicio09(hostname, registry);
            }
        } catch (NotBoundException | RemoteException | UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static void exercicio01(Scanner scanner, String hostname, Registry registry) throws RemoteException, NotBoundException {
        var funcionario = (Funcionario) registry.lookup(String.format("//%s/Funcionario", hostname));
        System.out.println("Informe os dados do funcionário:");
        System.out.print("Nome: ");
        var nome = scanner.nextLine();
        System.out.print("Cargo: ");
        var cargo = scanner.nextLine();
        System.out.print("Salário: ");
        var salario = scanner.nextDouble();

        var salarioReajustado = funcionario.recalcularSalario(cargo, salario);
        System.out.printf("\nSalário reajustado\nFuncionário: %s\nSalário: %.2f\n", nome, salarioReajustado);
    }

    private static void exercicio02(Scanner scanner, String hostname, Registry registry) throws RemoteException, NotBoundException {
        var maiorIdade = (MaiorIdade) registry.lookup(String.format("//%s/MaiorIdade", hostname));
        System.out.println("Informe os dados da pessoa:");
        System.out.print("Nome: ");
        var nome = scanner.nextLine();
        System.out.print("Sexo (M ou F): ");
        var sexo = scanner.nextLine();
        System.out.print("Idade: ");
        var idade = scanner.nextInt();

        System.out.printf("Nome: %s\nMaior Idade: %s\n", nome, maiorIdade.isMaiorIdade(idade, sexo));
    }

    private static void exercicio03(Scanner scanner, String hostname, Registry registry) throws RemoteException, NotBoundException {
        var alunoAprovado = (AlunoAprovado) registry.lookup(String.format("//%s/AlunoAprovado", hostname));
        System.out.println("Informe os dados do aluno:");
        System.out.print("Nota N1: ");
        var n1 = scanner.nextDouble();
        System.out.print("Nota N2: ");
        var n2 = scanner.nextDouble();
        System.out.print("Nota N3: ");
        var n3 = scanner.nextDouble();

        System.out.println("Aluno aprovado: " + alunoAprovado.isAprovado(n1, n2, n3));
    }

    private static void exercicio04(Scanner scanner, String hostname, Registry registry) throws RemoteException, NotBoundException {
        var pesoIdeal = (PesoIdeal) registry.lookup(String.format("//%s/PesoIdeal", hostname));
        System.out.println("Informe os dados da pessoa:");
        System.out.print("Altura: ");
        var altura = scanner.nextDouble();
        System.out.print("Sexo: ");
        var sexo = scanner.nextLine();

        System.out.println("Peso ideal: " + pesoIdeal.calcularPesoIdeal(altura, sexo));
    }

    private static void exercicio05(Scanner scanner, String hostname, Registry registry) throws RemoteException, NotBoundException {
        var classificacaoNadador = (ClassificacaoNadador) registry.lookup(String.format("//%s/ClassificacaoNadador", hostname));
        System.out.println("Informe os dados do nadador:");
        System.out.print("Idade: ");
        var idade = scanner.nextInt();

        System.out.println("Categoria: " + classificacaoNadador.classificar(idade));
    }

    private static void exercicio06(Scanner scanner, String hostname, Registry registry) throws RemoteException, NotBoundException {
        var salarioLiquido = (SalarioLiquido) registry.lookup(String.format("//%s/SalarioLiquido", hostname));
        System.out.println("Informe os dados do funcionario:");
        System.out.print("Nome: ");
        var nome = scanner.nextLine();
        System.out.print("Nível: ");
        var nivel = scanner.nextLine();
        System.out.print("Salário Bruto: ");
        var salarioBruto = scanner.nextDouble();
        System.out.print("Número de Dependentes: ");
        var nDependentes = scanner.nextInt();

        System.out.printf("Nome: %s\nNível: %s\nSalário Líquido: %.2f\n", nome, nivel, salarioLiquido.calcularSalarioLiquido(nivel, salarioBruto, nDependentes));
    }

    private static void exercicio07(Scanner scanner, String hostname, Registry registry) throws RemoteException, NotBoundException {
        var podeAposentar = (PodeAposentar) registry.lookup(String.format("//%s/PodeAposentar", hostname));
        System.out.println("Informe os dados do funcionario:");
        System.out.print("Idade: ");
        var idade = scanner.nextInt();
        System.out.print("Tempo de Serviço: ");
        var tempoServico = scanner.nextInt();

        System.out.println("Pode aponsentar: " + podeAposentar.isPodeAposentar(idade, tempoServico));
    }

    private static void exercicio08(Scanner scanner, String hostname, Registry registry) throws RemoteException, NotBoundException {
        var valorCredito = (ValorCredito) registry.lookup(String.format("//%s/ValorCredito", hostname));
        System.out.println("Informe os dados do cliente:");
        System.out.print("Saldo médio: ");
        var saldoMedio = scanner.nextDouble();

        System.out.printf("Saldo médio: %.2f\nValor do crédito: %.2f", saldoMedio, valorCredito.calcularCredito(saldoMedio));
    }

    private static void exercicio09(String hostname, Registry registry) throws RemoteException, NotBoundException {
        var cartaBaralho = (CartaBaralho) registry.lookup(String.format("//%s/NomeCarta", hostname));
        var cartas = new ArrayList<Carta>();
        for (int naipe = 1; naipe <= 4; naipe++) {
            for (int valor = 1; valor <= 13; valor++) {
                cartas.add(new Carta(valor, naipe));
            }
        }

        System.out.println("Cartas: ");
        cartas.forEach(carta -> System.out.println("\t" + cartaBaralho.nomeCarta(carta)));
    }

}

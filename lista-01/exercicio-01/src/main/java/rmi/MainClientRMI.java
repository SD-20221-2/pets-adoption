package rmi;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class MainClientRMI {

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            var hostname = InetAddress.getLocalHost().getHostName();
            var registry = LocateRegistry.getRegistry(1098);
            var funcionario = (Funcionario) registry.lookup(String.format("//%s/Funcionario", hostname));

            System.out.println("Informe os dados do funcionário: ");
            System.out.print("Nome: ");
            var nome = scanner.nextLine();
            System.out.print("Cargo: ");
            var cargo = scanner.nextLine();
            System.out.print("Salário: ");
            var salario = scanner.nextDouble();

            var salarioReajustado = funcionario.recalcularSalario(cargo, salario);
            System.out.printf("\nSalário reajustado\nFuncionário: %s\nSalário: %.2f\n", nome, salarioReajustado);
        } catch (NotBoundException | RemoteException | UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

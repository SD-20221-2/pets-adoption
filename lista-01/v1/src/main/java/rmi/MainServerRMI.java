package rmi;

import rmi.ex01.FuncionarioImpl;
import rmi.ex02.MaiorIdadeImpl;
import rmi.ex03.AlunoAprovadoImpl;
import rmi.ex04.PesoIdealImpl;
import rmi.ex05.ClassificacaoNadadorImpl;
import rmi.ex06.SalarioLiquidoImpl;
import rmi.ex07.PodeAposentarImpl;
import rmi.ex08.ValorCreditoImpl;
import rmi.ex09.CartaBaralhoImpl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class MainServerRMI extends UnicastRemoteObject {

    public MainServerRMI() throws RemoteException {
        try {
            var hostname = InetAddress.getLocalHost().getHostName();
            var registry = LocateRegistry.createRegistry(1098);
            registry.rebind(String.format("//%s/Funcionario", hostname), new FuncionarioImpl());
            registry.rebind(String.format("//%s/MaiorIdade", hostname), new MaiorIdadeImpl());
            registry.rebind(String.format("//%s/AlunoAprovado", hostname), new AlunoAprovadoImpl());
            registry.rebind(String.format("//%s/PesoIdeal", hostname), new PesoIdealImpl());
            registry.rebind(String.format("//%s/ClassificacaoNadador", hostname), new ClassificacaoNadadorImpl());
            registry.rebind(String.format("//%s/SalarioLiquido", hostname), new SalarioLiquidoImpl());
            registry.rebind(String.format("//%s/PodeAposentar", hostname), new PodeAposentarImpl());
            registry.rebind(String.format("//%s/ValorCredito", hostname), new ValorCreditoImpl());
            registry.rebind(String.format("//%s/NomeCarta", hostname), new CartaBaralhoImpl());
            System.out.println("Server init...");
        } catch (RemoteException | UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws RemoteException {
        new MainServerRMI();
    }
}

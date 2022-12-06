package rmi;

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
            System.out.println("Server init...");
        } catch (RemoteException | UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws RemoteException {
        new MainServerRMI();
    }
}

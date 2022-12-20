package rmi.ex06;

import java.io.Serializable;
import java.rmi.Remote;

public interface SalarioLiquido extends Remote, Serializable {

    double calcularSalarioLiquido(String nivel, double salarioBruto, int nDependentes);
}

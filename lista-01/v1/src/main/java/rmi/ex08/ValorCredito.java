package rmi.ex08;

import java.io.Serializable;
import java.rmi.Remote;

public interface ValorCredito extends Remote, Serializable {

    double calcularCredito(double saldoMedio);
}

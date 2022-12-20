package rmi.ex04;

import java.io.Serializable;
import java.rmi.Remote;

public interface PesoIdeal extends Remote, Serializable {

    double calcularPesoIdeal(double altura, String sexo);
}

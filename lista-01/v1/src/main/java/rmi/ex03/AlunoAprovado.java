package rmi.ex03;

import java.io.Serializable;
import java.rmi.Remote;

public interface AlunoAprovado extends Remote, Serializable {

    boolean isAprovado(double n1, double n2, double n3);

}

package rmi.ex05;

import java.io.Serializable;
import java.rmi.Remote;

public interface ClassificacaoNadador extends Remote, Serializable {

    String classificar(int idade);
}

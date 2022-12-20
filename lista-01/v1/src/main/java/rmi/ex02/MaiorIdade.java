package rmi.ex02;

import java.io.Serializable;
import java.rmi.Remote;

public interface MaiorIdade extends Remote, Serializable {

    boolean isMaiorIdade(int idade, String sexo);
}

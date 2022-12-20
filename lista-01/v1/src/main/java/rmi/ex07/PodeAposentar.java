package rmi.ex07;

import java.io.Serializable;
import java.rmi.Remote;

public interface PodeAposentar extends Remote, Serializable {

    boolean isPodeAposentar(int idade, int tempoServico);
}

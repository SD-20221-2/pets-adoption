package rmi.ex09;

import java.io.Serializable;
import java.rmi.Remote;

public interface CartaBaralho extends Remote, Serializable {

    String nomeCarta(Carta carta);
}

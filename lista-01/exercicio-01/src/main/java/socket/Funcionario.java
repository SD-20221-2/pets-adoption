package socket;

import java.io.Serializable;
import java.rmi.Remote;

public interface Funcionario extends Remote, Serializable {

    double recalcularSalario(String cargo, double salario);

}

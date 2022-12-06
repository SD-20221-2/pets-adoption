package rmi;

public class FuncionarioImpl implements Funcionario {

    @Override
    public double recalcularSalario(String cargo, double salario) {
        return switch (cargo) {
            case "operador" -> salario * 1.2;
            case "programador" -> salario * 1.18;
            default -> 0;
        };
    }
}

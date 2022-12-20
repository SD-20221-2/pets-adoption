package rmi.ex06;

public class SalarioLiquidoImpl implements SalarioLiquido {
    @Override
    public double calcularSalarioLiquido(String nivel, double salarioBruto, int nDependentes) {
        return switch (nivel) {
            case "A" -> salarioBruto * nDependentes == 0 ? 0.03 : 0.08;
            case "B" -> salarioBruto * nDependentes == 0 ? 0.05 : 0.10;
            case "C" -> salarioBruto * nDependentes == 0 ? 0.08 : 0.15;
            case "D" -> salarioBruto * nDependentes == 0 ? 0.10 : 0.17;
            default -> 0;
        };

    }
}

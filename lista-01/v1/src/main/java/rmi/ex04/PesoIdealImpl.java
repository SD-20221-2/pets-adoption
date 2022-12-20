package rmi.ex04;

public class PesoIdealImpl implements PesoIdeal {
    @Override
    public double calcularPesoIdeal(double altura, String sexo) {
        if (sexo == null) {
            return 0;
        }
        sexo = sexo.toLowerCase();
        return switch (sexo) {
            case "m", "masculino" -> (72.7 * altura) - 58;
            case "f", "feminino" -> (62.1 * altura) - 44.7;
            default -> 0;
        };
    }
}

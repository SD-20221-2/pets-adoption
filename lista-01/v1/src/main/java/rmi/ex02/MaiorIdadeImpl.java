package rmi.ex02;

public class MaiorIdadeImpl implements MaiorIdade {
    @Override
    public boolean isMaiorIdade(int idade, String sexo) {
        if (sexo == null) {
            return false;
        }
        sexo = sexo.toLowerCase();
        return switch (sexo) {
            case "m", "masculino" -> idade >= 18;
            case "f", "feminino" -> idade >= 21;
            default -> false;
        };
    }
}

package rmi.ex05;

public class ClassificacaoNadadorImpl implements ClassificacaoNadador {
    @Override
    public String classificar(int idade) {
        if (idade >= 5 && idade <= 7) {
            return "infantial A";
        }
        if (idade >= 8 && idade <= 10) {
            return "infantial B";
        }
        if (idade >= 11 && idade <= 13) {
            return "juvenial A";
        }
        if (idade >= 14 && idade <= 17) {
            return "juvenil B";
        }

        if (idade >= 18) {
            return "adulto";
        }
        return "";
    }
}

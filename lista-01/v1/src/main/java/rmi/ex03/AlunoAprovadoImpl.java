package rmi.ex03;

public class AlunoAprovadoImpl implements AlunoAprovado {
    @Override
    public boolean isAprovado(double n1, double n2, double n3) {
        var m = (n1 + n2) / 2;
        if (m >= 7) {
            return true;
        }

        if (m >= 3) {
            return (m + n3) / 2 > 5;
        }
        return false;
    }
}

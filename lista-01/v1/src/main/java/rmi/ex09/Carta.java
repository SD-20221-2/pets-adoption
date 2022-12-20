package rmi.ex09;

public class Carta {

    private final int valor;
    private final int naipe;

    public Carta(int valor, int naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public int getValor() {
        return valor;
    }

    public int getNaipe() {
        return naipe;
    }

    public String getNaipePorExtenso() {
        return switch (naipe) {
            case 1 -> "ouros";
            case 2 -> "paus";
            case 3 -> "copas";
            case 4 -> "espadas";
            default -> "";
        };
    }
}

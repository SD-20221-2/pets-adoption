package rmi.ex09;

public class CartaBaralhoImpl implements CartaBaralho {

    public String nomeCarta(Carta carta) {
        return carta.getValor() + " " + carta.getNaipePorExtenso();
    }


}

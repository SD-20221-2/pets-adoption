package rmi.ex08;

public class ValorCreditoImpl implements ValorCredito {
    @Override
    public double calcularCredito(double saldoMedio) {
        if (saldoMedio >= 0 && saldoMedio <= 200) {
            return 0;
        }
        if (saldoMedio >= 201 && saldoMedio <= 400) {
            return saldoMedio * 0.2;
        }
        if (saldoMedio >= 401 && saldoMedio <= 600) {
            return saldoMedio * 0.3;
        }
        if (saldoMedio >= 601) {
            return saldoMedio * 0.4;
        }
        return 0;
    }
}

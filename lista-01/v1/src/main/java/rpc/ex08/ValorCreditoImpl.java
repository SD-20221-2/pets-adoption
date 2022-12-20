package rpc.ex08;

import br.ufg.lista01.rpc.ValorCreditoRequest;
import br.ufg.lista01.rpc.ValorCreditoResponse;
import br.ufg.lista01.rpc.ValorCreditoServiceGrpc.ValorCreditoServiceImplBase;
import io.grpc.stub.StreamObserver;

public class ValorCreditoImpl extends ValorCreditoServiceImplBase {

    public void calcularCredito(ValorCreditoRequest request, StreamObserver<ValorCreditoResponse> responseObserver) {
        double saldoMedio = request.getSaldoMedio();
        var credito = 0.0;
        if (saldoMedio >= 0 && saldoMedio <= 200) {
            credito = 0;
        }
        if (saldoMedio >= 201 && saldoMedio <= 400) {
            credito = saldoMedio * 0.2;
        }
        if (saldoMedio >= 401 && saldoMedio <= 600) {
            credito = saldoMedio * 0.3;
        }
        if (saldoMedio >= 601) {
            credito = saldoMedio * 0.4;
        }
        var response = ValorCreditoResponse.newBuilder().setValorCredito(credito).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

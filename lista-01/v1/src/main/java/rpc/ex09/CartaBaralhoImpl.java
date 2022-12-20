package rpc.ex09;

import br.ufg.lista01.rpc.CartaBaralhoRequest;
import br.ufg.lista01.rpc.CartaBaralhoResponse;
import br.ufg.lista01.rpc.CartaBaralhoServiceGrpc.CartaBaralhoServiceImplBase;
import io.grpc.stub.StreamObserver;

public class CartaBaralhoImpl extends CartaBaralhoServiceImplBase {

    public void nomeCarta(CartaBaralhoRequest request, StreamObserver<CartaBaralhoResponse> responseObserver) {
        var nomeCarta = request.getCarta().getValor() + " " + getNaipePorExtenso(request.getCarta().getNaipe());
        var response = CartaBaralhoResponse.newBuilder().setNome(nomeCarta).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private String getNaipePorExtenso(int naipe) {
        return switch (naipe) {
            case 1 -> "ouros";
            case 2 -> "paus";
            case 3 -> "copas";
            case 4 -> "espadas";
            default -> "";
        };
    }

}

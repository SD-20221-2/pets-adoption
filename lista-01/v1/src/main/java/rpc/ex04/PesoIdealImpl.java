package rpc.ex04;

import br.ufg.lista01.rpc.PesoIdealRequest;
import br.ufg.lista01.rpc.PesoIdealResponse;
import br.ufg.lista01.rpc.PesoIdealServiceGrpc.PesoIdealServiceImplBase;
import io.grpc.stub.StreamObserver;

public class PesoIdealImpl extends PesoIdealServiceImplBase {

    public void calcularPesoIdeal(PesoIdealRequest request, StreamObserver<PesoIdealResponse> responseObserver) {
        var sexo = request.getSexo().toLowerCase();
        sexo = sexo.toLowerCase();
        var pesoIdeal = switch (sexo) {
            case "m", "masculino" -> (72.7 * request.getAltura()) - 58;
            case "f", "feminino" -> (62.1 * request.getAltura()) - 44.7;
            default -> 0;
        };

        var response = PesoIdealResponse.newBuilder().setPesoIdeal(pesoIdeal).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

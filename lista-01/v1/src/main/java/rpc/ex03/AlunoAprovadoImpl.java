package rpc.ex03;

import br.ufg.lista01.rpc.AlunoAprovadoRequest;
import br.ufg.lista01.rpc.AlunoAprovadoResponse;
import br.ufg.lista01.rpc.AlunoAprovadoServiceGrpc.AlunoAprovadoServiceImplBase;
import io.grpc.stub.StreamObserver;

public class AlunoAprovadoImpl extends AlunoAprovadoServiceImplBase {

    public void isAprovado(AlunoAprovadoRequest request, StreamObserver<AlunoAprovadoResponse> responseObserver) {
        var m = (request.getN1() + request.getN2()) / 2;
        var aprovado = m >= 7;

        if (m >= 3) {
            aprovado = (m + request.getN3()) / 2 > 5;
        }
        var response = AlunoAprovadoResponse.newBuilder().setAprovado(aprovado).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

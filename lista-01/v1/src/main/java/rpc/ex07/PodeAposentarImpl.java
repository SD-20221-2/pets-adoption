package rpc.ex07;

import br.ufg.lista01.rpc.PodeAposentarRequest;
import br.ufg.lista01.rpc.PodeAposentarResponse;
import br.ufg.lista01.rpc.PodeAposentarServiceGrpc.PodeAposentarServiceImplBase;
import io.grpc.stub.StreamObserver;

public class PodeAposentarImpl extends PodeAposentarServiceImplBase {

    public void isPodeAposentar(PodeAposentarRequest request, StreamObserver<PodeAposentarResponse> responseObserver) {
        var podeAposentar = request.getIdade() >= 65 || request.getTempoServico() >= 30 || (request.getIdade() >= 60 && request.getTempoServico() >= 25);

        var response = PodeAposentarResponse.newBuilder().setPodeAposentar(podeAposentar).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

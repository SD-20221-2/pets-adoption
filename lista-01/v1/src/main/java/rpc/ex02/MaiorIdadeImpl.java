package rpc.ex02;

import br.ufg.lista01.rpc.MaiorIdadeRequest;
import br.ufg.lista01.rpc.MaiorIdadeResponse;
import br.ufg.lista01.rpc.MaiorIdadeServiceGrpc.MaiorIdadeServiceImplBase;
import io.grpc.stub.StreamObserver;

public class MaiorIdadeImpl extends MaiorIdadeServiceImplBase {

    public void isMaiorIdade(MaiorIdadeRequest request, StreamObserver<MaiorIdadeResponse> responseObserver) {
        var maiorIdade = false;
        var sexo = request.getSexo().toLowerCase();
        maiorIdade = switch (sexo) {
            case "m", "masculino" -> request.getIdade() >= 18;
            case "f", "feminino" -> request.getIdade() >= 21;
            default -> false;
        };

        var response = MaiorIdadeResponse.newBuilder().setMaiorIdade(maiorIdade).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

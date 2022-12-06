package rpc;

import br.ufg.lista01.rpc.FuncionarioRequest;
import br.ufg.lista01.rpc.FuncionarioResponse;
import br.ufg.lista01.rpc.FuncionarioServiceGrpc.FuncionarioServiceImplBase;
import io.grpc.stub.StreamObserver;

public class FuncionarioServiceImpl extends FuncionarioServiceImplBase {

    @Override
    public void recalcularSalario(FuncionarioRequest request, StreamObserver<FuncionarioResponse> responseObserver) {
        var salario = switch (request.getCargo()) {
            case "operador" -> request.getSalario() * 1.2;
            case "programador" -> request.getSalario() * 1.18;
            default -> 0.0;
        };

        var response = FuncionarioResponse.newBuilder().setSalario(salario).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

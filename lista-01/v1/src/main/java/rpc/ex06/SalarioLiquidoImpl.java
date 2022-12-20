package rpc.ex06;

import br.ufg.lista01.rpc.SalarioLiquidoRequest;
import br.ufg.lista01.rpc.SalarioLiquidoResponse;
import br.ufg.lista01.rpc.SalarioLiquidoServiceGrpc.SalarioLiquidoServiceImplBase;
import io.grpc.stub.StreamObserver;

public class SalarioLiquidoImpl extends SalarioLiquidoServiceImplBase {

    public void calcularSalarioLiquido(SalarioLiquidoRequest request, StreamObserver<SalarioLiquidoResponse> responseObserver) {
        var salarioLiquido = switch (request.getNivel()) {
            case "A" -> request.getSalarioBruto() * request.getNDependentes() == 0 ? 0.03 : 0.08;
            case "B" -> request.getSalarioBruto() * request.getNDependentes() == 0 ? 0.05 : 0.10;
            case "C" -> request.getSalarioBruto() * request.getNDependentes() == 0 ? 0.08 : 0.15;
            case "D" -> request.getSalarioBruto() * request.getNDependentes() == 0 ? 0.10 : 0.17;
            default -> 0;
        };

        var response = SalarioLiquidoResponse.newBuilder().setSalarioLiquido(salarioLiquido).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}

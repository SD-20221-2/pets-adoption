package rpc.ex05;

import br.ufg.lista01.rpc.ClassificacaoNadadorRequest;
import br.ufg.lista01.rpc.ClassificacaoNadadorResponse;
import br.ufg.lista01.rpc.ClassificacaoNadadorServiceGrpc.ClassificacaoNadadorServiceImplBase;
import io.grpc.stub.StreamObserver;

public class ClassificacaoNadadorImpl extends ClassificacaoNadadorServiceImplBase {

    public void classificar(ClassificacaoNadadorRequest request, StreamObserver<ClassificacaoNadadorResponse> responseObserver) {
        var categoria = "";
        if ( request.getIdade() >= 5 &&  request.getIdade() <= 7) {
            categoria= "infantial A";
        }
        if ( request.getIdade() >= 8 &&  request.getIdade() <= 10) {
            categoria= "infantial B";
        }
        if ( request.getIdade() >= 11 &&  request.getIdade() <= 13) {
            categoria= "juvenial A";
        }
        if ( request.getIdade() >= 14 &&  request.getIdade() <= 17) {
            categoria= "juvenil B";
        }

        if ( request.getIdade() >= 18) {
            categoria= "adulto";
        }

        var response = ClassificacaoNadadorResponse.newBuilder().setCategoria(categoria).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

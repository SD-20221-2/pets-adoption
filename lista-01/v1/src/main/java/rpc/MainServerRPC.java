package rpc;

import io.grpc.ServerBuilder;
import rpc.ex01.FuncionarioServiceImpl;
import rpc.ex02.MaiorIdadeImpl;
import rpc.ex03.AlunoAprovadoImpl;
import rpc.ex04.PesoIdealImpl;
import rpc.ex05.ClassificacaoNadadorImpl;
import rpc.ex06.SalarioLiquidoImpl;
import rpc.ex07.PodeAposentarImpl;
import rpc.ex08.ValorCreditoImpl;
import rpc.ex09.CartaBaralhoImpl;

import java.io.IOException;

public class MainServerRPC {

    public static void main(String[] args) throws InterruptedException, IOException {
        var server = ServerBuilder
                .forPort(9001)
                .addService(new FuncionarioServiceImpl())
                .addService(new MaiorIdadeImpl())
                .addService(new AlunoAprovadoImpl())
                .addService(new PesoIdealImpl())
                .addService(new ClassificacaoNadadorImpl())
                .addService(new SalarioLiquidoImpl())
                .addService(new PodeAposentarImpl())
                .addService(new ValorCreditoImpl())
                .addService(new CartaBaralhoImpl())
                .build();

        server.start();
        System.out.println("Server RPC init...");
        server.awaitTermination();
    }

}

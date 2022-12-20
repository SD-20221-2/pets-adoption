package rmi.ex07;

public class PodeAposentarImpl implements PodeAposentar {
    @Override
    public boolean isPodeAposentar(int idade, int tempoServico) {
        return idade >= 65 || tempoServico >= 30 || (idade >= 60 && tempoServico >= 25);
    }
}

import java.util.Date;


public class Pilha {
    private No topo;
    private int ocupacao = 0;
    private int capacidade = 10;

    public boolean estaVazio() {
        return ocupacao == 0;
    }

    public boolean estaCheio() {
        return ocupacao == capacidade;
    }

    public void adicionar(Documento documento) {
        if (estaCheio()) {
            throw new RuntimeException("A fila de impressão está cheia");
        } else if (estaVazio()) {
            Date date = new Date();
            documento.setInicio(date.getTime());
            topo = new No(documento);
        } else {
            Date date = new Date();
            documento.setInicio(date.getTime());
            No novo = new No(documento);
            novo.setProximo(topo);
            topo = novo;

        }
        ocupacao++;
    }

    public Documento remover() {
        if (estaVazio()) {
            throw new RuntimeException("A fila está vazia");
        }
        Date date = new Date();
        Documento documento = topo.getDocumento();
        documento.setFim(date.getTime());
        topo = topo.getProximo();
        ocupacao--;
        return documento;
    }

    public int getPosicao(String nomeArquivo) {
        No runner = topo;
        int posicao = 0;
        while (runner != null) {
            posicao += 1;
            Documento atual = runner.getDocumento();
            if (atual.getNomeArquivo().equals(nomeArquivo)) {
                System.out.println("O arquivo está na pilha");
                System.out.println("Posição do arquivo: " + posicao + "° da pilha");
                Date date = new Date(atual.getInicio());
                System.out.println("Data de solicitação: " + date);
                return posicao;
            }
            runner = runner.getProximo();
        }
        System.out.println("O arquivo não está na pilha");
        return -1;
    }

    public int getOcupacao() {
        return ocupacao;
    }
}
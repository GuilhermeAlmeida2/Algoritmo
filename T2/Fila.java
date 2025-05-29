import java.util.Date;

public class Fila {
    private No primeiro;
    private No ultimo;
    private int capacidade = 10;
    private int ocupacao = 0;

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
            primeiro = new No(documento);
            ultimo = primeiro;
        } else {
            Date date = new Date();
            documento.setInicio(date.getTime());
            ultimo.setProximo(new No(documento));
            ultimo = ultimo.getProximo();
        }
        ocupacao++;

    }

    public Documento remover() {
        if (estaVazio()) {
            throw new RuntimeException("A fila está vazia");
        }
        Date date = new Date();
        Documento documento = primeiro.getDocumento();
        documento.setFim(date.getTime());
        primeiro = primeiro.getProximo();
        ocupacao--;
        return documento;

    }

    public int getPosicao(String nomeArquivo) {
        No runner = primeiro;
        int posicao = 0;
        while (runner != null) {
            Documento atual = runner.getDocumento();

            if (atual.getNomeArquivo().equals(nomeArquivo)) {
                System.out.println("O arquivo está na fila");
                System.out.println("Posição do arquivo: " + posicao + "° da fila");
                Date date = new Date(atual.getInicio());
                System.out.println("Data de solicitação: " + date);
                return posicao;
            }
            runner = runner.getProximo();
            posicao++;
        }
        System.out.println("O arquivo não está na fila");
        return -1;
    }

    public int getOcupacao() {
        return ocupacao;
    }

}
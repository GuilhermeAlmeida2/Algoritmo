public class Documento {
    private String nomeArquivo;
    private String nomeUsuario;
    private Long inicio;
    private Long fim;

    
    public String getNomeArquivo() {
        return nomeArquivo;
    }
    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public Long getInicio() {
        return inicio;
    }
    public void setInicio(Long inicio) {
        this.inicio = inicio;
    }

    public Long getFim() {
        return fim;
    }

    public void setFim(Long fim) {
        this.fim = fim;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome arquivo: " + nomeArquivo);
        sb.append("Nome usuário: " + nomeUsuario);
        sb.append("Data solicitação: " + inicio);
        sb.append("Data Impressão: " + fim);
        return sb.toString();
    }
    
}

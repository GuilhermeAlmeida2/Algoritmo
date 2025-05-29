public class No{
    private Documento documento;
    private No proximo;


    public No(Documento documento){
        this.documento = documento;
    }

    public Documento getDocumento() {
        return documento;
    }
    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
    public No getProximo() {
        return proximo;
    }
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }


}
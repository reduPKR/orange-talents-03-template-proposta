package br.com.proposta.cartao;

public class CartaoBloqueioApiRequest {
    private String sistemaResponsavel;

    public CartaoBloqueioApiRequest(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }
}

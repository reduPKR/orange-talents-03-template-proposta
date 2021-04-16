package br.com.proposta.cartao;

public class CartaoResponse {
    private String idProposta;
    private Cartao cartao;

    public CartaoResponse() {
    }

    public CartaoResponse(String idProposta, Cartao cartao) {
        this.idProposta = idProposta;
        this.cartao = cartao;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public String getIdCartao() {
        return cartao.getId();
    }
}

package br.com.proposta.cartao;

import javax.validation.constraints.NotNull;

public class CartaoBloqueioRequest {
    @NotNull
    private String ip;
    @NotNull
    private String userAgent;

    public CartaoBloqueio toModel(String cartaoId) {
        return new CartaoBloqueio(cartaoId, ip, userAgent);
    }

    public String getIp() {
        return ip;
    }

    public String getUserAgent() {
        return userAgent;
    }
}

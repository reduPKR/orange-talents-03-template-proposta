package br.com.proposta.cartao;

import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CartaoBloqueioResponse {
    private String cartaoId;
    private String ip;
    private LocalDateTime dataBloqueio;
    private String userAgent;

    public CartaoBloqueioResponse(CartaoBloqueio cartaoBloqueio) {
        this.cartaoId = cartaoBloqueio.getCartaoId();
        this.ip = cartaoBloqueio.getIp();
        this.userAgent = cartaoBloqueio.getUserAgent();
        this.dataBloqueio = cartaoBloqueio.getDataBloqueio();
    }

    public String getCartaoId() {
        return cartaoId;
    }

    public String getIp() {
        return ip;
    }

    public LocalDateTime getDataBloqueio() {
        return dataBloqueio;
    }

    public String getUserAgent() {
        return userAgent;
    }
}

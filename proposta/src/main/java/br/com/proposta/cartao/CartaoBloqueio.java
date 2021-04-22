package br.com.proposta.cartao;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class CartaoBloqueio {
    @Id
    private String cartaoId;
    @NotNull
    private String ip;
    @CreationTimestamp
    private LocalDateTime dataBloqueio;
    @NotNull
    private String userAgent;

    public CartaoBloqueio() {
    }

    public CartaoBloqueio(String cartaoId, String ip, String userAgent) {
        this.cartaoId = cartaoId;
        this.ip = ip;
        this.userAgent = userAgent;
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

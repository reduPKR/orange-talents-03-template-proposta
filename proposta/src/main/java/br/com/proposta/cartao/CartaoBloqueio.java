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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @NotNull
    private String ip;
    @CreationTimestamp
    private LocalDateTime dataBloqueio;
    @NotNull
    private String userAgent;

    public CartaoBloqueio() {
    }

    public CartaoBloqueio(String id, String ip, String userAgent) {
        this.id = id;
        this.ip = ip;
        this.userAgent = userAgent;
    }

    public String getId() {
        return id;
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

package br.com.proposta.cartao;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class CartaoAviso {
    @Id
    private String cartaoId;
    @NotNull
    private String destino;
    @FutureOrPresent
    private LocalDate validoAte;
    @NotNull
    private String ip;
    @CreationTimestamp
    private LocalDateTime dataAviso;
    @NotNull
    private String userAgent;

    public CartaoAviso() {
    }

    public CartaoAviso(String cartaoId, String destino, LocalDate validoAte, String ip, String userAgent) {
        this.cartaoId = cartaoId;
        this.destino = destino;
        this.validoAte = validoAte;
        this.ip = ip;
        this.userAgent = userAgent;
    }

    public String getCartaoId() {
        return cartaoId;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }

    public String getIp() {
        return ip;
    }

    public LocalDateTime getDataAviso() {
        return dataAviso;
    }

    public String getUserAgent() {
        return userAgent;
    }
}

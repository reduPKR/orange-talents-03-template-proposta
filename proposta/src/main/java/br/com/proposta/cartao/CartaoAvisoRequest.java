package br.com.proposta.cartao;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CartaoAvisoRequest {
    @NotNull
    private String destino;
    @FutureOrPresent
    private LocalDate validoAte;
    @NotNull
    private String ip;
    @NotNull
    private String userAgent;

    public String getDestino() {
        return destino;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }

    public String getIp() {
        return ip;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public CartaoAviso toModel(String cartaoId) {
        return new CartaoAviso(cartaoId, destino, validoAte, ip, userAgent);
    }
}

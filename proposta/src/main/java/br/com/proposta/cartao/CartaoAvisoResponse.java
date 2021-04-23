package br.com.proposta.cartao;

import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CartaoAvisoResponse {
    private String cartaoId;
    private String destino;
    private LocalDate validoAte;
    private String ip;
    private LocalDateTime dataAviso;
    private String userAgent;

    public CartaoAvisoResponse(CartaoAviso cartaoAviso) {
        cartaoId = cartaoAviso.getCartaoId();
        destino = cartaoAviso.getDestino();
        validoAte = cartaoAviso.getValidoAte();
        ip = cartaoAviso.getIp();
        dataAviso = cartaoAviso.getDataAviso();
        userAgent = cartaoAviso.getUserAgent();
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

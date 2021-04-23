package br.com.proposta.cartao;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CartaoAvisoApiRequest {
    private String destino;
    private LocalDate validoAte;

    public CartaoAvisoApiRequest() {
    }

    public CartaoAvisoApiRequest(CartaoAvisoRequest cartaoAvisoRequest) {
        this.destino = cartaoAvisoRequest.getDestino();
        this.validoAte = cartaoAvisoRequest.getValidoAte();
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }
}

package br.com.proposta.biometria;

import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class BiometriaResponse {
    private long id;
    private String cartaoId;
    private String biometria;
    private LocalDateTime dataCriacao;

    public BiometriaResponse(Biometria biometria) {
        this.id = biometria.getId();
        this.cartaoId = biometria.getCartaoId();
        this.biometria = biometria.getBiometria();
        this.dataCriacao = biometria.getDataCriacao();
    }

    public long getId() {
        return id;
    }

    public String getCartaoId() {
        return cartaoId;
    }

    public String getBiometria() {
        return biometria;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}

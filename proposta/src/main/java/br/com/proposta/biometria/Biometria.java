package br.com.proposta.biometria;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Biometria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String cartaoId;
    @NotNull
    private String biometria;
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    public Biometria() {
    }

    public Biometria(String cartaoId, String biometria) {
        this.cartaoId = cartaoId;
        this.biometria = biometria;
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

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
    private LocalDateTime data;

    public long getId() {
        return id;
    }

    public String getCartaoId() {
        return cartaoId;
    }

    public String getBiometria() {
        return biometria;
    }

    public LocalDateTime getData() {
        return data;
    }
}

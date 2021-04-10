package br.com.proposta.endereco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String rua;
    @Positive
    private int numero;

    public Endereco() {
    }

    public Endereco(@NotNull String cidade, @NotNull String estado, @NotNull String rua, int numero) {
        this.cidade = cidade;
        this.estado = estado;
        this.rua = rua;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }
}

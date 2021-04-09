package br.com.proposta.endereco;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EnderecoRequest {
    @NotNull
    @NotEmpty
    private String cidade;
    @NotNull
    @NotEmpty
    private String estado;
    @NotNull
    @NotEmpty
    private String rua;
    @Min(1)
    private int numero;

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

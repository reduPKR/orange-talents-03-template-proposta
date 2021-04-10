package br.com.proposta.endereco;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EnderecoResponse {
    private String cidade;
    private String estado;
    private String rua;
    private int numero;

    public EnderecoResponse(Endereco endereco) {
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
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

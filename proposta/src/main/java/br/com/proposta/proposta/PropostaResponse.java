package br.com.proposta.proposta;

import br.com.proposta.endereco.EnderecoResponse;

import java.math.BigDecimal;

public class PropostaResponse {

    private String nome;
    private String email;
    private BigDecimal salario;
    private String documento;
    private EnderecoResponse endereco;

    public PropostaResponse(Proposta proposta) {
        this.nome = proposta.getNome();
        this.email = proposta.getEmail();
        this.salario = proposta.getSalario();
        this.documento = proposta.getDocumento();
        this.endereco = new EnderecoResponse(proposta.getEndereco());
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getDocumento() {
        return documento;
    }

    public EnderecoResponse getEndereco() {
        return endereco;
    }
}

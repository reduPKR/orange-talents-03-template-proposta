package br.com.proposta.proposta;

import br.com.proposta.endereco.EnderecoResponse;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

public class PropostaResponse {

    private String nome;
    private String email;
    private BigDecimal salario;
    private String documento;
    private EnderecoResponse endereco;
    private String status;


    public PropostaResponse(Proposta proposta) {
        this.nome = proposta.getNome();
        this.email = proposta.getEmail();
        this.salario = proposta.getSalario();
        this.documento = proposta.getDocumento();
        this.endereco = new EnderecoResponse(proposta.getEndereco());
        this.status = proposta.getAvaliacaoFinanceiraStatus();
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

    public String getStatus() {
        return status;
    }
}

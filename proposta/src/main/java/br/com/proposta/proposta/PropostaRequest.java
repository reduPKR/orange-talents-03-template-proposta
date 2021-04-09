package br.com.proposta.proposta;

import br.com.proposta.endereco.EnderecoRequest;
import br.com.proposta.proposta.documento.CnpjGroup;
import br.com.proposta.proposta.documento.CpfGroup;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.OneToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;

public class PropostaRequest {
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @NotEmpty
    @Email
    private String email;
    @NotNull
    @NotEmpty
    @Positive
    private BigDecimal salario;
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    private String documento;
    @OneToOne
    private EnderecoRequest endereco;

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

    public EnderecoRequest getEndereco() {
        return endereco;
    }
}

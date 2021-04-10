package br.com.proposta.proposta;

import br.com.proposta.endereco.EnderecoRequest;
import br.com.proposta.proposta.documento.CnpjGroup;
import br.com.proposta.proposta.documento.CpfGroup;
import br.com.proposta.proposta.documento.TipoPessoa;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@GroupSequenceProvider(PropostaSequenceProvider.class)
public class PropostaRequest {
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @NotEmpty
    @Email
    private String email;
    @NotNull
    @Positive
    private BigDecimal salario;

    @NotNull
    private TipoPessoa tipoPessoa;
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    private String documento;
    @OneToOne
    @Valid
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

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public String getDocumento() {
        return documento;
    }

    public EnderecoRequest getEndereco() {
        return endereco;
    }

    public Proposta toModel() {
        return new Proposta(
                this.nome,
                this.email,
                this.salario,
                this.documento,
                this.endereco.toModel()
        );
    }
}

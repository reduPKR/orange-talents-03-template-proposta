package br.com.proposta.proposta;

import br.com.proposta.proposta.documento.CnpjGroup;
import br.com.proposta.proposta.documento.CpfGroup;
import br.com.proposta.proposta.documento.TipoPessoa;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class AvaliacaoFinanceiraRequest {
    @Positive
    private long idProposta;
    @NotNull
    @NotEmpty
    private String nome;
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    private String documento;

    public AvaliacaoFinanceiraRequest() {
    }

    public AvaliacaoFinanceiraRequest(Proposta proposta) {
        this.idProposta = proposta.getId();
        this.nome = proposta.getNome();
        this.documento = proposta.getDocumento();
    }

    public long getIdProposta() {
        return idProposta;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public AvaliacaoFinanceiraStatus avaliarCliente() {
        return AvaliacaoFinanceiraStatus.NAO_ELEGIVEL;
    }
}

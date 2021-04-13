package br.com.proposta.proposta;

import br.com.proposta.proposta.documento.CnpjGroup;
import br.com.proposta.proposta.documento.CpfGroup;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AvaliacaoFinanceiraResponse {
    private long idProposta;
    private String nome;
    private String documento;
    private String resultadoSolicitacao;

    public AvaliacaoFinanceiraResponse(long idProposta, String nome, String documento, String resultadoSolicitacao) {
        this.idProposta = idProposta;
        this.nome = nome;
        this.documento = documento;
        this.resultadoSolicitacao = resultadoSolicitacao;
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

    public String getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }
}

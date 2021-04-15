package br.com.proposta.proposta;

import br.com.proposta.proposta.documento.CnpjGroup;
import br.com.proposta.proposta.documento.CpfGroup;
import br.com.proposta.proposta.documento.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonProperty;
import feign.FeignException;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class AvaliacaoFinanceiraRequest {
    @JsonProperty("idProposta")
    private String idProposta;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("documento")
    private String documento;

    public AvaliacaoFinanceiraRequest() {
    }

    public AvaliacaoFinanceiraRequest(Proposta proposta) {
        this.idProposta = proposta.getId().toString();
        this.nome = proposta.getNome();
        this.documento = proposta.getDocumento();
    }

    public String getIdProposta() {
        return idProposta;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public AvaliacaoFinanceiraStatus avaliarCliente(AvaliacaoFinanceiraCliente avaliacao) {
        try{
            avaliacao.avaliacaoFinanceira(this);
            return AvaliacaoFinanceiraStatus.SEM_RESTRICAO;
        }catch (FeignException.UnprocessableEntity fe){
            return AvaliacaoFinanceiraStatus.COM_RESTRICAO;
        }catch (Exception e){
            return AvaliacaoFinanceiraStatus.ERRO_PROCESSAR;
        }
    }
}

package br.com.proposta.proposta;

import br.com.proposta.apiRequest.RequestGenerico;
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
    private RequestGenerico dados;

    public AvaliacaoFinanceiraRequest() {
    }

    public AvaliacaoFinanceiraRequest(Proposta proposta) {
        dados = new RequestGenerico(
                proposta.getId().toString(),
                proposta.getNome(),
                proposta.getDocumento()
        );
    }

    public String getIdProposta() {
        return dados.getIdProposta();
    }

    public String getNome() {
        return dados.getNome();
    }

    public String getDocumento() {
        return dados.getDocumento();
    }

    public AvaliacaoFinanceiraStatus avaliarCliente(AvaliacaoFinanceiraCliente avaliacao) {
        try{
            avaliacao.avaliacaoFinanceira(this.dados);
            return AvaliacaoFinanceiraStatus.SEM_RESTRICAO;
        }catch (FeignException.UnprocessableEntity fe){
            return AvaliacaoFinanceiraStatus.COM_RESTRICAO;
        }catch (Exception e){
            return AvaliacaoFinanceiraStatus.ERRO_PROCESSAR;
        }
    }
}

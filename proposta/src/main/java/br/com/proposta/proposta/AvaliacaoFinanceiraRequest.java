package br.com.proposta.proposta;

import br.com.proposta.apiRequest.RequestGenerico;
import feign.FeignException;

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

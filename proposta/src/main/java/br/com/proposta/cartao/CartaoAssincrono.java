package br.com.proposta.cartao;

import br.com.proposta.apiRequestGenerico.RequestGenerico;
import br.com.proposta.proposta.AvaliacaoFinanceiraStatus;
import br.com.proposta.proposta.Proposta;
import br.com.proposta.proposta.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartaoAssincrono {
    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private ApiCartao apiCartao;

    @Scheduled(fixedDelay = 10000)//cada 10 segundos
    public void analisarPropostasSemCartoes(){
        List<Proposta> lista = propostaRepository.findByAvaliacaoFinanceiraStatusAndCartaoIdIsNull(AvaliacaoFinanceiraStatus.SEM_RESTRICAO);
        lista.forEach(this::adicionarCartao);
    }

    private void adicionarCartao(Proposta proposta) {
        RequestGenerico cartaoRequest = new RequestGenerico(
                proposta.getId().toString(),
                proposta.getNome(),
                proposta.getDocumento()
        );

        CartaoResponse cartao = apiCartao.gerar(cartaoRequest);
        proposta.setCartaoId(cartao.getId());
        propostaRepository.save(proposta);
    }
}

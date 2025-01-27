package br.com.proposta.proposta;

import br.com.proposta.apiRequestGenerico.RequestGenerico;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "AvaliacaoFinanceiraCliente", url = "${solicitacao.analise.url}")
public interface AvaliacaoFinanceiraCliente {
    @PostMapping
    AvaliacaoFinanceiraResponse avaliacaoFinanceira(@RequestBody RequestGenerico avaliacaoFinanceiraRequest);
}

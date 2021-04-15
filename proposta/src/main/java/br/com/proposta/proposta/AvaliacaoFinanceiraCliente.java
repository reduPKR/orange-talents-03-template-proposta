package br.com.proposta.proposta;

import br.com.proposta.apiRequest.RequestGenerico;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "AvaliacaoFinanceiraCliente", url = "http://localhost:9999/api/solicitacao")
public interface AvaliacaoFinanceiraCliente {
    @PostMapping
    AvaliacaoFinanceiraResponse avaliacaoFinanceira(@RequestBody RequestGenerico avaliacaoFinanceiraRequest);
}

package br.com.proposta.proposta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "AvaliacaoFinanceiraCliente", url = "http://localhost:9999/")
public interface AvaliacaoFinanceiraCliente {
    @RequestMapping(value = "api/solicitacao", consumes = "application/json")
    @PostMapping
    AvaliacaoFinanceiraResponse avaliacaoFinanceira(@RequestBody AvaliacaoFinanceiraRequest avaliacaoFinanceiraRequest);
}

package br.com.proposta.cartao;

import br.com.proposta.apiRequest.RequestGenerico;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "CriacaoCartao", url = "http://localhost:8888/api/cartoes")
public interface CriacaoCartao {
    @PostMapping
    CartaoResponse gerar(@RequestBody RequestGenerico cartao);

    @GetMapping("/{cartaoId}")
    CartaoResponse procurar(@PathVariable("cartaoId") String cartaoId);
}

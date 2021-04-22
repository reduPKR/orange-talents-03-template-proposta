package br.com.proposta.cartao;

import br.com.proposta.apiRequestGenerico.RequestGenerico;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ApiCartao", url = "${api.cartoes.url}")
public interface ApiCartao {
    @PostMapping
    CartaoResponse gerar(@RequestBody RequestGenerico cartao);

    @GetMapping("/{cartaoId}")
    CartaoResponse procurar(@PathVariable("cartaoId") String cartaoId);

    @PostMapping("/{cartaoId}/bloqueio")
    CartaoApiBloqueio bloquear(@PathVariable("cartaoId") String cartaoId, @RequestBody CartaoBloqueioApiRequest request);
}

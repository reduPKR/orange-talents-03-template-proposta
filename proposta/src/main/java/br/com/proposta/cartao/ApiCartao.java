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

    @PostMapping("/{cartaoId}/bloqueios")
    CartaoApiResponseGenerico bloquear(@PathVariable("cartaoId") String cartaoId, @RequestBody CartaoBloqueioApiRequest request);

    @PostMapping("/{cartaoId}/avisos")
    CartaoApiResponseGenerico avisar(@PathVariable("cartaoId") String cartaoId, @RequestBody CartaoAvisoApiRequest request);

    @PostMapping("/{cartaoId}/carteiras")
    CartaoApiResponseGenerico associarCarteira(@PathVariable("cartaoId") String cartaoId, @RequestBody CarteiraDigitalAPIRequest request);
}

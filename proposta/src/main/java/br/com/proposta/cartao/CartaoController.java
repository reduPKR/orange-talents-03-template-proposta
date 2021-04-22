package br.com.proposta.cartao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {
    @Autowired
    private CartaoBloqueioRepository cartaoBloqueioRepository;
    @Autowired
    private ApiCartao apiCartao;

    @PostMapping("/{cartaoId}/bloqueio")
    public void bloquear(@PathVariable String cartaoId,
                         @RequestBody @Valid CartaoBloqueioRequest cartaoBloqueioRequest,
                         BindingResult result){

        if(!result.hasErrors()){
            CartaoApiBloqueio cartaoApiBloqueio = apiCartao.bloquear(cartaoId);

            if(cartaoApiBloqueio.getBloqueado()){
                CartaoBloqueio cartaoBloqueio = cartaoBloqueioRequest.toModel(cartaoId);
                cartaoBloqueioRepository.save(cartaoBloqueio);

                
            }
        }
    }
}

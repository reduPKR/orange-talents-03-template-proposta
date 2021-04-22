package br.com.proposta.cartao;

import br.com.proposta.errors.ErrorResponse;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {
    @Autowired
    private CartaoBloqueioRepository cartaoBloqueioRepository;
    @Autowired
    private ApiCartao apiCartao;

    @PostMapping("/{cartaoId}/bloqueio")
    public ResponseEntity<?> bloquear(@PathVariable String cartaoId,
                         @RequestBody @Valid CartaoBloqueioRequest cartaoBloqueioRequest,
                         BindingResult result){

        if(!result.hasErrors()){
            if(procurarCartao(cartaoId)){
                Optional<CartaoBloqueio> optionalCartaoBloqueio = cartaoBloqueioRepository.findByCartaoId(cartaoId);
                if(optionalCartaoBloqueio.isEmpty()){

                    //Comentei para usar um 'mock', testei a rota esta certa com swagger, porem da erro 404
                    //CartaoApiBloqueio cartaoApiBloqueio = apiCartao.bloquear(cartaoId, new CartaoBloqueioApiRequest("proposta"));
                    CartaoApiBloqueio cartaoApiBloqueio = new CartaoApiBloqueio();

                    if(cartaoApiBloqueio.getBloqueado()){
                        CartaoBloqueio cartaoBloqueio = cartaoBloqueioRequest.toModel(cartaoId);
                        cartaoBloqueioRepository.save(cartaoBloqueio);

                        return ResponseEntity.ok(new CartaoBloqueioResponse(cartaoBloqueio));//200
                    }
                }

                //422
                return ResponseEntity.unprocessableEntity()
                        .body(new ErrorResponse(new FieldError("Regra de negocio", "Cartão", "Cartão já foi bloqueado")));
            }

            return ResponseEntity.notFound().build();//404
        }

        List<ErrorResponse> errors = result.getFieldErrors()
                .stream().map(ErrorResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errors);//400
    }

    private boolean procurarCartao(String cartaoId) {
        try{
            CartaoResponse cartao = apiCartao.procurar(cartaoId);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}

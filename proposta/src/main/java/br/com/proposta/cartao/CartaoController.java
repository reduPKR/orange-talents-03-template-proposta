package br.com.proposta.cartao;

import br.com.proposta.errors.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    private CartaoAvisoRepository cartaoAvisoRepository;
    @Autowired
    private CarteiraDigitalRepository carteiraDigitalRepository;

    @Autowired
    private ApiCartao apiCartao;

    @PostMapping("/{cartaoId}/bloqueio")
    @Transactional
    public ResponseEntity<?> bloquear(@PathVariable String cartaoId,
                         @RequestBody @Valid CartaoBloqueioRequest cartaoBloqueioRequest,
                         BindingResult result){

        if(!result.hasErrors()){
            if(procurarCartao(cartaoId)){
                Optional<CartaoBloqueio> optionalCartaoBloqueio = cartaoBloqueioRepository.findByCartaoId(cartaoId);
                if(optionalCartaoBloqueio.isEmpty()){
                    try {
                        CartaoApiResponseGenerico cartaoApiResponseGenerico = apiCartao.bloquear(cartaoId, new CartaoBloqueioApiRequest("proposta"));

                        if(cartaoApiResponseGenerico.getBloqueado()){
                            CartaoBloqueio cartaoBloqueio = cartaoBloqueioRequest.toModel(cartaoId);
                            cartaoBloqueioRepository.save(cartaoBloqueio);

                            return ResponseEntity.ok(new CartaoBloqueioResponse(cartaoBloqueio));//200
                        }
                    }catch (Exception e){
                        System.out.println("FALHA  AO PROCESSAR");
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

    @PostMapping("/{cartaoId}/avisos")
    @Transactional
    public ResponseEntity<?> avisoDeViagem(@PathVariable String cartaoId,
                                           @RequestBody @Valid CartaoAvisoRequest cartaoAvisoRequest,
                                           BindingResult result){
        if(!result.hasErrors()){
            if(procurarCartao(cartaoId)){

                try {
                    CartaoApiResponseGenerico cartaoApiResponseGenerico = apiCartao.avisar(cartaoId, new CartaoAvisoApiRequest(cartaoAvisoRequest));

                    if(cartaoApiResponseGenerico.getAvisoDeViagem()){
                        CartaoAviso cartaoAviso = cartaoAvisoRequest.toModel(cartaoId);

                        cartaoAvisoRepository.save(cartaoAviso);
                        return ResponseEntity.ok(new CartaoAvisoResponse(cartaoAviso));
                    }
                }catch (Exception e){
                    return ResponseEntity.unprocessableEntity().body(new CartaoApiResponseGenerico("FALHA AO PROCESSAR"));
                }
            }

            return ResponseEntity.notFound().build();
        }

        List<ErrorResponse> errors = result.getFieldErrors()
                .stream().map(ErrorResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errors);
    }

    @PostMapping("/{cartaoId}/carteiras")
    @Transactional
    public ResponseEntity<?> associarCarteira(@PathVariable String cartaoId,
                                              @RequestBody @Valid CarteiraDigitalRequest carteiraDigitalRequest,
                                              BindingResult result){

        if(!result.hasErrors()){
            if(procurarCartao(cartaoId)){
                try {
                    CartaoApiResponseGenerico cartaoApiResponseGenerico = apiCartao.associarCarteira(cartaoId, carteiraDigitalRequest);

                    if(cartaoApiResponseGenerico.getAssociado()){
                        CarteiraDigital carteiraDigital = carteiraDigitalRequest.toModel(cartaoId);

                        carteiraDigitalRepository.save(carteiraDigital);
                        ResponseEntity.ok(new CarteiraDigitalResponse(carteiraDigital));
                    }
                }catch (Exception e){
                    return ResponseEntity.unprocessableEntity().body(new CartaoApiResponseGenerico("FALHA AO PROCESSAR"));
                }
            }

            return ResponseEntity.notFound().build();
        }

        List<ErrorResponse> errors = result.getFieldErrors()
                .stream().map(ErrorResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errors);
    }
}

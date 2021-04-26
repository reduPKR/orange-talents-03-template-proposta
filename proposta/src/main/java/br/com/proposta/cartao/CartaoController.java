package br.com.proposta.cartao;

import br.com.proposta.errors.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    public ResponseEntity<?> bloquear(@PathVariable String cartaoId,
                         @RequestBody @Valid CartaoBloqueioRequest cartaoBloqueioRequest,
                         BindingResult result,
                         UriComponentsBuilder uriComponentsBuilder){

        if(!result.hasErrors()){
            if(procurarCartao(cartaoId)){
                Optional<CartaoBloqueio> optionalCartaoBloqueio = cartaoBloqueioRepository.findByCartaoId(cartaoId);
                if(optionalCartaoBloqueio.isEmpty()){
                    try {
                        CartaoApiResponseGenerico cartaoApiResponseGenerico = apiCartao.bloquear(cartaoId, new CartaoBloqueioApiRequest("proposta"));

                        if(cartaoApiResponseGenerico.getBloqueado()){
                            CartaoBloqueio cartaoBloqueio = cartaoBloqueioRequest.toModel(cartaoId);
                            cartaoBloqueioRepository.save(cartaoBloqueio);

                            URI uri = uriComponentsBuilder.path("/cartao/{id}/bloqueio").buildAndExpand(cartaoBloqueio.getCartaoId()).toUri();
                            return ResponseEntity.created(uri).body(new CartaoBloqueioResponse(cartaoBloqueio));//200
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
    public ResponseEntity<?> avisoDeViagem(@PathVariable String cartaoId,
                                           @RequestBody @Valid CartaoAvisoRequest cartaoAvisoRequest,
                                           BindingResult result,
                                           UriComponentsBuilder uriComponentsBuilder){
        if(!result.hasErrors()){
            if(procurarCartao(cartaoId)){

                try {
                    CartaoApiResponseGenerico cartaoApiResponseGenerico = apiCartao.avisar(cartaoId, new CartaoAvisoApiRequest(cartaoAvisoRequest));

                    if(cartaoApiResponseGenerico.getAvisoDeViagem()){
                        CartaoAviso cartaoAviso = cartaoAvisoRequest.toModel(cartaoId);

                        cartaoAvisoRepository.save(cartaoAviso);

                        URI uri = uriComponentsBuilder.path("/cartao/{id}/aviso").buildAndExpand(cartaoAviso.getCartaoId()).toUri();
                        return ResponseEntity.created(uri).body(new CartaoAvisoResponse(cartaoAviso));
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
    public ResponseEntity<?> associarCarteira(@PathVariable String cartaoId,
                                              @RequestBody @Valid CarteiraDigitalRequest carteiraDigitalRequest,
                                              BindingResult result,
                                              UriComponentsBuilder uriComponentsBuilder){

        if(!result.hasErrors()){
            if(procurarCartao(cartaoId)){
                try {
                    CartaoApiResponseGenerico cartaoApiResponseGenerico = apiCartao.associarCarteira(cartaoId, new CarteiraDigitalAPIRequest(carteiraDigitalRequest));

                    if(cartaoApiResponseGenerico.getAssociado()){
                        CarteiraDigital carteiraDigital = carteiraDigitalRequest.toModel(cartaoApiResponseGenerico.getId());

                        carteiraDigitalRepository.save(carteiraDigital);

                        URI uri = uriComponentsBuilder.path("/cartao/{id}/carteira").buildAndExpand(carteiraDigital.getCarteiraId()).toUri();
                        return ResponseEntity.created(uri).body(new CarteiraDigitalResponse(carteiraDigital));
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

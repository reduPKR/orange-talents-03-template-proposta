package br.com.proposta.biometria;

import br.com.proposta.cartao.CartaoResponse;
import br.com.proposta.cartao.ApiCartao;
import br.com.proposta.compartilhado.Criptografia;
import br.com.proposta.errors.ErrorResponse;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/biometria")
public class BiometriaController {
    @Autowired
    private BiometriaRepository biometriaRepository;
    @Autowired
    private ApiCartao apiCartao;

    @GetMapping("/base64")
    public String converteParaTeste(){
        String mensagem = "Teste de gerar base64 para mandar no post";
        return Criptografia.encriptar(mensagem);
    }

    @PostMapping("/{cartaoId}")
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid BiometriaRequest biometriaRequest,
                                       @PathVariable("cartaoId") String cartaoId,
                                       UriComponentsBuilder uriComponentsBuilder,
                                       BindingResult result){
        if(!result.hasErrors()){
            try{
                CartaoResponse cartao = apiCartao.procurar(cartaoId);
                if(biometriaRequest.validar()){
                    Biometria biometria = biometriaRequest.toModel(cartaoId);
                    biometriaRepository.save(biometria);

                    URI uri = uriComponentsBuilder.path("/biometria/{id}").buildAndExpand(biometria.getId()).toUri();
                    return ResponseEntity.created(uri).body(new BiometriaResponse(biometria));
                }

                result.addError(new FieldError("Biometria","Dados", "Biometria inválida"));
            }catch(FeignException e){
                result.addError(new FieldError("Biometria","Cartão", "Cartão não encontrado"));
            }catch (Exception e){
                result.addError(new FieldError("Biometria","Desconhecido", "Erro desconhecido"));
            }
        }

        List<ErrorResponse> errors = result.getFieldErrors()
                .stream().map(ErrorResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> cadastrar(@PathVariable("id") long id){
        Optional<Biometria> biometria = biometriaRepository.findById(id);

        if(biometria.isPresent()){
            return ResponseEntity.ok().body(new BiometriaResponse(biometria.get()));
        }
        return ResponseEntity.badRequest().body("Biometria não encontrada");
    }
}

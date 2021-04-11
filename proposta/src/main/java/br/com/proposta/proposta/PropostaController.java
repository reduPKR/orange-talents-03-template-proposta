package br.com.proposta.proposta;

import br.com.proposta.errors.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/proposta")
public class PropostaController {
    @Autowired
    private PropostaRepository propostaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PropostaRequest propostaRequest,
                                       UriComponentsBuilder uriComponentsBuilder,
                                       BindingResult result){
       Proposta proposta = propostaRequest.toModel();

       Boolean existe = propostaRepository.existsByDocumento(proposta.getDocumento());

       if(existe){
           return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                   .body("Documento já cadastrado");
       }

       propostaRepository.save(proposta);
       if(proposta.getId() != 0){
           URI uri = uriComponentsBuilder.path("/proposta/{id}").buildAndExpand(proposta.getId()).toUri();
           return ResponseEntity.created(uri).body(new PropostaResponse(proposta));
       }

       List<ErrorResponse> errors = result.getFieldErrors()
               .stream().map(ErrorResponse::new)
               .collect(Collectors.toList());

       return ResponseEntity.badRequest().body(errors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhar(@PathVariable long id){
        Optional<Proposta> proposta = propostaRepository.findById(id);

        if(proposta.isPresent())
            return ResponseEntity.ok(new PropostaResponse(proposta.get()));

        return ResponseEntity.notFound().build();
    }

}
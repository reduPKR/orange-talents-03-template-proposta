package br.com.proposta.biometria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biometria")
public class BiometriaController {
    @Autowired
    private BiometriaRepository biometriaRepository;

    @PostMapping("/{cartaoId}")
    public void cadastrar(){
        
    }
}

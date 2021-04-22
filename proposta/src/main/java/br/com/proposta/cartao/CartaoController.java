package br.com.proposta.cartao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cartoes")
public class CartaoController {
    @GetMapping("/{id}/bloqueio")
    public void bloquear(@PathVariable String id){
        System.out.println(id);
    }
}

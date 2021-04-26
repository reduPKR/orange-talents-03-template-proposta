package br.com.proposta.cartao;

import br.com.proposta.enums.CarteiraDigitalEnum;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class CarteiraDigital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cartaoId;
    @NotNull
    private String email;
    @Enumerated(EnumType.STRING)
    private CarteiraDigitalEnum carteira;

    public CarteiraDigital() {
    }

    public CarteiraDigital(String cartaoId, String email, CarteiraDigitalEnum carteira) {
        this.cartaoId = cartaoId;
        this.email = email;
        this.carteira = carteira;
    }

    public String getCartaoId() {
        return cartaoId;
    }

    public String getEmail() {
        return email;
    }

    public CarteiraDigitalEnum getCarteira() {
        return carteira;
    }
}

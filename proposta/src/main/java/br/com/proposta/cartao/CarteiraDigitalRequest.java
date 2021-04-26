package br.com.proposta.cartao;

import br.com.proposta.enums.CarteiraDigitalEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class CarteiraDigitalRequest {
    @NotNull
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private CarteiraDigitalEnum carteira;

    public CarteiraDigital toModel(String cartaoId) {
        return new CarteiraDigital(cartaoId, email, carteira);
    }

    public String getEmail() {
        return email;
    }

    public CarteiraDigitalEnum getCarteira() {
        return carteira;
    }
}

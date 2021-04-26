package br.com.proposta.cartao;

import br.com.proposta.enums.CarteiraDigitalEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

public class CarteiraDigitalResponse {
    private String cartaoId;
    private String email;
    private String carteira;

    public CarteiraDigitalResponse(CarteiraDigital carteiraDigital) {
        this.cartaoId = carteiraDigital.getCartaoId();
        this.email = carteiraDigital.getEmail();
        this.carteira = carteiraDigital.getCarteira().name();
    }
}

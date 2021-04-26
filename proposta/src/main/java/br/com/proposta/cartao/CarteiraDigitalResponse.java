package br.com.proposta.cartao;

import br.com.proposta.enums.CarteiraDigitalEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

public class CarteiraDigitalResponse {
    private String carteiraId;
    private String email;
    private String carteira;

    public CarteiraDigitalResponse(CarteiraDigital carteiraDigital) {
        this.carteiraId = carteiraDigital.getCarteiraId();
        this.email = carteiraDigital.getEmail();
        this.carteira = carteiraDigital.getCarteira().name();
    }

    public String getCarteiraId() {
        return carteiraId;
    }

    public String getEmail() {
        return email;
    }

    public String getCarteira() {
        return carteira;
    }
}

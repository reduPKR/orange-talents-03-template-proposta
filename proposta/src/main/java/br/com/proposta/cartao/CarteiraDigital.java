package br.com.proposta.cartao;

import br.com.proposta.enums.CarteiraDigitalEnum;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class CarteiraDigital {
    @Id
    private String carteiraId;
    @NotNull
    private String email;
    @Enumerated(EnumType.STRING)
    private CarteiraDigitalEnum carteira;

    public CarteiraDigital() {
    }

    public CarteiraDigital(String carteiraId, String email, CarteiraDigitalEnum carteira) {
        this.carteiraId = carteiraId;
        this.email = email;
        this.carteira = carteira;
    }

    public String getCarteiraId() {
        return carteiraId;
    }

    public String getEmail() {
        return email;
    }

    public CarteiraDigitalEnum getCarteira() {
        return carteira;
    }
}

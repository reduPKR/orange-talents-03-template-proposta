package br.com.proposta.cartao;

public class CarteiraDigitalAPIRequest {
    private String email;
    private String emissor;

    public CarteiraDigitalAPIRequest(CarteiraDigitalRequest carteiraDigitalRequest) {
        email = carteiraDigitalRequest.getEmail();
        emissor = carteiraDigitalRequest.getCarteira().name();
    }


    public String getEmail() {
        return email;
    }

    public String getEmissor() {
        return emissor;
    }
}

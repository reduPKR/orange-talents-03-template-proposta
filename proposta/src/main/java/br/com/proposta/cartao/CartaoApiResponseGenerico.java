package br.com.proposta.cartao;

public class CartaoApiResponseGenerico {
    private String resultado;

    public CartaoApiResponseGenerico() {
    }

    public CartaoApiResponseGenerico(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public boolean getBloqueado() {
        return resultado.equals("BLOQUEADO");
    }

    public boolean getAvisoDeViagem() {
        return resultado.equals("CRIADO");
    }
}

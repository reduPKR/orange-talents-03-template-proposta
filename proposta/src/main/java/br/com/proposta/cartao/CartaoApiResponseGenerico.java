package br.com.proposta.cartao;

public class CartaoApiResponseGenerico {
    private String resultado;

    public CartaoApiResponseGenerico() {
        this.resultado = "BLOQUEADO";
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

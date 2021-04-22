package br.com.proposta.cartao;

public class CartaoApiBloqueio {
    private String resultado;

    public CartaoApiBloqueio() {
        this.resultado = "BLOQUEADO";
    }

    public String getResultado() {
        return resultado;
    }

    public boolean getBloqueado() {
        return resultado.equals("BLOQUEADO");
    }
}

package br.com.proposta.cartao;

public class CartaoApiBloqueio {
    private String resultado;

    public String getResultado() {
        return resultado;
    }

    public boolean getBloqueado() {
        return resultado.equals("BLOQUEADO");
    }
}

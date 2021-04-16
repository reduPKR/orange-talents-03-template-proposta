package br.com.proposta.cartao;

import java.time.LocalDateTime;

public class Cartao {
    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private Object[] bloqueios;
    private Object[] avisos;
    private Object[] carteiras;
    private Object[] parcelas;
    private int limite;
    private Object renegociacao;
    private Object vencimento;

    public Cartao(String id, LocalDateTime emitidoEm, String titular, Object[] bloqueios, Object[] avisos, Object[] carteiras, Object[] parcelas, int limite, Object renegociacao, Object vencimento) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcelas = parcelas;
        this.limite = limite;
        this.renegociacao = renegociacao;
        this.vencimento = vencimento;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }

    public Object[] getBloqueios() {
        return bloqueios;
    }

    public Object[] getAvisos() {
        return avisos;
    }

    public Object[] getCarteiras() {
        return carteiras;
    }

    public Object[] getParcelas() {
        return parcelas;
    }

    public int getLimite() {
        return limite;
    }

    public Object getRenegociacao() {
        return renegociacao;
    }

    public Object getVencimento() {
        return vencimento;
    }
}

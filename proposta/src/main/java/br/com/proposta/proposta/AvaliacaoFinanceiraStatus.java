package br.com.proposta.proposta;

import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

public enum AvaliacaoFinanceiraStatus {
    NAO_PROCESSADO("NAO_PROCESSADO"),
    ERRO_PROCESSAR("ERRO_PROCESSAR"),
    COM_RESTRICAO("NAO_ELEGIVEL"),
    SEM_RESTRICAO("ELEGIVEL");

    private String status;

    AvaliacaoFinanceiraStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

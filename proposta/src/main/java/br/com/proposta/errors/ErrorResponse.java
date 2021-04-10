package br.com.proposta.errors;

import org.springframework.validation.FieldError;

public class ErrorResponse {
    private String campo;
    private String erro;

    public ErrorResponse(FieldError error) {
        this.campo = error.getField();
        this.erro = error.getDefaultMessage();
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}

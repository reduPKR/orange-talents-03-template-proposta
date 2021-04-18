package br.com.proposta.biometria;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.validation.constraints.NotNull;

public class BiometriaRequest {
    @NotNull
    private String biometria;

    public String getBiometria() {
        return biometria;
    }

    public boolean validar() {
        return Base64.isBase64(this.biometria);
    }


    public Biometria toModel(String cartaoId) {
        return new Biometria(cartaoId, this.biometria);
    }
}

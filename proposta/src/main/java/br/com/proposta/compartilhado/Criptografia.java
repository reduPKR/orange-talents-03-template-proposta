package br.com.proposta.compartilhado;

import java.util.Base64;

public class Criptografia {
    public static String encriptar(String mensagem){
        return Base64.getEncoder().encodeToString(mensagem.getBytes());
    }

    public static String desencriptar(String mensagem) {
        byte[] bytes = Base64.getDecoder().decode(mensagem.getBytes());
        return new String(bytes);
    }
}

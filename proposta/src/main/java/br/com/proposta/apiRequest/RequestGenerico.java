package br.com.proposta.apiRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestGenerico {
    @JsonProperty("idProposta")
    private String idProposta;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("documento")
    private String documento;

    public RequestGenerico() {
    }

    public RequestGenerico(String idProposta, String nome, String documento) {
        this.idProposta = idProposta;
        this.nome = nome;
        this.documento = documento;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }
}

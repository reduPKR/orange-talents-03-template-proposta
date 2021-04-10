package br.com.proposta.proposta.documento;

public enum TipoPessoa {
    FISICA(CpfGroup.class),
    JURIDICA(CnpjGroup.class);

    private final Class<?> group;

    TipoPessoa(Class<?> group) {
        this.group = group;
    }

    public Class<?> getGroup() {
        return group;
    }
}

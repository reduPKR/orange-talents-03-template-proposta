package br.com.proposta.proposta.documento;

public enum TipoPessoa {
    CPF(CpfGroup.class),
    CNPJ(CnpjGroup.class);

    private final Class<?> group;

    TipoPessoa(Class<?> group) {
        this.group = group;
    }

    public Class<?> getGroup() {
        return group;
    }
}

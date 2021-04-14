package br.com.proposta.proposta;

import br.com.proposta.endereco.Endereco;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    @Min(0)
    private BigDecimal salario;
    @NotNull
    private String documento;
    @Enumerated(EnumType.STRING)
    private AvaliacaoFinanceiraStatus avaliacaoFinanceiraStatus = AvaliacaoFinanceiraStatus.NAO_PROCESSADO;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;

    public Proposta() {
    }

    public Proposta(@NotNull String nome, @NotNull String email, @NotNull @Min(0) BigDecimal salario, @NotNull String documento, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.documento = documento;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getDocumento() {
        return documento;
    }

    public AvaliacaoFinanceiraStatus getAvaliacaoFinanceira() {
        return avaliacaoFinanceiraStatus;
    }

    public void atualizarAvaliacaoFinanceira(AvaliacaoFinanceiraStatus avaliacaoFinanceiraStatus) {
        this.avaliacaoFinanceiraStatus = avaliacaoFinanceiraStatus;
    }

    public String getAvaliacaoFinanceiraStatus() {
        return avaliacaoFinanceiraStatus.getStatus();
    }
}

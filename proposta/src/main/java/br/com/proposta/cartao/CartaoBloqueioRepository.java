package br.com.proposta.cartao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaoBloqueioRepository extends JpaRepository<CartaoBloqueio, String> {
    Optional<CartaoBloqueio> findByCartaoId(String cartaoId);
}

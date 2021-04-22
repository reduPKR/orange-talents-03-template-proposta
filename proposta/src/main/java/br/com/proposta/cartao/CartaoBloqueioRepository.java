package br.com.proposta.cartao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoBloqueioRepository extends JpaRepository<CartaoBloqueio, String> {
}

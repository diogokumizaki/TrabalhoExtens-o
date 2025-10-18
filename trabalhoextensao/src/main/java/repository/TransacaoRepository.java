package repository;

import models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {
    List<Transacao> findByUsuarioId(UUID usuarioId);
    List<Transacao> findByCategoriaId(UUID categoriaId);
}

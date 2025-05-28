package com.maria.firealert.firealert_api.repository;

import com.maria.firealert.firealert_api.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
    List<Notificacao> findByTipoIgnoreCase(String tipo);
}

package br.com.ghasilva.ghlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ghasilva.ghlog.api.model.Entrega;


@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{

}

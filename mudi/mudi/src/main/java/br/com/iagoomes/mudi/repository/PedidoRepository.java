package br.com.iagoomes.mudi.repository;

import br.com.iagoomes.mudi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Override
    List<Pedido> findAll();
}

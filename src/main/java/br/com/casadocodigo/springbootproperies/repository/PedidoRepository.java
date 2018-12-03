package br.com.casadocodigo.springbootproperies.repository;

import br.com.casadocodigo.springbootproperies.domain.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}

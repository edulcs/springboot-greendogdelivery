package br.com.casadocodigo.springbootproperies.repository;

import br.com.casadocodigo.springbootproperies.domain.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}

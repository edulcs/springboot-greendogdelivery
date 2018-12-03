package br.com.casadocodigo.springbootproperies.repository;

import br.com.casadocodigo.springbootproperies.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

}

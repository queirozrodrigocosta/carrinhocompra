package com.example.carrinhocompra;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "plano", path = "plano")
public interface PlanoRepository extends MongoRepository<Plano, String>{

	List<Plano> findByTipo(@Param("tipo") TipoPlano tipo);
	
	 List<Plano> findByValorLessThan(@Param("valor") BigDecimal valor);
}

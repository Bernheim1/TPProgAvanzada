package com.javainuse.dao;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.javainuse.model.Cliente;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long>{

	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE clientes SET nombre = :nombre, apellido = :apellido, edad = :edad WHERE id = :id")
	void updateById(@Param("nombre") String nombre, @Param("apellido") String apellido, @Param("edad") int edad, @Param("id") Long id);
}

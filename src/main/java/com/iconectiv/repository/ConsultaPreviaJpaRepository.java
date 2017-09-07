package com.iconectiv.repository;

import org.springframework.data.repository.CrudRepository;

import com.iconectiv.modelo.ConsultaPrevia;

public interface ConsultaPreviaJpaRepository extends CrudRepository<ConsultaPrevia, Long> {
	
	ConsultaPrevia findByIdentificadorMensaje(String identificadorMensaje);

}

package com.iconectiv.service;

import java.util.List;

import com.iconectiv.modelo.ConsultaPrevia;

public interface ConsultaPreviaService {
	
	ConsultaPrevia findById(Long id);
	
	ConsultaPrevia findByIdentificadorMensaje(String identificadorMensaje);
	
	List<ConsultaPrevia> findAllConsultaPrevia();
	
	void saveConsultaPrevia(ConsultaPrevia consultaPrevia);
	
	void updateConsultaPrevia(ConsultaPrevia consultaPrevia);
	
	void deleteConsultaPreviaById(Long id);
	
	void deleteAllConsultaPrevia();
	
	boolean isConsultaPreviaExist(ConsultaPrevia consultaPrevia);
}

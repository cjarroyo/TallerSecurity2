package com.iconectiv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iconectiv.modelo.ConsultaPrevia;
import com.iconectiv.repository.ConsultaPreviaJpaRepository;
import com.iconectiv.service.ConsultaPreviaService;

@Service
@Transactional
public class ConsultaPreviaServiceImpl implements ConsultaPreviaService {
	
	@Autowired
	private ConsultaPreviaJpaRepository consultaPreviaJpaRepository;

	@Override
	public ConsultaPrevia findById(Long id) {
		return consultaPreviaJpaRepository.findOne(id);
	}
	
	@Override
	public ConsultaPrevia findByIdentificadorMensaje(String identificadorMensaje) {
		return consultaPreviaJpaRepository.findByIdentificadorMensaje(identificadorMensaje);
	}

	@Override
	public List<ConsultaPrevia> findAllConsultaPrevia() {
		return (List<ConsultaPrevia>) consultaPreviaJpaRepository.findAll();
	}

	@Override
	public void saveConsultaPrevia(ConsultaPrevia cuerpoMensaje) {
		consultaPreviaJpaRepository.save(cuerpoMensaje);
	}

	@Override
	public void updateConsultaPrevia(ConsultaPrevia cuerpoMensaje) {
		consultaPreviaJpaRepository.save(cuerpoMensaje);
		
	}

	@Override
	public void deleteConsultaPreviaById(Long id) {
		consultaPreviaJpaRepository.delete(id);
	}

	@Override
	public void deleteAllConsultaPrevia() {
		consultaPreviaJpaRepository.deleteAll();
		
	}

	@Override
	public boolean isConsultaPreviaExist(ConsultaPrevia consultaPrevia) {
		return findByIdentificadorMensaje(consultaPrevia.getIdentificadorMensaje()) !=  null;
	}
}

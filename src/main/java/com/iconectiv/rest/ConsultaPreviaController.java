package com.iconectiv.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.iconectiv.modelo.ConsultaPrevia;
import com.iconectiv.service.ConsultaPreviaService;

@RestController
public class ConsultaPreviaController {

	@Autowired
	private ConsultaPreviaService consultaPreviaService;

	@RequestMapping(value = "/consulta/", method = RequestMethod.GET)
	public ResponseEntity<List<ConsultaPrevia>> listarAllConsultaPrevia() {

		List<ConsultaPrevia> consultas = consultaPreviaService.findAllConsultaPrevia();
		if (consultas.isEmpty()) {
			return new ResponseEntity<List<ConsultaPrevia>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ConsultaPrevia>>(consultas, HttpStatus.OK);
	}

	@RequestMapping(value = "/consulta/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConsultaPrevia> getConsultaPrevia(@PathVariable("id") long id) {
		ConsultaPrevia consultaPrevia = consultaPreviaService.findById(id);
		if (consultaPrevia == null) {
			return new ResponseEntity<ConsultaPrevia>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ConsultaPrevia>(consultaPrevia, HttpStatus.OK);
	}

	@RequestMapping(value = "/consulta/", method = RequestMethod.POST)
	public ResponseEntity<Void> createConsultaPrevia(@RequestBody ConsultaPrevia consultaPrevia, UriComponentsBuilder ucBuilder) {
		if (consultaPreviaService.isConsultaPreviaExist(consultaPrevia)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		consultaPrevia.setCreatedBy(getUserAuthenticated());
		consultaPrevia.setCreatedDate(new Date());
		
		consultaPreviaService.saveConsultaPrevia(consultaPrevia);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/consulta/{id}").buildAndExpand(consultaPrevia.getId()).toUri());
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	private String getUserAuthenticated(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}

	@RequestMapping(value = "/consulta/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ConsultaPrevia> updateConsultaPrevia(@PathVariable("id") long id, @RequestBody ConsultaPrevia consultaPrevia) {
		ConsultaPrevia currentConsultaPrevia = consultaPreviaService.findById(id);
		if (currentConsultaPrevia == null) {
			return new ResponseEntity<ConsultaPrevia>(HttpStatus.NOT_FOUND);
		}
		currentConsultaPrevia.setIdentificadorMensaje(consultaPrevia.getIdentificadorMensaje());
		currentConsultaPrevia.setRemitente(consultaPrevia.getRemitente());
		currentConsultaPrevia.setDestinatario(consultaPrevia.getDestinatario());
		currentConsultaPrevia.setFechaCreacionMensaje(consultaPrevia.getFechaCreacionMensaje());
		currentConsultaPrevia.setIdentificadorProceso(consultaPrevia.getIdentificadorProceso());
		
		currentConsultaPrevia.setIdMensaje(consultaPrevia.getIdMensaje());
		currentConsultaPrevia.setCodigoReceptor(consultaPrevia.getCodigoReceptor());
		currentConsultaPrevia.setCodigoCedente(consultaPrevia.getCodigoCedente());
		currentConsultaPrevia.setTipoDocumentoIdentidad(consultaPrevia.getTipoDocumentoIdentidad());
		currentConsultaPrevia.setNumeroDocumentoIdentidad(consultaPrevia.getNumeroDocumentoIdentidad());
		currentConsultaPrevia.setCantidadNumeraciones(consultaPrevia.getCantidadNumeraciones());
		currentConsultaPrevia.setObservaciones(consultaPrevia.getObservaciones());
		currentConsultaPrevia.setNombreContacto(consultaPrevia.getNombreContacto());
		currentConsultaPrevia.setEmailContacto(consultaPrevia.getEmailContacto());
		currentConsultaPrevia.setTelefonoContacto(consultaPrevia.getTelefonoContacto());
		currentConsultaPrevia.setFaxContacto(consultaPrevia.getFaxContacto());
		currentConsultaPrevia.setTipoServicio(consultaPrevia.getTipoServicio());
		currentConsultaPrevia.setCliente(consultaPrevia.getCliente());
		
		currentConsultaPrevia.setInicioRango(consultaPrevia.getInicioRango());
		currentConsultaPrevia.setFinalRango(consultaPrevia.getFinalRango());
		currentConsultaPrevia.setTipoPortabilidad(consultaPrevia.getTipoPortabilidad());
		
		currentConsultaPrevia.setUpdatedBy(getUserAuthenticated());
		currentConsultaPrevia.setUpdatedDate(new Date());

		consultaPreviaService.updateConsultaPrevia(currentConsultaPrevia);
		
		return new ResponseEntity<ConsultaPrevia>(currentConsultaPrevia, HttpStatus.OK);
	}

	@RequestMapping(value = "/consulta/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ConsultaPrevia> deleteConsultaPrevia(@PathVariable("id") long id) {
		ConsultaPrevia consultaPrevia = consultaPreviaService.findById(id);
		if (consultaPrevia == null) {
			// System.out.println("Unable to delete. Customer with id " + id + "
			// not found");
			return new ResponseEntity<ConsultaPrevia>(HttpStatus.NOT_FOUND);
		}
		consultaPreviaService.deleteConsultaPreviaById(id);
		return new ResponseEntity<ConsultaPrevia>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/consulta/", method = RequestMethod.DELETE)
	public ResponseEntity<ConsultaPrevia> deleteAllConsultaPrevia() {

		consultaPreviaService.deleteAllConsultaPrevia();
		return new ResponseEntity<ConsultaPrevia>(HttpStatus.NO_CONTENT);
	}

}

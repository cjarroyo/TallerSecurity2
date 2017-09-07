package com.iconectiv.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.iconectiv.modelo.base.AuditingEntity;
import com.iconectiv.modelo.base.BaseEntity;

@Entity
public class ConsultaPrevia extends AuditingEntity implements Serializable, BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 

	//cabecera
	@Column(name = "identificador_mensaje")
	private String identificadorMensaje;
	
	private String remitente;
	
	private String destinatario;
	
	@Column(name = "fecha_creacion_mensaje")
	private String fechaCreacionMensaje;
	
	@Column(name = "identificador_proceso")
	private String identificadorProceso;
	
	//cuerpo
	@Column(name = "id_mensaje")
	private String idMensaje;

	@Column(name = "codigo_receptor")
	private String codigoReceptor;
	
	@Column(name = "codigo_cedente")
	private String codigoCedente;
	
	@Column(name = "tipo_documento_identidad")
	private String tipoDocumentoIdentidad;
	
	@Column(name = "numero_documento_identidad")
	private String numeroDocumentoIdentidad;
	
	@Column(name = "cantidad_numeraciones")
	private String cantidadNumeraciones;

	private String observaciones;
	
	@Column(name = "nombre_contacto")
	private String nombreContacto;
	
	@Column(name = "email_contacto")
	private String emailContacto;
	
	@Column(name = "telefono_contacto")
	private String telefonoContacto;
	
	@Column(name = "fax_contacto")
	private String faxContacto;
	
	@Column(name = "tipo_servicio")
	private String tipoServicio;
	
	private String cliente;
	
	//numeracion
	@Column(name = "inicio_rango")
	private String inicioRango;
	
	@Column(name = "final_rango")
	private String finalRango;
	
	@Column(name = "tipo_portabilidad")
	private String tipoPortabilidad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificadorMensaje() {
		return identificadorMensaje;
	}

	public void setIdentificadorMensaje(String identificadorMensaje) {
		this.identificadorMensaje = identificadorMensaje;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getFechaCreacionMensaje() {
		return fechaCreacionMensaje;
	}

	public void setFechaCreacionMensaje(String fechaCreacionMensaje) {
		this.fechaCreacionMensaje = fechaCreacionMensaje;
	}

	public String getIdentificadorProceso() {
		return identificadorProceso;
	}

	public void setIdentificadorProceso(String identificadorProceso) {
		this.identificadorProceso = identificadorProceso;
	}

	public String getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(String idMensaje) {
		this.idMensaje = idMensaje;
	}

	public String getCodigoReceptor() {
		return codigoReceptor;
	}

	public void setCodigoReceptor(String codigoReceptor) {
		this.codigoReceptor = codigoReceptor;
	}

	public String getCodigoCedente() {
		return codigoCedente;
	}

	public void setCodigoCedente(String codigoCedente) {
		this.codigoCedente = codigoCedente;
	}

	public String getTipoDocumentoIdentidad() {
		return tipoDocumentoIdentidad;
	}

	public void setTipoDocumentoIdentidad(String tipoDocumentoIdentidad) {
		this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
	}

	public String getNumeroDocumentoIdentidad() {
		return numeroDocumentoIdentidad;
	}

	public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
		this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
	}

	public String getCantidadNumeraciones() {
		return cantidadNumeraciones;
	}

	public void setCantidadNumeraciones(String cantidadNumeraciones) {
		this.cantidadNumeraciones = cantidadNumeraciones;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getEmailContacto() {
		return emailContacto;
	}

	public void setEmailContacto(String emailContacto) {
		this.emailContacto = emailContacto;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getFaxContacto() {
		return faxContacto;
	}

	public void setFaxContacto(String faxContacto) {
		this.faxContacto = faxContacto;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getInicioRango() {
		return inicioRango;
	}

	public void setInicioRango(String inicioRango) {
		this.inicioRango = inicioRango;
	}

	public String getFinalRango() {
		return finalRango;
	}

	public void setFinalRango(String finalRango) {
		this.finalRango = finalRango;
	}

	public String getTipoPortabilidad() {
		return tipoPortabilidad;
	}

	public void setTipoPortabilidad(String tipoPortabilidad) {
		this.tipoPortabilidad = tipoPortabilidad;
	}

}

package com.selvamonos.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="turistas")
public class Turista {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id")
	 protected int id;
	 
	 @Column(name="nombre")
	 protected String nombre;
	 
	 @Column(name="apellido")
	 protected String apellido;
	 
	 @Column(name="doc_indentidad")
	 protected String docIdentidad;
	 
	 @Column(name="fec_nacimiento")
	 protected Date fecNacimiento;
	 
	 @Column(name="pais")
	 protected String pais;
	 
	 @Column(name="ciudad_visita")
	 protected String ciudadVisita;
	 
	 @Column(name="nom_hospedaje")
	 protected String nomHospedaje;
	 
	 @Column(name="costo_tour")
	 protected double costoTour;
	 
	 @Column(name="email")
	 protected String email;
	 
	 @Column(name="fec_inicio")
	 protected Date fecInicio;
	 
	 @Column(name="fec_final")
	 protected Date fecFinal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDocIdentidad() {
		return docIdentidad;
	}

	public void setDocIdentidad(String docIdentidad) {
		this.docIdentidad = docIdentidad;
	}

	public Date getFecNacimiento() {
		return fecNacimiento;
	}

	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudadVisita() {
		return ciudadVisita;
	}

	public void setCiudadVisita(String ciudadVisita) {
		this.ciudadVisita = ciudadVisita;
	}

	public String getNomHospedaje() {
		return nomHospedaje;
	}

	public void setNomHospedaje(String nomHospedaje) {
		this.nomHospedaje = nomHospedaje;
	}

	public double getCostoTour() {
		return costoTour;
	}

	public void setCostoTour(double costoTour) {
		this.costoTour = costoTour;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFecInicio() {
		return fecInicio;
	}

	public void setFecInicio(Date fecInicio) {
		this.fecInicio = fecInicio;
	}

	public Date getFecFinal() {
		return fecFinal;
	}

	public void setFecFinal(Date fecFinal) {
		this.fecFinal = fecFinal;
	}

	public Turista(String nombre, String apellido, String docIdentidad, Date fecNacimiento, String pais,
			String ciudadVisita, String nomHospedaje, double costoTour, String email, Date fecInicio, Date fecFinal) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.docIdentidad = docIdentidad;
		this.fecNacimiento = fecNacimiento;
		this.pais = pais;
		this.ciudadVisita = ciudadVisita;
		this.nomHospedaje = nomHospedaje;
		this.costoTour = costoTour;
		this.email = email;
		this.fecInicio = fecInicio;
		this.fecFinal = fecFinal;
	}

	

	 

}

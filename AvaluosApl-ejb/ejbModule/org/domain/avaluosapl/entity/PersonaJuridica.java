package org.domain.avaluosapl.entity;

// Generated 24/03/2015 11:16:57 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * PersonaJuridica generated by hbm2java
 */
@Entity
@Table(name = "persona_juridica", catalog = "db_acinversiones", uniqueConstraints = @UniqueConstraint(columnNames = "NIT"))
public class PersonaJuridica implements java.io.Serializable {

	private Integer idPersonaJuridica;
	private Cliente cliente;
	private ActEconomica actEconomica;
	private String nit;
	private String razonSocial;
	private String nombreComercial;

	public PersonaJuridica() {
	}

	public PersonaJuridica(Cliente cliente, ActEconomica actEconomica,
			String nit, String razonSocial, String nombreComercial) {
		this.cliente = cliente;
		this.actEconomica = actEconomica;
		this.nit = nit;
		this.razonSocial = razonSocial;
		this.nombreComercial = nombreComercial;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_persona_juridica", unique = true, nullable = false)
	public Integer getIdPersonaJuridica() {
		return this.idPersonaJuridica;
	}

	public void setIdPersonaJuridica(Integer idPersonaJuridica) {
		this.idPersonaJuridica = idPersonaJuridica;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_responsable", nullable = false)
	@NotNull
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_act_economica", nullable = false)
	@NotNull
	public ActEconomica getActEconomica() {
		return this.actEconomica;
	}

	public void setActEconomica(ActEconomica actEconomica) {
		this.actEconomica = actEconomica;
	}

	@Column(name = "NIT", unique = true, nullable = false, length = 25)
	@NotNull
	@Length(max = 25)
	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	@Column(name = "razon_social", nullable = false, length = 120)
	@NotNull
	@Length(max = 120)
	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Column(name = "nombre_comercial", nullable = false, length = 120)
	@NotNull
	@Length(max = 120)
	public String getNombreComercial() {
		return this.nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

}

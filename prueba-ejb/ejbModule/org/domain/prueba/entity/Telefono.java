package org.domain.prueba.entity;

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
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Telefono generated by hbm2java
 */
@Entity
@Table(name = "telefono", catalog = "db_acinversiones")
public class Telefono implements java.io.Serializable {

	private Integer idTelefono;
	private TipoTel tipoTel;
	private Persona persona;
	private String numero;

	public Telefono() {
	}

	public Telefono(TipoTel tipoTel, Persona persona, String numero) {
		this.tipoTel = tipoTel;
		this.persona = persona;
		this.numero = numero;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_telefono", unique = true, nullable = false)
	public Integer getIdTelefono() {
		return this.idTelefono;
	}

	public void setIdTelefono(Integer idTelefono) {
		this.idTelefono = idTelefono;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_tel_tel", nullable = false)
	@NotNull
	public TipoTel getTipoTel() {
		return this.tipoTel;
	}

	public void setTipoTel(TipoTel tipoTel) {
		this.tipoTel = tipoTel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tel_persona", nullable = false)
	@NotNull
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Column(name = "numero", nullable = false, length = 25)
	@NotNull
	@Length(max = 25)
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
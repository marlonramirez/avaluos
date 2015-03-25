package org.domain.prueba.entity;

// Generated 24/03/2015 11:16:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * ActEconomica generated by hbm2java
 */
@Entity
@Table(name = "act_economica", catalog = "db_acinversiones")
public class ActEconomica implements java.io.Serializable {

	private int idActEconomica;
	private String descripcion;
	private Set<PersonaJuridica> personaJuridicas = new HashSet<PersonaJuridica>(
			0);

	public ActEconomica() {
	}

	public ActEconomica(int idActEconomica, String descripcion) {
		this.idActEconomica = idActEconomica;
		this.descripcion = descripcion;
	}

	public ActEconomica(int idActEconomica, String descripcion,
			Set<PersonaJuridica> personaJuridicas) {
		this.idActEconomica = idActEconomica;
		this.descripcion = descripcion;
		this.personaJuridicas = personaJuridicas;
	}

	@Id
	@Column(name = "id_act_economica", unique = true, nullable = false)
	public int getIdActEconomica() {
		return this.idActEconomica;
	}

	public void setIdActEconomica(int idActEconomica) {
		this.idActEconomica = idActEconomica;
	}

	@Column(name = "descripcion", nullable = false, length = 250)
	@NotNull
	@Length(max = 250)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actEconomica")
	public Set<PersonaJuridica> getPersonaJuridicas() {
		return this.personaJuridicas;
	}

	public void setPersonaJuridicas(Set<PersonaJuridica> personaJuridicas) {
		this.personaJuridicas = personaJuridicas;
	}

}

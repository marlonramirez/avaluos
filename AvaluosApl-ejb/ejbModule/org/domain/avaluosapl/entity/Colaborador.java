package org.domain.avaluosapl.entity;

// Generated 24/03/2015 11:16:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.NotNull;

/**
 * Colaborador generated by hbm2java
 */
@Entity
@Table(name = "colaborador", catalog = "db_acinversiones")
public class Colaborador implements java.io.Serializable {

	private int idColaboradorPersona;
	private TipoContrato tipoContrato;
	private AreaConoc areaConoc;
	private Cargo cargo;
	private Persona persona;
	private Calificacion calificacion;
	private Set<Competencia> competencias = new HashSet<Competencia>(0);

	public Colaborador() {
	}

	public Colaborador(TipoContrato tipoContrato, AreaConoc areaConoc,
			Cargo cargo, Persona persona, Calificacion calificacion) {
		this.tipoContrato = tipoContrato;
		this.areaConoc = areaConoc;
		this.cargo = cargo;
		this.persona = persona;
		this.calificacion = calificacion;
	}

	public Colaborador(TipoContrato tipoContrato, AreaConoc areaConoc,
			Cargo cargo, Persona persona, Calificacion calificacion,
			Set<Competencia> competencias) {
		this.tipoContrato = tipoContrato;
		this.areaConoc = areaConoc;
		this.cargo = cargo;
		this.persona = persona;
		this.calificacion = calificacion;
		this.competencias = competencias;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "persona"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id_colaborador_persona", unique = true, nullable = false)
	public int getIdColaboradorPersona() {
		return this.idColaboradorPersona;
	}

	public void setIdColaboradorPersona(int idColaboradorPersona) {
		this.idColaboradorPersona = idColaboradorPersona;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_contrato", nullable = false)
	@NotNull
	public TipoContrato getTipoContrato() {
		return this.tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_area_conoc", nullable = false)
	@NotNull
	public AreaConoc getAreaConoc() {
		return this.areaConoc;
	}

	public void setAreaConoc(AreaConoc areaConoc) {
		this.areaConoc = areaConoc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_colabo_cargo", nullable = false)
	@NotNull
	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@NotNull
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_colab_calificacion", nullable = false)
	@NotNull
	public Calificacion getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colaborador")
	public Set<Competencia> getCompetencias() {
		return this.competencias;
	}

	public void setCompetencias(Set<Competencia> competencias) {
		this.competencias = competencias;
	}

}

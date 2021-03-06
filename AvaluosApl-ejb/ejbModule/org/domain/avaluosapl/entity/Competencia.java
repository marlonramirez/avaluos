package org.domain.avaluosapl.entity;

// Generated 28/03/2015 08:34:58 PM by Hibernate Tools 3.4.0.CR1

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
 * Competencia generated by hbm2java
 */
@Entity
@Table(name = "competencia", catalog = "db_acinversiones")
public class Competencia implements java.io.Serializable {

	private Integer idCompetencia;
	private Colaborador colaborador;
	private String descripcion;

	public Competencia() {
	}

	public Competencia(Colaborador colaborador, String descripcion) {
		this.colaborador = colaborador;
		this.descripcion = descripcion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_competencia", unique = true, nullable = false)
	public Integer getIdCompetencia() {
		return this.idCompetencia;
	}

	public void setIdCompetencia(Integer idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_colab_persona", nullable = false)
	@NotNull
	public Colaborador getColaborador() {
		return this.colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	@Column(name = "descripcion", nullable = false, length = 1500)
	@NotNull
	@Length(max = 1500)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}

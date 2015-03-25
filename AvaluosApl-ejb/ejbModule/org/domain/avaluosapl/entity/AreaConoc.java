package org.domain.avaluosapl.entity;

// Generated 24/03/2015 11:16:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * AreaConoc generated by hbm2java
 */
@Entity
@Table(name = "area_conoc", catalog = "db_acinversiones")
public class AreaConoc implements java.io.Serializable {

	private Integer idAreaConoc;
	private String descripcion;
	private Set<Colaborador> colaboradors = new HashSet<Colaborador>(0);

	public AreaConoc() {
	}

	public AreaConoc(String descripcion) {
		this.descripcion = descripcion;
	}

	public AreaConoc(String descripcion, Set<Colaborador> colaboradors) {
		this.descripcion = descripcion;
		this.colaboradors = colaboradors;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_area_conoc", unique = true, nullable = false)
	public Integer getIdAreaConoc() {
		return this.idAreaConoc;
	}

	public void setIdAreaConoc(Integer idAreaConoc) {
		this.idAreaConoc = idAreaConoc;
	}

	@Column(name = "descripcion", nullable = false, length = 120)
	@NotNull
	@Length(max = 120)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "areaConoc")
	public Set<Colaborador> getColaboradors() {
		return this.colaboradors;
	}

	public void setColaboradors(Set<Colaborador> colaboradors) {
		this.colaboradors = colaboradors;
	}

}

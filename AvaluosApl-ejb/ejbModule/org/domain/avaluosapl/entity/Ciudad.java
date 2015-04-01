package org.domain.avaluosapl.entity;

// Generated 31/03/2015 09:26:39 AM by Hibernate Tools 3.4.0.CR1

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
 * Ciudad generated by hbm2java
 */
@Entity
@Table(name = "ciudad", catalog = "db_acinversiones")
public class Ciudad implements java.io.Serializable {

	private Integer ciudadId;
	private String abbr;
	private String nombre;
	private Set<Avaluo> avaluos = new HashSet<Avaluo>(0);

	public Ciudad() {
	}

	public Ciudad(String abbr, String nombre) {
		this.abbr = abbr;
		this.nombre = nombre;
	}

	public Ciudad(String abbr, String nombre, Set<Avaluo> avaluos) {
		this.abbr = abbr;
		this.nombre = nombre;
		this.avaluos = avaluos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ciudad_id", unique = true, nullable = false)
	public Integer getCiudadId() {
		return this.ciudadId;
	}

	public void setCiudadId(Integer ciudadId) {
		this.ciudadId = ciudadId;
	}

	@Column(name = "abbr", nullable = false, length = 5)
	@NotNull
	@Length(max = 5)
	public String getAbbr() {
		return this.abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	@Column(name = "nombre", nullable = false, length = 60)
	@NotNull
	@Length(max = 60)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ciudad")
	public Set<Avaluo> getAvaluos() {
		return this.avaluos;
	}

	public void setAvaluos(Set<Avaluo> avaluos) {
		this.avaluos = avaluos;
	}

}

package org.domain.avaluosapl.entity;

// Generated 14/03/2015 10:40:33 PM by Hibernate Tools 3.4.0.CR1

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
 * TipoTel generated by hbm2java
 */
@Entity
@Table(name = "tipo_tel", catalog = "db_acinversiones")
public class TipoTel implements java.io.Serializable {

	private Integer idTipoTel;
	private String descripcion;
	private Set<Telefono> telefonos = new HashSet<Telefono>(0);

	public TipoTel() {
	}

	public TipoTel(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoTel(String descripcion, Set<Telefono> telefonos) {
		this.descripcion = descripcion;
		this.telefonos = telefonos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_tipo_tel", unique = true, nullable = false)
	public Integer getIdTipoTel() {
		return this.idTipoTel;
	}

	public void setIdTipoTel(Integer idTipoTel) {
		this.idTipoTel = idTipoTel;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoTel")
	public Set<Telefono> getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

}
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
 * Ciudad generated by hbm2java
 */
@Entity
@Table(name = "ciudad", catalog = "db_acinversiones")
public class Ciudad implements java.io.Serializable {

	private Integer ciudadId;
	private String nombre;
	private Set<Factura> facturas = new HashSet<Factura>(0);

	public Ciudad() {
	}

	public Ciudad(String nombre) {
		this.nombre = nombre;
	}

	public Ciudad(String nombre, Set<Factura> facturas) {
		this.nombre = nombre;
		this.facturas = facturas;
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
	public Set<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(Set<Factura> facturas) {
		this.facturas = facturas;
	}

}

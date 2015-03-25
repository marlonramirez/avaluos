package org.domain.prueba.entity;

// Generated 24/03/2015 11:16:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Avaluo generated by hbm2java
 */
@Entity
@Table(name = "avaluo", catalog = "db_acinversiones", uniqueConstraints = @UniqueConstraint(columnNames = "num_orden"))
public class Avaluo implements java.io.Serializable {

	private Integer idAvaluo;
	private Activo activo;
	private String numOrden;
	private Date fechaSolicitud;
	private String descripcion;
	private Date fechaEntrega;
	private double valorRazonable;
	private Integer idAsesor;
	private Integer idGerente;
	private Set<ItemAvaluo> itemAvaluos = new HashSet<ItemAvaluo>(0);

	public Avaluo() {
	}

	public Avaluo(Activo activo, String numOrden, Date fechaSolicitud,
			String descripcion, double valorRazonable) {
		this.activo = activo;
		this.numOrden = numOrden;
		this.fechaSolicitud = fechaSolicitud;
		this.descripcion = descripcion;
		this.valorRazonable = valorRazonable;
	}

	public Avaluo(Activo activo, String numOrden, Date fechaSolicitud,
			String descripcion, Date fechaEntrega, double valorRazonable,
			Integer idAsesor, Integer idGerente, Set<ItemAvaluo> itemAvaluos) {
		this.activo = activo;
		this.numOrden = numOrden;
		this.fechaSolicitud = fechaSolicitud;
		this.descripcion = descripcion;
		this.fechaEntrega = fechaEntrega;
		this.valorRazonable = valorRazonable;
		this.idAsesor = idAsesor;
		this.idGerente = idGerente;
		this.itemAvaluos = itemAvaluos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_avaluo", unique = true, nullable = false)
	public Integer getIdAvaluo() {
		return this.idAvaluo;
	}

	public void setIdAvaluo(Integer idAvaluo) {
		this.idAvaluo = idAvaluo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_activo_av", nullable = false)
	@NotNull
	public Activo getActivo() {
		return this.activo;
	}

	public void setActivo(Activo activo) {
		this.activo = activo;
	}

	@Column(name = "num_orden", unique = true, nullable = false, length = 25)
	@NotNull
	@Length(max = 25)
	public String getNumOrden() {
		return this.numOrden;
	}

	public void setNumOrden(String numOrden) {
		this.numOrden = numOrden;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_solicitud", nullable = false, length = 0)
	@NotNull
	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_entrega", length = 0)
	public Date getFechaEntrega() {
		return this.fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	@Column(name = "valor_razonable", nullable = false, precision = 22, scale = 0)
	public double getValorRazonable() {
		return this.valorRazonable;
	}

	public void setValorRazonable(double valorRazonable) {
		this.valorRazonable = valorRazonable;
	}

	@Column(name = "id_asesor")
	public Integer getIdAsesor() {
		return this.idAsesor;
	}

	public void setIdAsesor(Integer idAsesor) {
		this.idAsesor = idAsesor;
	}

	@Column(name = "id_gerente")
	public Integer getIdGerente() {
		return this.idGerente;
	}

	public void setIdGerente(Integer idGerente) {
		this.idGerente = idGerente;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "avaluo")
	public Set<ItemAvaluo> getItemAvaluos() {
		return this.itemAvaluos;
	}

	public void setItemAvaluos(Set<ItemAvaluo> itemAvaluos) {
		this.itemAvaluos = itemAvaluos;
	}

}
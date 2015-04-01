package org.domain.avaluosapl.entity;

// Generated 31/03/2015 09:26:39 AM by Hibernate Tools 3.4.0.CR1

import java.util.Calendar;
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
	private Ciudad ciudad;
	private String numOrden;
	private Date fechaSolicitud;
	private String descripcion;
	private Date fechaVenc;
	private Date fechaEntrega;
	private Double valorRazonable;
	private Integer idAsesor;
	private Integer idGerente;
	private Set<ItemAvaluo> itemAvaluos = new HashSet<ItemAvaluo>(0);

	public Avaluo() {
	}

	public Avaluo(Activo activo, Ciudad ciudad, String numOrden,
			Date fechaSolicitud, String descripcion, Double valorRazonable) {
		this.activo = activo;
		this.ciudad = ciudad;
		this.numOrden = numOrden;
		this.fechaSolicitud = fechaSolicitud;
		this.descripcion = descripcion;
		this.valorRazonable = valorRazonable;
	}

	public Avaluo(Activo activo, Ciudad ciudad, String numOrden,
			Date fechaSolicitud, String descripcion, Date fechaVenc,
			Date fechaEntrega, Double valorRazonable, Integer idAsesor,
			Integer idGerente, Set<ItemAvaluo> itemAvaluos) {
		this.activo = activo;
		this.ciudad = ciudad;
		this.numOrden = numOrden;
		this.fechaSolicitud = fechaSolicitud;
		this.descripcion = descripcion;
		this.fechaVenc = fechaVenc;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ciudad_id", nullable = false)
	@NotNull
	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
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
		Calendar fechaVenc = Calendar.getInstance();
		fechaVenc.setTime(fechaSolicitud);
		fechaVenc.add(Calendar.YEAR, 1);
		this.fechaVenc = fechaVenc.getTime();
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
	@Column(name = "fecha_venc", length = 0)
	public Date getFechaVenc() {
		return this.fechaVenc;
	}

	public void setFechaVenc(Date fechaVenc) {
		this.fechaVenc = fechaVenc;
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
	public Double getValorRazonable() {
		return this.valorRazonable;
	}

	public void setValorRazonable(Double valorRazonable) {
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

package org.domain.avaluosapl.entity;

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
import javax.persistence.UniqueConstraint;
import org.hibernate.validator.NotNull;

/**
 * Permiso generated by hbm2java
 */
@Entity
@Table(name = "permiso", catalog = "db_acinversiones", uniqueConstraints = @UniqueConstraint(columnNames = {
		"id_perfil_permiso", "id_caso_uso_permiso" }))
public class Permiso implements java.io.Serializable {

	private Integer idPermiso;
	private CasoUso casoUso;
	private Perfil perfil;
	private byte estado;

	public Permiso() {
	}

	public Permiso(CasoUso casoUso, Perfil perfil, byte estado) {
		this.casoUso = casoUso;
		this.perfil = perfil;
		this.estado = estado;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_permiso", unique = true, nullable = false)
	public Integer getIdPermiso() {
		return this.idPermiso;
	}

	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_caso_uso_permiso", nullable = false)
	@NotNull
	public CasoUso getCasoUso() {
		return this.casoUso;
	}

	public void setCasoUso(CasoUso casoUso) {
		this.casoUso = casoUso;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_perfil_permiso", nullable = false)
	@NotNull
	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Column(name = "estado", nullable = false)
	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

}

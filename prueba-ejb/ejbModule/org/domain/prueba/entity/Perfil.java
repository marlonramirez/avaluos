package org.domain.prueba.entity;

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
 * Perfil generated by hbm2java
 */
@Entity
@Table(name = "perfil", catalog = "db_acinversiones")
public class Perfil implements java.io.Serializable {

	private Integer idPerfil;
	private String nombre;
	private byte estado;
	private Set<Permiso> permisos = new HashSet<Permiso>(0);
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public Perfil() {
	}

	public Perfil(String nombre, byte estado) {
		this.nombre = nombre;
		this.estado = estado;
	}

	public Perfil(String nombre, byte estado, Set<Permiso> permisos,
			Set<Usuario> usuarios) {
		this.nombre = nombre;
		this.estado = estado;
		this.permisos = permisos;
		this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_perfil", unique = true, nullable = false)
	public Integer getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
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

	@Column(name = "estado", nullable = false)
	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
	public Set<Permiso> getPermisos() {
		return this.permisos;
	}

	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
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
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * ManoObra generated by hbm2java
 */
@Entity
@Table(name = "mano_obra", catalog = "db_acinversiones")
public class ManoObra implements java.io.Serializable {

	private Integer idManoObra;
	private ItemAvaluo itemAvaluo;
	private String descripcion;

	public ManoObra() {
	}

	public ManoObra(ItemAvaluo itemAvaluo, String descripcion) {
		this.itemAvaluo = itemAvaluo;
		this.descripcion = descripcion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_mano_obra", unique = true, nullable = false)
	public Integer getIdManoObra() {
		return this.idManoObra;
	}

	public void setIdManoObra(Integer idManoObra) {
		this.idManoObra = idManoObra;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_item_avaluo_mo", nullable = false)
	@NotNull
	public ItemAvaluo getItemAvaluo() {
		return this.itemAvaluo;
	}

	public void setItemAvaluo(ItemAvaluo itemAvaluo) {
		this.itemAvaluo = itemAvaluo;
	}

	@Column(name = "descripcion", nullable = false, length = 500)
	@NotNull
	@Length(max = 500)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}

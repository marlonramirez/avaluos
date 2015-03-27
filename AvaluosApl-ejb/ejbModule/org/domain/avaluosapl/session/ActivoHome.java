package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("activoHome")
public class ActivoHome extends EntityHome<Activo> {

	@In(create = true)
	TangibleHome tangibleHome;
	@In(create = true)
	ClienteHome clienteHome;
	@In(create = true)
	ClienteList clienteList;
	
	private Cliente cliente;
	private int tipo;

	public void setActivoIdActivo(Integer id) {
		setId(id);
	}

	public Integer getActivoIdActivo() {
		return (Integer) getId();
	}

	@Override
	protected Activo createInstance() {
		Activo activo = new Activo();
		cliente = new Cliente();
		cliente.setPersona(new Persona());
		return activo;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		Activo activo = getInstance();
		Cliente cliente = clienteHome.getDefinedInstance();
		if (cliente != null) {
			setCliente(cliente);
			getInstance().setIdCliente(cliente.getIdClientePersona());
		} else {
			int id = activo.getIdCliente();
			if (id!=0) {
				this.cliente = clienteList.getById(id);
			}
		}
		
		Tangible tangible = tangibleHome.getDefinedInstance();
		if (tangible != null) {
			getInstance().setTangible(tangible);
		} else {
			tangible = activo.getTangible();
			if (tangible != null) {
				tangibleHome.setInstance(tangible);
				this.tipo = 1;
			}
		}
		
	}

	public boolean isWired() {
		return true;
	}

	public Activo getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Avaluo> getAvaluos() {
		return getInstance() == null ? null : new ArrayList<Avaluo>(
				getInstance().getAvaluos());
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public void guardar() {
		persist();
		if (tipo == 1) {
			createTangible();
		}
	}
	
	public void actualizar() {
		update();
		Activo activo = getInstance();
		if (tipo == 0 && activo.getTangible() != null) {
			getEntityManager().remove(tangibleHome.getInstance());
			getEntityManager().flush();
			return;
		}
		if (tipo == 1) {
			if (activo.getTangible() == null) {
				createTangible();
				return;
			}
			getEntityManager().remove(tangibleHome.getInstance());
			getEntityManager().flush();
		}
	}
	
	private void createTangible() {
		Tangible tangible = tangibleHome.getInstance();
		tangible.setActivo(getInstance());
		getInstance().setTangible(tangible);
		getEntityManager().persist(tangible);
		getEntityManager().flush();
	}

}

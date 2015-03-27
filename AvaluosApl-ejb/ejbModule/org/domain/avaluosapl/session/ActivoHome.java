package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("activoHome")
public class ActivoHome extends EntityHome<Activo> {

	@In(create = true)
	TangibleHome tangibleHome;
	@In(create = true)
	ClienteHome clienteHome;
	
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
		getInstance();
		Cliente cliente = clienteHome.getDefinedInstance();
		if (cliente != null) {
			setCliente(cliente);
			getInstance().setIdCliente(cliente.getIdClientePersona());
		}
		Tangible tangible = tangibleHome.getDefinedInstance();
		if (tangible != null) {
			getInstance().setTangible(tangible);
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

}

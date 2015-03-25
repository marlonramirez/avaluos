package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("clienteHome")
public class ClienteHome extends EntityHome<Cliente> {

	@In(create = true)
	PersonaHome personaHome;

	public void setClienteIdClientePersona(Integer id) {
		setId(id);
	}

	public Integer getClienteIdClientePersona() {
		return (Integer) getId();
	}

	@Override
	protected Cliente createInstance() {
		Cliente cliente = new Cliente();
		return cliente;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Persona persona = personaHome.getDefinedInstance();
		if (persona != null) {
			getInstance().setPersona(persona);
		}
	}

	public boolean isWired() {
		if (getInstance().getPersona() == null)
			return false;
		return true;
	}

	public Cliente getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<PersonaJuridica> getPersonaJuridicas() {
		return getInstance() == null ? null : new ArrayList<PersonaJuridica>(
				getInstance().getPersonaJuridicas());
	}

}

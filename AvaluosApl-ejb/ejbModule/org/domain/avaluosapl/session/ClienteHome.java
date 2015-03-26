package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("clienteHome")
public class ClienteHome extends EntityHome<Cliente> {

	@In(create = true)
	PersonaHome personaHome;
	@In(create = true)
	PersonaJuridicaHome personaJuridicaHome;
	
	private int persona;

	public void setClienteIdClientePersona(Integer id) {
		setId(id);
	}

	public Integer getClienteIdClientePersona() {
		return (Integer) getId();
	}

	@Override
	protected Cliente createInstance() {
		Cliente cliente = new Cliente();
		cliente.setPersona(new Persona());
		return cliente;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		Cliente cliente = getInstance();
		Persona persona = personaHome.getDefinedInstance();
		if (persona != null) {
			getInstance().setPersona(persona);
		}
		Set<PersonaJuridica> pjs = cliente.getPersonaJuridicas();
		if (!pjs.isEmpty()) {
			personaJuridicaHome.setInstance(pjs.iterator().next());
			this.persona = 1;
		}
	}

	public boolean isWired() {
		if (getInstance().getPersona().getIdPersona() == null)
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

	public int getPersona() {
		return persona;
	}

	public void setPersona(int persona) {
		this.persona = persona;
	}
	
	public void guardar() {
		persist();
		if (persona == 1) {
			createPersonaJuridica();
		}
	}
	
	public void actualizar() {
		update();
		Cliente cliente = getInstance();
		if (persona == 0 && !cliente.getPersonaJuridicas().isEmpty()) {
			getEntityManager().remove(personaJuridicaHome.getInstance());
			getEntityManager().flush();
			return;
		}
		if (persona == 1) {
			if (cliente.getPersonaJuridicas().isEmpty()) {
				createPersonaJuridica();
				return;
			}
			getEntityManager().merge(personaJuridicaHome.getInstance());
			getEntityManager().flush();
		}
	}
	
	private void createPersonaJuridica () {
		PersonaJuridica pj = personaJuridicaHome.getInstance();
		pj.setCliente(getInstance());
		getEntityManager().persist(pj);
		getEntityManager().flush();
	}

}

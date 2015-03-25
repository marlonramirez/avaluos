package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("personaJuridicaHome")
public class PersonaJuridicaHome extends EntityHome<PersonaJuridica> {

	@In(create = true)
	ClienteHome clienteHome;
	@In(create = true)
	ActEconomicaHome actEconomicaHome;

	public void setPersonaJuridicaIdPersonaJuridica(Integer id) {
		setId(id);
	}

	public Integer getPersonaJuridicaIdPersonaJuridica() {
		return (Integer) getId();
	}

	@Override
	protected PersonaJuridica createInstance() {
		PersonaJuridica personaJuridica = new PersonaJuridica();
		return personaJuridica;
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
			getInstance().setCliente(cliente);
		}
		ActEconomica actEconomica = actEconomicaHome.getDefinedInstance();
		if (actEconomica != null) {
			getInstance().setActEconomica(actEconomica);
		}
	}

	public boolean isWired() {
		if (getInstance().getCliente() == null)
			return false;
		if (getInstance().getActEconomica() == null)
			return false;
		return true;
	}

	public PersonaJuridica getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}

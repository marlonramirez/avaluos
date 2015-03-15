package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("personaJuridicaHome")
public class PersonaJuridicaHome extends EntityHome<PersonaJuridica> {

	@In(create = true)
	AEconomicaHome aEconomicaHome;
	@In(create = true)
	ClienteHome clienteHome;

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
		AEconomica AEconomica = aEconomicaHome.getDefinedInstance();
		if (AEconomica != null) {
			getInstance().setAEconomica(AEconomica);
		}
		Cliente cliente = clienteHome.getDefinedInstance();
		if (cliente != null) {
			getInstance().setCliente(cliente);
		}
	}

	public boolean isWired() {
		if (getInstance().getAEconomica() == null)
			return false;
		if (getInstance().getCliente() == null)
			return false;
		return true;
	}

	public PersonaJuridica getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}

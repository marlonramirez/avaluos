package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("actEconomicaHome")
public class ActEconomicaHome extends EntityHome<ActEconomica> {

	public void setActEconomicaIdActEconomica(Integer id) {
		setId(id);
	}

	public Integer getActEconomicaIdActEconomica() {
		return (Integer) getId();
	}

	@Override
	protected ActEconomica createInstance() {
		ActEconomica actEconomica = new ActEconomica();
		return actEconomica;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public ActEconomica getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<PersonaJuridica> getPersonaJuridicas() {
		return getInstance() == null ? null : new ArrayList<PersonaJuridica>(
				getInstance().getPersonaJuridicas());
	}

}

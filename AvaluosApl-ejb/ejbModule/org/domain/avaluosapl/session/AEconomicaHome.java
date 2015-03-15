package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("aEconomicaHome")
public class AEconomicaHome extends EntityHome<AEconomica> {

	public void setAEconomicaIdAEconomica(Integer id) {
		setId(id);
	}

	public Integer getAEconomicaIdAEconomica() {
		return (Integer) getId();
	}

	@Override
	protected AEconomica createInstance() {
		AEconomica aEconomica = new AEconomica();
		return aEconomica;
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

	public AEconomica getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<PersonaJuridica> getPersonaJuridicas() {
		return getInstance() == null ? null : new ArrayList<PersonaJuridica>(
				getInstance().getPersonaJuridicas());
	}

}

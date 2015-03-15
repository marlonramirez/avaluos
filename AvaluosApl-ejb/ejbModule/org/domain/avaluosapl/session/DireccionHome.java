package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("direccionHome")
public class DireccionHome extends EntityHome<Direccion> {

	@In(create = true)
	PersonaHome personaHome;

	public void setDireccionIdDireccion(Integer id) {
		setId(id);
	}

	public Integer getDireccionIdDireccion() {
		return (Integer) getId();
	}

	@Override
	protected Direccion createInstance() {
		Direccion direccion = new Direccion();
		return direccion;
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

	public Direccion getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}

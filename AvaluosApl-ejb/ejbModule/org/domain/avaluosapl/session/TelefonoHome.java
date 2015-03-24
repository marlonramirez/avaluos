package org.domain.avaluosapl.session;

import javax.faces.context.FacesContext;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("telefonoHome")
public class TelefonoHome extends EntityHome<Telefono> {

	@In(create = true)
	TipoTelHome tipoTelHome;
	@In(create = true)
	PersonaHome personaHome;

	public void setTelefonoIdTelefono(Integer id) {
		setId(id);
	}

	public Integer getTelefonoIdTelefono() {
		return (Integer) getId();
	}

	@Override
	protected Telefono createInstance() {
		Telefono telefono = new Telefono();
		return telefono;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		TipoTel tipoTel = tipoTelHome.getDefinedInstance();
		if (tipoTel != null) {
			getInstance().setTipoTel(tipoTel);
		}
		Persona persona = personaHome.getDefinedInstance();
		if (persona != null) {
			getInstance().setPersona(persona);
		}
	}

	public boolean isWired() {
		if (getInstance().getTipoTel() == null)
			return false;
		if (getInstance().getPersona() == null)
			return false;
		return true;
	}

	public Telefono getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}
	
	public void newTelefono() {
		clearInstance();
	}
	
	public void loadTelefono(Telefono tel) {
		setInstance(tel);
	}

}

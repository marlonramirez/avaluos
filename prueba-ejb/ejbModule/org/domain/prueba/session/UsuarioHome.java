package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("usuarioHome")
public class UsuarioHome extends EntityHome<Usuario> {

	@In(create = true)
	PersonaHome personaHome;
	@In(create = true)
	PerfilHome perfilHome;

	public void setUsuarioIdUsuarioPersona(Integer id) {
		setId(id);
	}

	public Integer getUsuarioIdUsuarioPersona() {
		return (Integer) getId();
	}

	@Override
	protected Usuario createInstance() {
		Usuario usuario = new Usuario();
		return usuario;
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
		Perfil perfil = perfilHome.getDefinedInstance();
		if (perfil != null) {
			getInstance().setPerfil(perfil);
		}
	}

	public boolean isWired() {
		if (getInstance().getPersona() == null)
			return false;
		if (getInstance().getPerfil() == null)
			return false;
		return true;
	}

	public Usuario getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}

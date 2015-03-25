package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("perfilHome")
public class PerfilHome extends EntityHome<Perfil> {

	public void setPerfilIdPerfil(Integer id) {
		setId(id);
	}

	public Integer getPerfilIdPerfil() {
		return (Integer) getId();
	}

	@Override
	protected Perfil createInstance() {
		Perfil perfil = new Perfil();
		return perfil;
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

	public Perfil getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Permiso> getPermisos() {
		return getInstance() == null ? null : new ArrayList<Permiso>(
				getInstance().getPermisos());
	}

	public List<Usuario> getUsuarios() {
		return getInstance() == null ? null : new ArrayList<Usuario>(
				getInstance().getUsuarios());
	}

}

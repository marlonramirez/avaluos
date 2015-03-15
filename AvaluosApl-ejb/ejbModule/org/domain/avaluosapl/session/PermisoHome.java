package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("permisoHome")
public class PermisoHome extends EntityHome<Permiso> {

	@In(create = true)
	CasoUsoHome casoUsoHome;
	@In(create = true)
	PerfilHome perfilHome;

	public void setPermisoIdPermiso(Integer id) {
		setId(id);
	}

	public Integer getPermisoIdPermiso() {
		return (Integer) getId();
	}

	@Override
	protected Permiso createInstance() {
		Permiso permiso = new Permiso();
		return permiso;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		CasoUso casoUso = casoUsoHome.getDefinedInstance();
		if (casoUso != null) {
			getInstance().setCasoUso(casoUso);
		}
		Perfil perfil = perfilHome.getDefinedInstance();
		if (perfil != null) {
			getInstance().setPerfil(perfil);
		}
	}

	public boolean isWired() {
		if (getInstance().getCasoUso() == null)
			return false;
		if (getInstance().getPerfil() == null)
			return false;
		return true;
	}

	public Permiso getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}

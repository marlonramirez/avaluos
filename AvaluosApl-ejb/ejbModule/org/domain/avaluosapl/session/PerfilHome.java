package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
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
	
	public void selectPermiso (Permiso permiso, CasoUso casoUso) {
		if (permiso != null) {
			permiso.setEstado((byte)(permiso.getEstado() == 0? 1: 0));			
		} else {
			permiso = new Permiso(casoUso, getInstance(), (byte)1);
			getInstance().getPermisos().add(permiso);
		}
	}
	
	public Permiso getPermiso(CasoUso cu) {
		for(Permiso permiso: getInstance().getPermisos()) {
			if (permiso.getCasoUso() == cu) {
				return permiso;
			}
		}
		return null;
	}
	
	public void guardar () {
		persist();
		for (Permiso permiso: getInstance().getPermisos()) {
			getEntityManager().persist(permiso);
		}
		getEntityManager().flush();
	}
	
	public void actualizar() {
		update();
		for (Permiso permiso: getInstance().getPermisos()) {
			if (permiso.getIdPermiso() == null) {
				getEntityManager().persist(permiso);
			}
		}
		getEntityManager().flush();
	}

}

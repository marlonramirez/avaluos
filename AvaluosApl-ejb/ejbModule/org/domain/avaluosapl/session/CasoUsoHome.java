package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("casoUsoHome")
public class CasoUsoHome extends EntityHome<CasoUso> {

	public void setCasoUsoIdCasoUso(Integer id) {
		setId(id);
	}

	public Integer getCasoUsoIdCasoUso() {
		return (Integer) getId();
	}

	@Override
	protected CasoUso createInstance() {
		CasoUso casoUso = new CasoUso();
		return casoUso;
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

	public CasoUso getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Permiso> getPermisos() {
		return getInstance() == null ? null : new ArrayList<Permiso>(
				getInstance().getPermisos());
	}

}

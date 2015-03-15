package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("tangibleHome")
public class TangibleHome extends EntityHome<Tangible> {

	@In(create = true)
	ActivoHome activoHome;

	public void setTangibleIdActivoTan(Integer id) {
		setId(id);
	}

	public Integer getTangibleIdActivoTan() {
		return (Integer) getId();
	}

	@Override
	protected Tangible createInstance() {
		Tangible tangible = new Tangible();
		return tangible;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Activo activo = activoHome.getDefinedInstance();
		if (activo != null) {
			getInstance().setActivo(activo);
		}
	}

	public boolean isWired() {
		if (getInstance().getActivo() == null)
			return false;
		return true;
	}

	public Tangible getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}

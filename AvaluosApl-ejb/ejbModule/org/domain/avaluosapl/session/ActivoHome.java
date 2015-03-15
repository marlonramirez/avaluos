package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("activoHome")
public class ActivoHome extends EntityHome<Activo> {

	@In(create = true)
	TangibleHome tangibleHome;

	public void setActivoIdActivo(Integer id) {
		setId(id);
	}

	public Integer getActivoIdActivo() {
		return (Integer) getId();
	}

	@Override
	protected Activo createInstance() {
		Activo activo = new Activo();
		return activo;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Tangible tangible = tangibleHome.getDefinedInstance();
		if (tangible != null) {
			getInstance().setTangible(tangible);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Activo getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Avaluo> getAvaluos() {
		return getInstance() == null ? null : new ArrayList<Avaluo>(
				getInstance().getAvaluos());
	}

}

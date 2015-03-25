package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("areaConocHome")
public class AreaConocHome extends EntityHome<AreaConoc> {

	public void setAreaConocIdAreaConoc(Integer id) {
		setId(id);
	}

	public Integer getAreaConocIdAreaConoc() {
		return (Integer) getId();
	}

	@Override
	protected AreaConoc createInstance() {
		AreaConoc areaConoc = new AreaConoc();
		return areaConoc;
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

	public AreaConoc getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Colaborador> getColaboradors() {
		return getInstance() == null ? null : new ArrayList<Colaborador>(
				getInstance().getColaboradors());
	}

}

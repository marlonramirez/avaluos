package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("ciudadHome")
public class CiudadHome extends EntityHome<Ciudad> {

	public void setCiudadCiudadId(Integer id) {
		setId(id);
	}

	public Integer getCiudadCiudadId() {
		return (Integer) getId();
	}

	@Override
	protected Ciudad createInstance() {
		Ciudad ciudad = new Ciudad();
		return ciudad;
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

	public Ciudad getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Factura> getFacturas() {
		return getInstance() == null ? null : new ArrayList<Factura>(
				getInstance().getFacturas());
	}

}

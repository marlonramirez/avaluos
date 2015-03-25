package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("tipoTelHome")
public class TipoTelHome extends EntityHome<TipoTel> {

	public void setTipoTelIdTipoTel(Integer id) {
		setId(id);
	}

	public Integer getTipoTelIdTipoTel() {
		return (Integer) getId();
	}

	@Override
	protected TipoTel createInstance() {
		TipoTel tipoTel = new TipoTel();
		return tipoTel;
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

	public TipoTel getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Telefono> getTelefonos() {
		return getInstance() == null ? null : new ArrayList<Telefono>(
				getInstance().getTelefonos());
	}

}

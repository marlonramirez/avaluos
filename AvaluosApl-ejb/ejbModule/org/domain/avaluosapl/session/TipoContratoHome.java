package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("tipoContratoHome")
public class TipoContratoHome extends EntityHome<TipoContrato> {

	public void setTipoContratoIdTipoContrato(Integer id) {
		setId(id);
	}

	public Integer getTipoContratoIdTipoContrato() {
		return (Integer) getId();
	}

	@Override
	protected TipoContrato createInstance() {
		TipoContrato tipoContrato = new TipoContrato();
		return tipoContrato;
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

	public TipoContrato getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Colaborador> getColaboradors() {
		return getInstance() == null ? null : new ArrayList<Colaborador>(
				getInstance().getColaboradors());
	}

}

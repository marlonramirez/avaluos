package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("tipoDocHome")
public class TipoDocHome extends EntityHome<TipoDoc> {

	public void setTipoDocIdTipoDoc(Integer id) {
		setId(id);
	}

	public Integer getTipoDocIdTipoDoc() {
		return (Integer) getId();
	}

	@Override
	protected TipoDoc createInstance() {
		TipoDoc tipoDoc = new TipoDoc();
		return tipoDoc;
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

	public TipoDoc getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Persona> getPersonas() {
		return getInstance() == null ? null : new ArrayList<Persona>(
				getInstance().getPersonas());
	}

}

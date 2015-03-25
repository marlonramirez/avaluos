package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("conceptoHome")
public class ConceptoHome extends EntityHome<Concepto> {

	public void setConceptoIdConcepto(Integer id) {
		setId(id);
	}

	public Integer getConceptoIdConcepto() {
		return (Integer) getId();
	}

	@Override
	protected Concepto createInstance() {
		Concepto concepto = new Concepto();
		return concepto;
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

	public Concepto getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ItemAvaluo> getItemAvaluos() {
		return getInstance() == null ? null : new ArrayList<ItemAvaluo>(
				getInstance().getItemAvaluos());
	}

}

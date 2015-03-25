package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("formaPagoHome")
public class FormaPagoHome extends EntityHome<FormaPago> {

	public void setFormaPagoIdFormaPago(Integer id) {
		setId(id);
	}

	public Integer getFormaPagoIdFormaPago() {
		return (Integer) getId();
	}

	@Override
	protected FormaPago createInstance() {
		FormaPago formaPago = new FormaPago();
		return formaPago;
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

	public FormaPago getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Factura> getFacturas() {
		return getInstance() == null ? null : new ArrayList<Factura>(
				getInstance().getFacturas());
	}

}

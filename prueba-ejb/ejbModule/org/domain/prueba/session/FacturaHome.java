package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("facturaHome")
public class FacturaHome extends EntityHome<Factura> {

	@In(create = true)
	FormaPagoHome formaPagoHome;
	@In(create = true)
	CiudadHome ciudadHome;

	public void setFacturaIdFactura(Integer id) {
		setId(id);
	}

	public Integer getFacturaIdFactura() {
		return (Integer) getId();
	}

	@Override
	protected Factura createInstance() {
		Factura factura = new Factura();
		return factura;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		FormaPago formaPago = formaPagoHome.getDefinedInstance();
		if (formaPago != null) {
			getInstance().setFormaPago(formaPago);
		}
		Ciudad ciudad = ciudadHome.getDefinedInstance();
		if (ciudad != null) {
			getInstance().setCiudad(ciudad);
		}
	}

	public boolean isWired() {
		if (getInstance().getFormaPago() == null)
			return false;
		if (getInstance().getCiudad() == null)
			return false;
		return true;
	}

	public Factura getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ItemFactura> getItemFacturas() {
		return getInstance() == null ? null : new ArrayList<ItemFactura>(
				getInstance().getItemFacturas());
	}

}

package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("itemFacturaHome")
public class ItemFacturaHome extends EntityHome<ItemFactura> {

	@In(create = true)
	FacturaHome facturaHome;
	@In(create = true)
	ItemAvaluoHome itemAvaluoHome;

	public void setItemFacturaIdItemAvaluoFac(Integer id) {
		setId(id);
	}

	public Integer getItemFacturaIdItemAvaluoFac() {
		return (Integer) getId();
	}

	@Override
	protected ItemFactura createInstance() {
		ItemFactura itemFactura = new ItemFactura();
		return itemFactura;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Factura factura = facturaHome.getDefinedInstance();
		if (factura != null) {
			getInstance().setFactura(factura);
		}
		ItemAvaluo itemAvaluo = itemAvaluoHome.getDefinedInstance();
		if (itemAvaluo != null) {
			getInstance().setItemAvaluo(itemAvaluo);
		}
	}

	public boolean isWired() {
		if (getInstance().getFactura() == null)
			return false;
		if (getInstance().getItemAvaluo() == null)
			return false;
		return true;
	}

	public ItemFactura getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}

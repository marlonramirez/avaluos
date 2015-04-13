package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.document.ByteArrayDocumentData;
import org.jboss.seam.document.DocumentData;
import org.jboss.seam.document.DocumentStore;
import org.jboss.seam.faces.Renderer;
import org.jboss.seam.framework.EntityHome;

@Name("facturaHome")
public class FacturaHome extends EntityHome<Factura> {

	@In(create = true)
	FormaPagoHome formaPagoHome;
	@In(create = true)
	AvaluoList avaluoList;
	@In(create = true)
	Renderer renderer;
	
	private String numOrden;

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
		Factura instance = getInstance();
		FormaPago formaPago = formaPagoHome.getDefinedInstance();
		if (formaPago != null) {
			getInstance().setFormaPago(formaPago);
		}
		if (numOrden == null && !instance.getItemFacturas().isEmpty()) {
			numOrden = instance.getItemFacturas().iterator().next().getItemAvaluo().getAvaluo().getNumOrden();
		}
	}

	public boolean isWired() {
		if (getInstance().getFormaPago() == null)
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

	public String getNumOrden() {
		return numOrden;
	}

	public void setNumOrden(String numOrden) {
		this.numOrden = numOrden;
		Avaluo avaluo = avaluoList.getByNumOrden(numOrden);
		if (avaluo == null) {
			return;
		}
		Factura factura = getInstance();
		factura.getItemFacturas().clear();
		double subtotal = 0;
		for (ItemAvaluo itemA: avaluo.getItemAvaluos()) {
			double valorU = itemA.getCosto()+itemA.getUtilidad();
			ItemFactura itemF = new ItemFactura();
			itemF.setFactura(factura);
			itemF.setItemAvaluo(itemA);
			itemF.setValorUnitario(valorU);
			itemF.setCantidad(1);
			factura.getItemFacturas().add(itemF);
			subtotal += valorU;
		}
		double iva = subtotal*16/100;
		factura.setSubtotal(subtotal);
		factura.setIva(iva);
		factura.setTotal(subtotal+iva);
	}
	
	public void guardar() {
		Factura instance = getInstance();
		persist();
		for (ItemFactura item: instance.getItemFacturas()) {
			getEntityManager().persist(item);
		}
		getEntityManager().flush();
	}
	
	public void actualizar() {
		Factura instance = getInstance();
		update();
		for (ItemFactura item: instance.getItemFacturas()) {
			if (item.getIdItemAvaluoFac() == null) {
				getEntityManager().persist(item);
			}
		}
		getEntityManager().flush();		
	}
	
	public void imprimir() {
		Factura fact = getInstance();
		if(fact.getEstado() > 0 && fact.getEstado() < 4) {
			fact.setEstado((byte)(fact.getEstado()+1));
			update();
		}
	}

}

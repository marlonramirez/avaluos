package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("itemAvaluoHome")
public class ItemAvaluoHome extends EntityHome<ItemAvaluo> {

	@In(create = true)
	ConceptoHome conceptoHome;
	@In(create = true)
	AvaluoHome avaluoHome;
	@In(create = true)
	ItemFacturaHome itemFacturaHome;

	public void setItemAvaluoIdItemAvaluo(Integer id) {
		setId(id);
	}

	public Integer getItemAvaluoIdItemAvaluo() {
		return (Integer) getId();
	}

	@Override
	protected ItemAvaluo createInstance() {
		ItemAvaluo itemAvaluo = new ItemAvaluo();
		return itemAvaluo;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Concepto concepto = conceptoHome.getDefinedInstance();
		if (concepto != null) {
			getInstance().setConcepto(concepto);
		}
		Avaluo avaluo = avaluoHome.getDefinedInstance();
		if (avaluo != null) {
			getInstance().setAvaluo(avaluo);
		}
		ItemFactura itemFactura = itemFacturaHome.getDefinedInstance();
		if (itemFactura != null) {
			getInstance().setItemFactura(itemFactura);
		}
	}

	public boolean isWired() {
		if (getInstance().getConcepto() == null)
			return false;
		if (getInstance().getAvaluo() == null)
			return false;
		return true;
	}

	public ItemAvaluo getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ManoObra> getManoObras() {
		return getInstance() == null ? null : new ArrayList<ManoObra>(
				getInstance().getManoObras());
	}

}

package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;

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
	@In(create = true)
	ManoObraHome manoObraHome;
	
	private ArrayList<ManoObra> deleteMos = new ArrayList<ManoObra>();

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
	
	public void newItemAvaluo() {
		setInstance(createInstance());
	}
	
	public void loadItemAvaluo(ItemAvaluo item) {
		setInstance(item);
	}
	
	public void addManoObra() {
		ItemAvaluo item = getInstance();
		ManoObra mo = manoObraHome.getInstance();
		String descripcion = mo.getDescripcion();
		if (descripcion == null || descripcion.isEmpty()) {
			return;
		}
		if (!manoObraHome.isEdit()) {
			mo.setItemAvaluo(item);
			item.getManoObras().add(mo);
		}
		manoObraHome.newManoObra();
	}
	
	public void removeManoObra(ManoObra mo) {
		if (mo.getIdManoObra() != null) {
			deleteMos.add(mo);
		}
		getInstance().getManoObras().remove(mo);
	}
	
	public void removeAllManoObras () {
		ItemAvaluo instance = getInstance();
		for (ManoObra mo: instance.getManoObras()) {
			if (mo.getIdManoObra() != null) {
				getEntityManager().remove(mo);
			}
		}
		for (ManoObra mo: deleteMos) {
			getEntityManager().remove(mo);
		}
	}
	
	public void guardar() {
		ItemAvaluo instance = getInstance();
		persist();
		for (ManoObra mo: instance.getManoObras()) {
			getEntityManager().persist(mo);
		}
		getEntityManager().flush();
	}
	
	public void actualizar() {
		ItemAvaluo instance = getInstance();
		update();
		for (ManoObra mo: deleteMos) {
			getEntityManager().remove(mo);
		}
		for (ManoObra mo: instance.getManoObras()) {
			if (mo.getIdManoObra() == null) {
				getEntityManager().persist(mo);
			}
		}
		getEntityManager().flush();
	}

}

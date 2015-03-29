package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("avaluoHome")
public class AvaluoHome extends EntityHome<Avaluo> {

	@In(create = true)
	ActivoHome activoHome;
	@In(create = true)
	ItemAvaluoHome itemAvaluoHome;
	
	private ArrayList<ItemAvaluo> deleteItems = new ArrayList<ItemAvaluo>();

	public void setAvaluoIdAvaluo(Integer id) {
		setId(id);
	}

	public Integer getAvaluoIdAvaluo() {
		return (Integer) getId();
	}

	@Override
	protected Avaluo createInstance() {
		Avaluo avaluo = new Avaluo();
		avaluo.setActivo(new Activo());
		return avaluo;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Activo activo = activoHome.getDefinedInstance();
		if (activo != null) {
			getInstance().setActivo(activo);
		}
	}

	public boolean isWired() {
		if (getInstance().getActivo().getIdActivo() == null)
			return false;
		if (isManaged())
			return !getInstance().getItemAvaluos().isEmpty();
		return true;
	}

	public Avaluo getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ItemAvaluo> getItemAvaluos() {
		return getInstance() == null ? null : new ArrayList<ItemAvaluo>(
				getInstance().getItemAvaluos());
	}
	
	public void addItem() {
		Avaluo avaluo = getInstance();
		ItemAvaluo item = itemAvaluoHome.getInstance();
		item.setAvaluo(avaluo);
		avaluo.getItemAvaluos().add(item);
	}
	
	public void removeItem(ItemAvaluo item) {
		if (item.getIdItemAvaluo() != null) {
			deleteItems.add(item);
		}
		getInstance().getItemAvaluos().remove(item);
	}
	
	public void actualizar() {
		Avaluo instance = getInstance();
		update();
		for (ItemAvaluo item: deleteItems) {
			getEntityManager().remove(item);
		}
		for (ItemAvaluo item: instance.getItemAvaluos()) {
			if (item.getIdItemAvaluo() == null) {
				getEntityManager().persist(item);
			}
		}
		getEntityManager().flush();
	}

}

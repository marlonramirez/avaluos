package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("manoObraHome")
public class ManoObraHome extends EntityHome<ManoObra> {

	@In(create = true)
	ItemAvaluoHome itemAvaluoHome;

	public void setManoObraIdManoObra(Integer id) {
		setId(id);
	}

	public Integer getManoObraIdManoObra() {
		return (Integer) getId();
	}

	@Override
	protected ManoObra createInstance() {
		ManoObra manoObra = new ManoObra();
		return manoObra;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		ItemAvaluo itemAvaluo = itemAvaluoHome.getDefinedInstance();
		if (itemAvaluo != null) {
			getInstance().setItemAvaluo(itemAvaluo);
		}
	}

	public boolean isWired() {
		if (getInstance().getItemAvaluo() == null)
			return false;
		return true;
	}

	public ManoObra getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}

package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("cargoHome")
public class CargoHome extends EntityHome<Cargo> {

	public void setCargoIdCargo(Integer id) {
		setId(id);
	}

	public Integer getCargoIdCargo() {
		return (Integer) getId();
	}

	@Override
	protected Cargo createInstance() {
		Cargo cargo = new Cargo();
		return cargo;
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

	public Cargo getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Colaborador> getColaboradors() {
		return getInstance() == null ? null : new ArrayList<Colaborador>(
				getInstance().getColaboradors());
	}

}

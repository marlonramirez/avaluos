package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("calificacionHome")
public class CalificacionHome extends EntityHome<Calificacion> {

	public void setCalificacionIdCalificacion(Integer id) {
		setId(id);
	}

	public Integer getCalificacionIdCalificacion() {
		return (Integer) getId();
	}

	@Override
	protected Calificacion createInstance() {
		Calificacion calificacion = new Calificacion();
		return calificacion;
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

	public Calificacion getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Colaborador> getColaboradors() {
		return getInstance() == null ? null : new ArrayList<Colaborador>(
				getInstance().getColaboradors());
	}

}

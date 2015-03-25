package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("colaboradorHome")
public class ColaboradorHome extends EntityHome<Colaborador> {

	@In(create = true)
	TipoContratoHome tipoContratoHome;
	@In(create = true)
	AreaConocHome areaConocHome;
	@In(create = true)
	CargoHome cargoHome;
	@In(create = true)
	PersonaHome personaHome;
	@In(create = true)
	CalificacionHome calificacionHome;

	public void setColaboradorIdColaboradorPersona(Integer id) {
		setId(id);
	}

	public Integer getColaboradorIdColaboradorPersona() {
		return (Integer) getId();
	}

	@Override
	protected Colaborador createInstance() {
		Colaborador colaborador = new Colaborador();
		return colaborador;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		TipoContrato tipoContrato = tipoContratoHome.getDefinedInstance();
		if (tipoContrato != null) {
			getInstance().setTipoContrato(tipoContrato);
		}
		AreaConoc areaConoc = areaConocHome.getDefinedInstance();
		if (areaConoc != null) {
			getInstance().setAreaConoc(areaConoc);
		}
		Cargo cargo = cargoHome.getDefinedInstance();
		if (cargo != null) {
			getInstance().setCargo(cargo);
		}
		Persona persona = personaHome.getDefinedInstance();
		if (persona != null) {
			getInstance().setPersona(persona);
		}
		Calificacion calificacion = calificacionHome.getDefinedInstance();
		if (calificacion != null) {
			getInstance().setCalificacion(calificacion);
		}
	}

	public boolean isWired() {
		if (getInstance().getTipoContrato() == null)
			return false;
		if (getInstance().getAreaConoc() == null)
			return false;
		if (getInstance().getCargo() == null)
			return false;
		if (getInstance().getPersona() == null)
			return false;
		if (getInstance().getCalificacion() == null)
			return false;
		return true;
	}

	public Colaborador getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Competencia> getCompetencias() {
		return getInstance() == null ? null : new ArrayList<Competencia>(
				getInstance().getCompetencias());
	}

}

package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;

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
	@In(create = true)
	CompetenciaHome competenciaHome;
	
	private ArrayList<Competencia> deleteComps = new ArrayList<Competencia>();

	public void setColaboradorIdColaboradorPersona(Integer id) {
		setId(id);
	}

	public Integer getColaboradorIdColaboradorPersona() {
		return (Integer) getId();
	}

	@Override
	protected Colaborador createInstance() {
		Colaborador colaborador = new Colaborador();
		colaborador.setPersona(new Persona());
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
		if (getInstance().getPersona().getIdPersona() == null)
			return false;
		if (getInstance().getCalificacion() == null)
			return false;
		if (getInstance().getCompetencias().isEmpty())
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
	
	public void addCompetencia() {
		Colaborador colaborador = getInstance();
		Competencia comp = competenciaHome.getInstance();
		comp.setColaborador(colaborador);
		colaborador.getCompetencias().add(comp);
	}
	
	public void removeCompetencia(Competencia comp) {
		if (comp.getIdCompetencia() != null) {
			deleteComps.add(comp);
		}
		getInstance().getCompetencias().remove(comp);
	}
	
	public void guardar() {
		persist();
		Colaborador instance = getInstance();
		for (Competencia comp: instance.getCompetencias()) {
			getEntityManager().persist(comp);
		}
		getEntityManager().flush();
	}
	
	public void actualizar() {
		update();
		Colaborador instance = getInstance();
		for (Competencia comp: deleteComps) {
			getEntityManager().remove(comp);
		}
		for (Competencia comp: instance.getCompetencias()) {
			if (comp.getDescripcion() == null) {
				getEntityManager().persist(comp);
			}
		}
		getEntityManager().flush();
	}

}

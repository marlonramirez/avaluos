package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("competenciaHome")
public class CompetenciaHome extends EntityHome<Competencia> {

	@In(create = true)
	ColaboradorHome colaboradorHome;

	public void setCompetenciaIdCompetencia(Integer id) {
		setId(id);
	}

	public Integer getCompetenciaIdCompetencia() {
		return (Integer) getId();
	}

	@Override
	protected Competencia createInstance() {
		Competencia competencia = new Competencia();
		return competencia;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Colaborador colaborador = colaboradorHome.getDefinedInstance();
		if (colaborador != null) {
			getInstance().setColaborador(colaborador);
		}
	}

	public boolean isWired() {
		if (getInstance().getColaborador() == null)
			return false;
		return true;
	}

	public Competencia getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}

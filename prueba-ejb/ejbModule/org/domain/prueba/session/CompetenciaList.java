package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("competenciaList")
public class CompetenciaList extends EntityQuery<Competencia> {

	private static final String EJBQL = "select competencia from Competencia competencia";

	private static final String[] RESTRICTIONS = { "lower(competencia.descripcion) like lower(concat(#{competenciaList.competencia.descripcion},'%'))", };

	private Competencia competencia = new Competencia();

	public CompetenciaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Competencia getCompetencia() {
		return competencia;
	}
}

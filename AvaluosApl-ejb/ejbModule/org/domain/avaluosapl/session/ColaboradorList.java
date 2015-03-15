package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("colaboradorList")
public class ColaboradorList extends EntityQuery<Colaborador> {

	private static final String EJBQL = "select colaborador from Colaborador colaborador";

	private static final String[] RESTRICTIONS = { "lower(colaborador.areaConocim) like lower(concat(#{colaboradorList.colaborador.areaConocim},'%'))", };

	private Colaborador colaborador = new Colaborador();

	public ColaboradorList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Colaborador getColaborador() {
		return colaborador;
	}
}

package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("colaboradorList")
public class ColaboradorList extends EntityQuery<Colaborador> {

	private static final String EJBQL = "select colaborador from Colaborador colaborador";

	private static final String[] RESTRICTIONS = {};

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

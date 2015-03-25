package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("actEconomicaList")
public class ActEconomicaList extends EntityQuery<ActEconomica> {

	private static final String EJBQL = "select actEconomica from ActEconomica actEconomica";

	private static final String[] RESTRICTIONS = { "lower(actEconomica.descripcion) like lower(concat(#{actEconomicaList.actEconomica.descripcion},'%'))", };

	private ActEconomica actEconomica = new ActEconomica();

	public ActEconomicaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ActEconomica getActEconomica() {
		return actEconomica;
	}
}

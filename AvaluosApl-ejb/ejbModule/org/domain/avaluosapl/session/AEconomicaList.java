package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("aEconomicaList")
public class AEconomicaList extends EntityQuery<AEconomica> {

	private static final String EJBQL = "select aEconomica from AEconomica aEconomica";

	private static final String[] RESTRICTIONS = { "lower(aEconomica.descripcion) like lower(concat(#{aEconomicaList.aEconomica.descripcion},'%'))", };

	private AEconomica aEconomica = new AEconomica();

	public AEconomicaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public AEconomica getAEconomica() {
		return aEconomica;
	}
}

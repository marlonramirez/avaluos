package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("casoUsoList")
public class CasoUsoList extends EntityQuery<CasoUso> {

	private static final String EJBQL = "select casoUso from CasoUso casoUso";

	private static final String[] RESTRICTIONS = {
			"lower(casoUso.codigo) like lower(concat(#{casoUsoList.casoUso.codigo},'%'))",
			"lower(casoUso.descripcion) like lower(concat(#{casoUsoList.casoUso.descripcion},'%'))", };

	private CasoUso casoUso = new CasoUso();

	public CasoUsoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public CasoUso getCasoUso() {
		return casoUso;
	}
}

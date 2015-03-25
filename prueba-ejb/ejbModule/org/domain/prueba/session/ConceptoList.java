package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("conceptoList")
public class ConceptoList extends EntityQuery<Concepto> {

	private static final String EJBQL = "select concepto from Concepto concepto";

	private static final String[] RESTRICTIONS = { "lower(concepto.nombre) like lower(concat(#{conceptoList.concepto.nombre},'%'))", };

	private Concepto concepto = new Concepto();

	public ConceptoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Concepto getConcepto() {
		return concepto;
	}
}

package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tipoDocList")
public class TipoDocList extends EntityQuery<TipoDoc> {

	private static final String EJBQL = "select tipoDoc from TipoDoc tipoDoc";

	private static final String[] RESTRICTIONS = {
			"lower(tipoDoc.abbr) like lower(concat(#{tipoDocList.tipoDoc.abbr},'%'))",
			"lower(tipoDoc.descripcion) like lower(concat(#{tipoDocList.tipoDoc.descripcion},'%'))", };

	private TipoDoc tipoDoc = new TipoDoc();

	public TipoDocList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public TipoDoc getTipoDoc() {
		return tipoDoc;
	}
}

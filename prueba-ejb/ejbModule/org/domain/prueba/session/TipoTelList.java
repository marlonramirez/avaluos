package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tipoTelList")
public class TipoTelList extends EntityQuery<TipoTel> {

	private static final String EJBQL = "select tipoTel from TipoTel tipoTel";

	private static final String[] RESTRICTIONS = { "lower(tipoTel.descripcion) like lower(concat(#{tipoTelList.tipoTel.descripcion},'%'))", };

	private TipoTel tipoTel = new TipoTel();

	public TipoTelList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public TipoTel getTipoTel() {
		return tipoTel;
	}
}

package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tipoContratoList")
public class TipoContratoList extends EntityQuery<TipoContrato> {

	private static final String EJBQL = "select tipoContrato from TipoContrato tipoContrato";

	private static final String[] RESTRICTIONS = { "lower(tipoContrato.descripcion) like lower(concat(#{tipoContratoList.tipoContrato.descripcion},'%'))", };

	private TipoContrato tipoContrato = new TipoContrato();

	public TipoContratoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}
}

package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("facturaList")
public class FacturaList extends EntityQuery<Factura> {

	private static final String EJBQL = "select factura from Factura factura";

	private static final String[] RESTRICTIONS = { "lower(factura.numFactura) like lower(concat(#{facturaList.factura.numFactura},'%'))", };

	private Factura factura = new Factura();

	public FacturaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Factura getFactura() {
		return factura;
	}
}

package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("direccionList")
public class DireccionList extends EntityQuery<Direccion> {

	private static final String EJBQL = "select direccion from Direccion direccion";

	private static final String[] RESTRICTIONS = { "lower(direccion.direccion) like lower(concat(#{direccionList.direccion.direccion},'%'))", };

	private Direccion direccion = new Direccion();

	public DireccionList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Direccion getDireccion() {
		return direccion;
	}
}

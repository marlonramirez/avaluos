package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("telefonoList")
public class TelefonoList extends EntityQuery<Telefono> {

	private static final String EJBQL = "select telefono from Telefono telefono";

	private static final String[] RESTRICTIONS = { "lower(telefono.numero) like lower(concat(#{telefonoList.telefono.numero},'%'))", };

	private Telefono telefono = new Telefono();

	public TelefonoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Telefono getTelefono() {
		return telefono;
	}
}

package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("ciudadList")
public class CiudadList extends EntityQuery<Ciudad> {

	private static final String EJBQL = "select ciudad from Ciudad ciudad";

	private static final String[] RESTRICTIONS = { "lower(ciudad.nombre) like lower(concat(#{ciudadList.ciudad.nombre},'%'))", };

	private Ciudad ciudad = new Ciudad();

	public CiudadList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Ciudad getCiudad() {
		return ciudad;
	}
}

package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("calificacionList")
public class CalificacionList extends EntityQuery<Calificacion> {

	private static final String EJBQL = "select calificacion from Calificacion calificacion";

	private static final String[] RESTRICTIONS = { "lower(calificacion.descripcion) like lower(concat(#{calificacionList.calificacion.descripcion},'%'))", };

	private Calificacion calificacion = new Calificacion();

	public CalificacionList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Calificacion getCalificacion() {
		return calificacion;
	}
}

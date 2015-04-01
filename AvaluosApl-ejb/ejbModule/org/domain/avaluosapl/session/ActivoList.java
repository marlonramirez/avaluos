package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;
import java.util.List;

@Name("activoList")
public class ActivoList extends EntityQuery<Activo> {

	private static final String EJBQL = "select activo from Activo activo";

	private static final String[] RESTRICTIONS = {
			"activo.estado = #{activoList.activo.estado}",
			"lower(activo.nombre) like lower(concat(#{activoList.activo.nombre},'%'))",
			"lower(activo.descripcion) like lower(concat(#{activoList.activo.descripcion},'%'))", };

	private Activo activo = new Activo();

	public ActivoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Activo getActivo() {
		return activo;
	}
	
}

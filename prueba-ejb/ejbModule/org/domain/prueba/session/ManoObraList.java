package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("manoObraList")
public class ManoObraList extends EntityQuery<ManoObra> {

	private static final String EJBQL = "select manoObra from ManoObra manoObra";

	private static final String[] RESTRICTIONS = { "lower(manoObra.descripcion) like lower(concat(#{manoObraList.manoObra.descripcion},'%'))", };

	private ManoObra manoObra = new ManoObra();

	public ManoObraList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ManoObra getManoObra() {
		return manoObra;
	}
}

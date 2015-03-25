package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("areaConocList")
public class AreaConocList extends EntityQuery<AreaConoc> {

	private static final String EJBQL = "select areaConoc from AreaConoc areaConoc";

	private static final String[] RESTRICTIONS = { "lower(areaConoc.descripcion) like lower(concat(#{areaConocList.areaConoc.descripcion},'%'))", };

	private AreaConoc areaConoc = new AreaConoc();

	public AreaConocList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public AreaConoc getAreaConoc() {
		return areaConoc;
	}
}

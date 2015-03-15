package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tangibleList")
public class TangibleList extends EntityQuery<Tangible> {

	private static final String EJBQL = "select tangible from Tangible tangible";

	private static final String[] RESTRICTIONS = {};

	private Tangible tangible = new Tangible();

	public TangibleList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Tangible getTangible() {
		return tangible;
	}
}

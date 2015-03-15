package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("itemAvaluoList")
public class ItemAvaluoList extends EntityQuery<ItemAvaluo> {

	private static final String EJBQL = "select itemAvaluo from ItemAvaluo itemAvaluo";

	private static final String[] RESTRICTIONS = {};

	private ItemAvaluo itemAvaluo = new ItemAvaluo();

	public ItemAvaluoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ItemAvaluo getItemAvaluo() {
		return itemAvaluo;
	}
}

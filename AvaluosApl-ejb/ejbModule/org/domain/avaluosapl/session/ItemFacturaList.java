package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("itemFacturaList")
public class ItemFacturaList extends EntityQuery<ItemFactura> {

	private static final String EJBQL = "select itemFactura from ItemFactura itemFactura";

	private static final String[] RESTRICTIONS = {};

	private ItemFactura itemFactura = new ItemFactura();

	public ItemFacturaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ItemFactura getItemFactura() {
		return itemFactura;
	}
}

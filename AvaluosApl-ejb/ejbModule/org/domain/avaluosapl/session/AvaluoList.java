package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;
import java.util.List;

@Name("avaluoList")
public class AvaluoList extends EntityQuery<Avaluo> {

	private static final String EJBQL = "select avaluo from Avaluo avaluo";

	private static final String[] RESTRICTIONS = {
			"lower(avaluo.numOrden) like lower(concat(#{avaluoList.avaluo.numOrden},'%'))",
			"lower(avaluo.descripcion) like lower(concat(#{avaluoList.avaluo.descripcion},'%'))", };

	private Avaluo avaluo = new Avaluo();

	public AvaluoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Avaluo getAvaluo() {
		return avaluo;
	}
	
	public Avaluo getByNumOrden(String numOrden) {
		String ejbql = EJBQL+" WHERE avaluo.numOrden = ?";
		List<Avaluo> activos = getEntityManager().createQuery(ejbql).setParameter(1, numOrden).getResultList();
		if (activos.isEmpty()) {
			return null;
		}
		return activos.get(0);
	}
}

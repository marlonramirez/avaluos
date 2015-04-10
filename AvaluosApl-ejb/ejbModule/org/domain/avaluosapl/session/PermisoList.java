package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

@Name("permisoList")
public class PermisoList extends EntityQuery<Permiso> {

	private static final String EJBQL = "select permiso from Permiso permiso";

	private static final String[] RESTRICTIONS = {};

	private Permiso permiso = new Permiso();

	public PermisoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Permiso getPermiso() {
		return permiso;
	}
	
	public long getByMenu(Usuario usuario, String[] codigos) {
		if (codigos.length == 0) {
			return 0;
		}
		String ejbql = "SELECT COUNT(permiso) FROM Permiso permiso WHERE (";
		for(String cod: codigos) {
			ejbql += "casoUso.codigo = ? OR ";
		}
		ejbql = ejbql.substring(0, ejbql.length()-4);
		ejbql += ") AND estado = 1 AND perfil = ?";
		Query query = getEntityManager().createQuery(ejbql);
		int i=1;
		for(; i<=codigos.length; i++) {
			query.setParameter(i, codigos[i-1]);
		}
		query.setParameter(i, usuario.getPerfil());
		return (Long) query.getSingleResult();
	}
}

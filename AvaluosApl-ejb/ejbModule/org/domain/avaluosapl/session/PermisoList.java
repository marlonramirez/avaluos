package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;
import java.util.List;

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
	
	public Permiso getByUsuario(Usuario usuario, String codCasoUso) {
		String ejbql = EJBQL+" WHERE casoUso.codigo = ? AND perfil = ?";
		List<Permiso> permisos = getEntityManager().createQuery(ejbql)
								.setParameter(1, codCasoUso)
								.setParameter(2, usuario.getPerfil()).getResultList();
		if (permisos.isEmpty()) {
			return null;
		}
		return permisos.get(0);
	}
}

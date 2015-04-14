package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;
import java.util.List;

@Name("perfilList")
public class PerfilList extends EntityQuery<Perfil> {

	private static final String EJBQL = "select perfil from Perfil perfil";

	private static final String[] RESTRICTIONS = {
		"lower(perfil.nombre) like lower(concat(#{perfilList.perfil.nombre},'%'))",
	};

	private Perfil perfil = new Perfil();

	public PerfilList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Perfil getPerfil() {
		return perfil;
	}
	
	public List<Perfil> getPerfilesActivos() {
		String ejbql = EJBQL+" WHERE perfil.estado = 1";
		return getEntityManager().createQuery(ejbql).getResultList();
	}
}

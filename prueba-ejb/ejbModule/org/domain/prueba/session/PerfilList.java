package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("perfilList")
public class PerfilList extends EntityQuery<Perfil> {

	private static final String EJBQL = "select perfil from Perfil perfil";

	private static final String[] RESTRICTIONS = { "lower(perfil.nombre) like lower(concat(#{perfilList.perfil.nombre},'%'))", };

	private Perfil perfil = new Perfil();

	public PerfilList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Perfil getPerfil() {
		return perfil;
	}
}

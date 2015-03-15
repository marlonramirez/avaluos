package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tipoUsuarioList")
public class TipoUsuarioList extends EntityQuery<TipoUsuario> {

	private static final String EJBQL = "select tipoUsuario from TipoUsuario tipoUsuario";

	private static final String[] RESTRICTIONS = { "lower(tipoUsuario.descripcion) like lower(concat(#{tipoUsuarioList.tipoUsuario.descripcion},'%'))", };

	private TipoUsuario tipoUsuario = new TipoUsuario();

	public TipoUsuarioList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
}

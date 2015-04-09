package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;
import java.util.List;

@Name("usuarioList")
public class UsuarioList extends EntityQuery<Usuario> {

	private static final String EJBQL = "select usuario from Usuario usuario";

	private static final String[] RESTRICTIONS = {
			"lower(usuario.login) like lower(concat(#{usuarioList.usuario.login},'%'))",
			"lower(usuario.clave) like lower(concat(#{usuarioList.usuario.clave},'%'))", };

	private Usuario usuario = new Usuario();

	public UsuarioList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public Usuario access (String usuario, String clave) {
		String ejbql = EJBQL+" WHERE login = ? AND clave = ? AND estado = 1";
		List<Usuario> usuarios = getEntityManager().createQuery(ejbql)
								.setParameter(1, usuario)
								.setParameter(2, clave).getResultList();
		if (usuarios.isEmpty()) {
			return null;
		}
		return usuarios.get(0);
	}
}

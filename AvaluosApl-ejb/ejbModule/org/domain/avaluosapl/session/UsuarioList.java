package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;
import java.util.List;

@Name("usuarioList")
public class UsuarioList extends EntityQuery<Usuario> {
	@In(create = true)
	SessionApp sessionApp;

	private static final String EJBQL = "select usuario from Usuario usuario";

	private static final String[] RESTRICTIONS = {
			"lower(usuario.login) like lower(concat(#{usuarioList.usuario.login},'%'))",
			"usuario.persona.tipoDoc.idTipoDoc = #{usuarioList.usuario.persona.tipoDoc.idTipoDoc}",
			"lower(usuario.persona.numDoc) like lower(concat(#{usuarioList.usuario.persona.numDoc},'%'))",
			"lower(usuario.persona.nombres) like lower(concat(#{usuarioList.usuario.persona.nombres},'%'))",
			"lower(usuario.persona.apellidos) like lower(concat(#{usuarioList.usuario.persona.apellidos},'%'))", };

	private Usuario usuario = new Usuario();

	public UsuarioList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}
	
	public List<Usuario> getResultList() {
		Usuario user = sessionApp.getUsuario();
		if (user.getPerfil().getNombre().equalsIgnoreCase("Cliente")) {
			setEjbql(EJBQL+" WHERE idUsuarioPersona = "+user.getIdUsuarioPersona());
		}
		return super.getResultList();
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
	
	public Usuario getByPersona(Persona persona) {
		String ejbql = EJBQL+" WHERE persona.idPersona = ?";
		List<Usuario> usuarios = getEntityManager().createQuery(ejbql)
								.setParameter(1, persona.getIdPersona()).getResultList();
		if(usuarios.isEmpty()) {
			return null;
		}
		return usuarios.get(0);
	}
}

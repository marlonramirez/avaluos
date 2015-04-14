package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;
import java.util.List;

@Name("personaList")
public class PersonaList extends EntityQuery<Persona> {
	@In(create = true)
	SessionApp sessionApp;

	private static final String EJBQL = "select persona from Persona persona";

	private static final String[] RESTRICTIONS = {
			"persona.tipoDoc.idTipoDoc = #{personaList.persona.tipoDoc.idTipoDoc}",
			"lower(persona.numDoc) like lower(concat(#{personaList.persona.numDoc},'%'))",
			"lower(persona.nombres) like lower(concat(#{personaList.persona.nombres},'%'))",
			"lower(persona.apellidos) like lower(concat(#{personaList.persona.apellidos},'%'))",
			"lower(persona.email) like lower(concat(#{personaList.persona.email},'%'))", };

	private Persona persona = new Persona();

	public PersonaList() {
		persona.setTipoDoc(new TipoDoc());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}
	
	public List<Persona> getResultList() {
		Usuario user = sessionApp.getUsuario();
		if (user.getPerfil().getNombre().equalsIgnoreCase("Cliente")) {
			setEjbql(EJBQL+" WHERE idPersona = "+user.getPersona().getIdPersona());
		}
		return super.getResultList();
	}

	public Persona getPersona() {
		return persona;
	}
	
	public Persona getById(Integer id) {
		if (id == null || id == 0) {
			return null;
		}
		String ejbql = EJBQL+" WHERE persona.idPersona =  ?";
		return (Persona) getEntityManager().createQuery(ejbql).setParameter(1, id).getSingleResult();
	}
}

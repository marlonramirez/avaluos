package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("personaJuridicaList")
public class PersonaJuridicaList extends EntityQuery<PersonaJuridica> {

	private static final String EJBQL = "select personaJuridica from PersonaJuridica personaJuridica";

	private static final String[] RESTRICTIONS = {
			"lower(personaJuridica.nit) like lower(concat(#{personaJuridicaList.personaJuridica.nit},'%'))",
			"lower(personaJuridica.razonSocial) like lower(concat(#{personaJuridicaList.personaJuridica.razonSocial},'%'))",
			"lower(personaJuridica.nombreComercial) like lower(concat(#{personaJuridicaList.personaJuridica.nombreComercial},'%'))", };

	private PersonaJuridica personaJuridica = new PersonaJuridica();

	public PersonaJuridicaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public PersonaJuridica getPersonaJuridica() {
		return personaJuridica;
	}
}

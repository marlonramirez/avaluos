package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("clienteList")
public class ClienteList extends EntityQuery<Cliente> {

	private static final String EJBQL = "select cliente from Cliente cliente";

	private static final String[] RESTRICTIONS = {};

	private Cliente cliente = new Cliente();

	public ClienteList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Cliente getCliente() {
		return cliente;
	}
}

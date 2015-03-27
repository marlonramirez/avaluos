package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;
import java.util.List;

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
	
	public Cliente getById(Integer id) {
		String ejbql = EJBQL+" WHERE cliente.idClientePersona = ?";
		List<Cliente> clientes = getEntityManager().createQuery(ejbql).setParameter(1, id).getResultList();
		return clientes.isEmpty()?null:clientes.get(0);
	}
}

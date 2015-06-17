package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;
import java.util.List;

@Name("clienteList")
public class ClienteList extends EntityQuery<Cliente> {

	private static final String EJBQL = "select cliente from Cliente cliente, PersonaJuridica pj";

	private static final String[] RESTRICTIONS = {
		"cliente.persona.tipoDoc.idTipoDoc = #{clienteList.cliente.persona.tipoDoc.idTipoDoc}",
		"cliente = pj.cliente AND pj.nit like lower(concat(#{clienteList.nit},'%'))",
		"lower(cliente.persona.numDoc) like lower(concat(#{clienteList.cliente.persona.numDoc},'%'))",
	};

	private Cliente cliente = new Cliente();
	private String nit;

	public ClienteList() {
		Persona persona = new Persona();
		persona.setTipoDoc(new TipoDoc());
		cliente.setPersona(persona);
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
	
	public Cliente getByPersona(Persona persona) {
		String ejbql = EJBQL+" WHERE cliente.persona.idPersona = ?";
		List<Cliente> usuarios = getEntityManager().createQuery(ejbql)
								.setParameter(1, persona.getIdPersona()).getResultList();
		if(usuarios.isEmpty()) {
			return null;
		}
		return usuarios.get(0);
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNit() {
		return nit;
	}
}

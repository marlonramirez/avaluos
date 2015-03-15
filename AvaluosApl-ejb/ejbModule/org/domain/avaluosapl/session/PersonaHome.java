package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("personaHome")
public class PersonaHome extends EntityHome<Persona> {

	@In(create = true)
	TipoDocHome tipoDocHome;
	@In(create = true)
	ClienteHome clienteHome;
	@In(create = true)
	UsuarioHome usuarioHome;
	@In(create = true)
	ColaboradorHome colaboradorHome;

	public void setPersonaIdPersona(Integer id) {
		setId(id);
	}

	public Integer getPersonaIdPersona() {
		return (Integer) getId();
	}

	@Override
	protected Persona createInstance() {
		Persona persona = new Persona();
		return persona;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		TipoDoc tipoDoc = tipoDocHome.getDefinedInstance();
		if (tipoDoc != null) {
			getInstance().setTipoDoc(tipoDoc);
		}
		Cliente cliente = clienteHome.getDefinedInstance();
		if (cliente != null) {
			getInstance().setCliente(cliente);
		}
		Usuario usuario = usuarioHome.getDefinedInstance();
		if (usuario != null) {
			getInstance().setUsuario(usuario);
		}
		Colaborador colaborador = colaboradorHome.getDefinedInstance();
		if (colaborador != null) {
			getInstance().setColaborador(colaborador);
		}
	}

	public boolean isWired() {
		if (getInstance().getTipoDoc() == null)
			return false;
		return true;
	}

	public Persona getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Telefono> getTelefonos() {
		return getInstance() == null ? null : new ArrayList<Telefono>(
				getInstance().getTelefonos());
	}

	public List<Direccion> getDireccions() {
		return getInstance() == null ? null : new ArrayList<Direccion>(
				getInstance().getDireccions());
	}

}

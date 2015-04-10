package org.domain.avaluosapl.session;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.domain.avaluosapl.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("usuarioHome")
public class UsuarioHome extends EntityHome<Usuario> {

	@In(create = true)
	PersonaHome personaHome;
	@In(create = true)
	PerfilHome perfilHome;

	public void setUsuarioIdUsuarioPersona(Integer id) {
		setId(id);
	}

	public Integer getUsuarioIdUsuarioPersona() {
		return (Integer) getId();
	}

	@Override
	protected Usuario createInstance() {
		Usuario usuario = new Usuario();
		usuario.setPersona(new Persona());
		return usuario;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance().setClave("");
		Persona persona = personaHome.getDefinedInstance();
		if (persona != null) {
			getInstance().setPersona(persona);
		}
		Perfil perfil = perfilHome.getDefinedInstance();
		if (perfil != null) {
			getInstance().setPerfil(perfil);
		}
	}

	public boolean isWired() {
		if (getInstance().getPersona().getIdPersona() == null)
			return false;
		if (getInstance().getPerfil() == null)
			return false;
		return true;
	}

	public Usuario getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}
	
	public void guardar() {
		try {
			Usuario instance = getInstance();
			String sPassword = Authenticator.getSecurePassword(instance.getClave(), Authenticator.getSalt());
			instance.setClave(sPassword);
			persist();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
	}
	
	public void actualizar() {
		try {
			Usuario instance = getInstance();
			String sPassword = Authenticator.getSecurePassword(instance.getClave(), Authenticator.getSalt());
			instance.setClave(sPassword);
			update();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
	}

}

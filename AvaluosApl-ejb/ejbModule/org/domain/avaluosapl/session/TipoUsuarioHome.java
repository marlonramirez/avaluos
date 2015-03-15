package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("tipoUsuarioHome")
public class TipoUsuarioHome extends EntityHome<TipoUsuario> {

	public void setTipoUsuarioIdTipoUsuario(Integer id) {
		setId(id);
	}

	public Integer getTipoUsuarioIdTipoUsuario() {
		return (Integer) getId();
	}

	@Override
	protected TipoUsuario createInstance() {
		TipoUsuario tipoUsuario = new TipoUsuario();
		return tipoUsuario;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public TipoUsuario getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Usuario> getUsuarios() {
		return getInstance() == null ? null : new ArrayList<Usuario>(
				getInstance().getUsuarios());
	}

}

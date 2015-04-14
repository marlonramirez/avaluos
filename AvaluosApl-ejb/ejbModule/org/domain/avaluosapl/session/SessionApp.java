package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.Usuario;
import org.domain.avaluosapl.util.FacesUtils;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Name(value = "sessionApp")
@Scope(ScopeType.SESSION)
public class SessionApp {
	private Usuario usuario;
	
	public SessionApp () {
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario (Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean hasPermiso (String codigos) {
		String[] cods = codigos.split(",");
		PermisoList permisoList = (PermisoList) FacesUtils.getManagedBean("permisoList");
		long cantidad = permisoList.getByMenu(this.usuario, cods);
		return cantidad > 0;
	}
	
}

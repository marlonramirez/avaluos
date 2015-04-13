package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.Usuario;
import org.domain.avaluosapl.util.FacesUtils;
import org.jboss.seam.ScopeType;

@org.jboss.seam.annotations.Name(value = "sessionApp")
@org.jboss.seam.annotations.Scope(ScopeType.SESSION)
@org.jboss.seam.annotations.Install(precedence = 0)
@org.jboss.seam.annotations.intercept.BypassInterceptors
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

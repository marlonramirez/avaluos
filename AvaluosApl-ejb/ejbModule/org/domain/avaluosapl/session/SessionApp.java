package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.Permiso;
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
	
	public boolean hasPermiso (String codCasoUso) {
		PermisoList permisoList = (PermisoList) FacesUtils.getManagedBean("permisoList");
		Permiso permiso = permisoList.getByUsuario(this.usuario, codCasoUso);
		if (permiso == null) {
			return false;
		}
		return permiso.getEstado() == 1;
	}
	
}

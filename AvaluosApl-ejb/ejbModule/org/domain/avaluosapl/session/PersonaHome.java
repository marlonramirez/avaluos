package org.domain.avaluosapl.session;

import org.domain.avaluosapl.entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("personaHome")
public class PersonaHome extends EntityHome<Persona> {
	@In(create = true)
	TipoDocHome tipoDocHome;
	@In(create = true)
	TelefonoHome telefonoHome;
	@In(create = true)
	DireccionHome direccionHome;
	@In(create = true)
	PersonaList personaList;
	
	private ArrayList<Telefono> deleteTels = new ArrayList<Telefono>();
	private ArrayList<Direccion> deleteDirs = new ArrayList<Direccion>();

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
	}

	public boolean isWired() {
		Persona instance = getInstance();
		if (instance.getTipoDoc() == null)
			return false;
		if (instance.getTelefonos().isEmpty()) {
			return false;
		}
		if (instance.getDireccions().isEmpty()) {
			return false;
		}
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
	
	public void addTelefono() {
		Persona persona = getInstance();
		Telefono tel = telefonoHome.getInstance();
		tel.setPersona(persona);
		persona.getTelefonos().add(tel);
	}
	
	public void addDireccion() {
		Persona persona = getInstance();
		Direccion dir = direccionHome.getInstance();
		dir.setPersona(persona);
		persona.getDireccions().add(dir);
	}
	
	public void removeTelefono(Telefono tel) {
		if (tel.getIdTelefono() != null) {
			deleteTels.add(tel);
		}
		getInstance().getTelefonos().remove(tel);
	}
	
	public void removeDireccion(Direccion dir) {
		if (dir.getIdDireccion() != null) {
			deleteDirs.add(dir);
		}
		getInstance().getDireccions().remove(dir);
	}
	
	public void guardar() {
		persist();
		Persona instance = getInstance();
		for (Telefono tel: instance.getTelefonos()) {
			getEntityManager().persist(tel);
		}
		for (Direccion dir: instance.getDireccions()) {
			getEntityManager().persist(dir);
		}
		getEntityManager().flush();
	}
	
	public void actualizar() {
		update();
		Persona instance = getInstance();
		for (Telefono tel: deleteTels) {
			getEntityManager().remove(tel);
		}
		for (Telefono tel: instance.getTelefonos()) {
			if (tel.getIdTelefono() == null) {
				getEntityManager().persist(tel);
			}
		}
		for (Direccion dir: deleteDirs) {
			getEntityManager().remove(dir);
		}
		for (Direccion dir: instance.getDireccions()) {
			if (dir.getIdDireccion() == null) {
				getEntityManager().persist(dir);
			}
		}
		getEntityManager().flush();
	}
	
	public void validateDoc(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		String num = String.valueOf(arg2);
		TipoDoc tipo = getInstance().getTipoDoc();
		if (num != null && !num.isEmpty() && tipo != null) {
			Persona per = personaList.getByDoc(tipo, num);
			if (per != null) {
				throw new ValidatorException(new FacesMessage("Ya existe una persona con "+tipo.getDescripcion()+" "+num));
			}
		}
	}
	
	public void validateEmail(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		String email = String.valueOf(arg2);
		String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Matcher matcher = Pattern.compile(pattern).matcher(email);
        if (!matcher.matches()) {   // Email doesn't match
            throw new ValidatorException(new FacesMessage("Email invalido"));
        }
		Persona per = personaList.getByEmail(email);
		if (per != null) {
			throw new ValidatorException(new FacesMessage("Ya existe una persona registrada con este mail"));
		}
	}

}

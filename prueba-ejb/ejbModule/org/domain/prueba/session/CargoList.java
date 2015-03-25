package org.domain.prueba.session;

import org.domain.prueba.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("cargoList")
public class CargoList extends EntityQuery<Cargo> {

	private static final String EJBQL = "select cargo from Cargo cargo";

	private static final String[] RESTRICTIONS = { "lower(cargo.descripcion) like lower(concat(#{cargoList.cargo.descripcion},'%'))", };

	private Cargo cargo = new Cargo();

	public CargoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Cargo getCargo() {
		return cargo;
	}
}

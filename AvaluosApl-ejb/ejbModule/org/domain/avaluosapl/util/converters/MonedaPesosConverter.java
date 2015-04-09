package org.domain.avaluosapl.util.converters;

import java.math.BigDecimal;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.intercept.BypassInterceptors;

@Name("monedaPesosConverter")
@BypassInterceptors
@org.jboss.seam.annotations.faces.Converter
public class MonedaPesosConverter implements Converter {

  public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
    // TODO Auto-generated method stub
    return arreglaMonedaPesos(arg2);
  }

  public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
    // TODO Auto-generated method stub

    String cad = "";

    // cad = "" + Currency.getInstance("USD").getSymbol(Locale.US)
    // + arreglaMonedaPesos((String) arg2);

    cad = "$$" + arreglaMonedaPesos((String) arg2);

    return cad;
  }

  private BigDecimal arreglaMonedaPesos(String val) {

    BigDecimal valBd = new BigDecimal(val);

    // if (val == null) {
    // valBd = new BigDecimal(0.00);
    // }

    valBd = new BigDecimal(0.00);

    String cad = "";
    cad += "valBd: " + valBd;

    System.out.println(cad);

    return valBd;
  }
}

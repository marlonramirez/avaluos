package org.domain.avaluosapl.session;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.domain.avaluosapl.entity.Activo;
import org.domain.avaluosapl.entity.Avaluo;
import org.domain.avaluosapl.entity.ItemAvaluo;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

@Name("avaluoHome")
public class AvaluoHome extends EntityHome<Avaluo> {

	@In(create = true)
	ActivoHome activoHome;
	@In(create = true)
	ItemAvaluoHome itemAvaluoHome;
	@In(create = true)
	PersonaList personaList;
	
	private ArrayList<ItemAvaluo> deleteItems = new ArrayList<ItemAvaluo>();
	private File avaluoPDF;
	private String namePDF;
	private final String PATH = "C:/JBOSS/avaluos/";

	public void setAvaluoIdAvaluo(Integer id) {
		setId(id);
	}

	public Integer getAvaluoIdAvaluo() {
		return (Integer) getId();
	}

	@Override
	protected Avaluo createInstance() {
		Avaluo avaluo = new Avaluo();
		avaluo.setActivo(new Activo());
		return avaluo;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Activo activo = activoHome.getDefinedInstance();
		if (activo != null) {
			getInstance().setActivo(activo);
		}
	}

	public boolean isWired() {
		if (getInstance().getActivo().getIdActivo() == null)
			return false;
		if (isManaged())
			return !getInstance().getItemAvaluos().isEmpty();
		return true;
	}

	public Avaluo getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ItemAvaluo> getItemAvaluos() {
		return getInstance() == null ? null : new ArrayList<ItemAvaluo>(
				getInstance().getItemAvaluos());
	}
	
	public void addItem() {
		Avaluo avaluo = getInstance();
		ItemAvaluo item = itemAvaluoHome.getInstance();
		item.setAvaluo(avaluo);
		avaluo.getItemAvaluos().add(item);
	}
	
	public void removeItem(ItemAvaluo item) {
		if (item.getIdItemAvaluo() != null) {
			deleteItems.add(item);
		}
		getInstance().getItemAvaluos().remove(item);
	}
	
	public void guardar() {
		getInstance().setNumOrden(getInstance().getCiudad().getAbbr());
		persist();
		getInstance().setNumOrden(getInstance().getNumOrden()+getInstance().getIdAvaluo());
		getEntityManager().merge(getInstance());
		getEntityManager().flush();
	}
	
	public void actualizar() {
		Avaluo instance = getInstance();
		if (avaluoPDF != null) {
			new File(PATH+instance.getArchivo()).delete();
			String formato = formatFile();
			copyFile(formato);
			instance.setArchivo(formato);
		}
		update();
		for (ItemAvaluo item: deleteItems) {
			itemAvaluoHome.setInstance(item);
			itemAvaluoHome.removeAllManoObras();
			getEntityManager().remove(item);
		}
		for (ItemAvaluo item: instance.getItemAvaluos()) {
			itemAvaluoHome.setInstance(item);
			if (item.getIdItemAvaluo() == null) {
				getEntityManager().persist(item);
				itemAvaluoHome.guardar();
			} else {
				itemAvaluoHome.actualizar();
			}
		}
		getEntityManager().flush();
	}
	
	private String formatFile() {
		Avaluo instance = getInstance();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		return personaList.getById(instance.getActivo().getIdCliente()).getNumDoc()+"_"+format.format(instance.getFechaEntrega())+"_"+this.namePDF;
	}
	
	private boolean copyFile(String name) {
		try {
			name = PATH+name;
    		FileInputStream in = new FileInputStream(this.avaluoPDF);
	    	FileOutputStream out = new FileOutputStream(name);
	    	int c;
			while( (c = in.read() ) != -1)
				out.write(c);
			in.close();
			out.close();
	        return true;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}    	
	}
	
	public void cargar(UploadEvent event) throws Exception {
    	UploadItem item = event.getUploadItem();
        this.avaluoPDF = item.getFile();
        this.namePDF = item.getFileName();
   }
	
	public InputStream getArchivo() {
		try {
			String name = PATH+getInstance().getArchivo();
			return new FileInputStream(name);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}

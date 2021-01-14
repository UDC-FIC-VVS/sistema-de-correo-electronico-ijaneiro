package gal.udc.fic.vvs.email.archivo;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public class Imagen extends Archivo {

    public Imagen(String nombre, String contenido) {
        super(nombre, contenido);
    }

    protected String obtenerMimeType() {
    	EtmPoint point = etmMonitor.createPoint("Imagen:obtenerMimeType");
    	point.collect();
        return "image/png";
    }

    private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();
}

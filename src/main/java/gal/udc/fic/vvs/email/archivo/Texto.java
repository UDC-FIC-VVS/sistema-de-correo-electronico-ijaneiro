package gal.udc.fic.vvs.email.archivo;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public class Texto extends Archivo {

    public Texto(String nombre, String contenido) {
        super(nombre, contenido);
    }

    protected String obtenerMimeType() {
    	EtmPoint point = etmMonitor.createPoint("Texto:obtenerMimeType");
    	point.collect();
        return "text/plain";
    }

    private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();
}

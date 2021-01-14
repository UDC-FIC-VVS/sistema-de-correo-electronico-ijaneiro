package gal.udc.fic.vvs.email.archivo;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public class Audio extends Archivo {

    public Audio(String nombre, String contenido) {
        super(nombre, contenido);
    }

    protected String obtenerMimeType() {
    	EtmPoint point = etmMonitor.createPoint("Audio:obtenerMimeType");
    	point.collect();
        return "audio/ogg";
    }

    private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();
}

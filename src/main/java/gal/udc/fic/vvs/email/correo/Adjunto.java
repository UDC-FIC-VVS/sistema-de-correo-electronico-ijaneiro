package gal.udc.fic.vvs.email.correo;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import gal.udc.fic.vvs.email.archivo.Archivo;

public class Adjunto extends DecoradorMensaje {

    public Adjunto(MensajeAbstracto mensaje, Archivo archivo) {
        super(mensaje);
        _archivo = archivo;
    }

    public int obtenerTamaño() {
    	EtmPoint point = etmMonitor.createPoint("Adjunto:obtenerTamaño");
    	point.collect();
        return super.obtenerTamaño() + _archivo.obtenerTamaño();
    }

    public String obtenerVisualizacion() {
    	EtmPoint point = etmMonitor.createPoint("Adjunto:obtenerTamaño");
    	point.collect();
        return super.obtenerVisualizacion() + "\n\nAdxunto: " + _archivo.obtenerPreVisualizacion();
    }

    private Archivo _archivo;
    private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();
}

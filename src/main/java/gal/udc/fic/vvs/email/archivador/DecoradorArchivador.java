package gal.udc.fic.vvs.email.archivador;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import gal.udc.fic.vvs.email.correo.Correo;

public abstract class DecoradorArchivador implements Archivador {

    public DecoradorArchivador(Archivador decorado) {
        _decorado = decorado;
    }

    public String obtenerNombre() {
    	EtmPoint point = etmMonitor.createPoint("DecoradorArchivador:obtenerNombre");
    	point.collect();
        return _decorado.obtenerNombre();
    }

    public boolean almacenarCorreo(Correo correo) {
    	EtmPoint point = etmMonitor.createPoint("DecoradorArchivador:almacenarCorreo");
    	point.collect();
        return _decorado.almacenarCorreo(correo);
    }

    public int obtenerEspacioTotal() {
    	EtmPoint point = etmMonitor.createPoint("DecoradorArchivador:obtenerEspacioTotal");
    	point.collect();
        return _decorado.obtenerEspacioTotal();
    }

    public int obtenerEspacioDisponible() {
    	EtmPoint point = etmMonitor.createPoint("DecoradorArchivador:obtenerEspacioDisponible");
    	point.collect();
        return _decorado.obtenerEspacioDisponible();
    }

    public Archivador obtenerDelegado() {
    	EtmPoint point = etmMonitor.createPoint("DecoradorArchivador:obtenerDelegado");
    	point.collect();
        return _decorado.obtenerDelegado();
    }

    public void establecerDelegado(Archivador archivador) {
    	EtmPoint point = etmMonitor.createPoint("DecoradorArchivador:establecerDelegado");
        _decorado.establecerDelegado(archivador);
        point.collect();
    }

    private Archivador _decorado;
    private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();

}

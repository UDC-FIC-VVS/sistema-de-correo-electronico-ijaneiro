package gal.udc.fic.vvs.email.correo;

import java.util.Collection;
import java.util.Iterator;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public class CarpetaLimitada extends CorreoAbstracto {

    public CarpetaLimitada(Carpeta carpeta, int tamaño) {
        _carpeta = carpeta;
        _tamaño = tamaño;
    }

    public void establecerLeido(boolean leido) {
    	EtmPoint point = etmMonitor.createPoint("CarpetaLimitada:establecerLeido");
        _carpeta.establecerLeido(leido);
        point.collect();
    }

    public int obtenerNoLeidos() {
    	EtmPoint point = etmMonitor.createPoint("CarpetaLimitada:obtenerNoLeidos");
    	point.collect();
        return _carpeta.obtenerNoLeidos();
    }

    public int obtenerTamaño() {
    	EtmPoint point = etmMonitor.createPoint("CarpetaLimitada:obtenerTamaño");
    	point.collect();
        return _carpeta.obtenerTamaño();
    }

    public Integer obtenerIcono() {
    	EtmPoint point = etmMonitor.createPoint("CarpetaLimitada:obtenerIcono");
    	point.collect();
        return _carpeta.obtenerIcono();
    }

    public String obtenerPreVisualizacion() {
    	EtmPoint point = etmMonitor.createPoint("CarpetaLimitada:obtenerPreVisualizacion");
    	point.collect();
        return _carpeta.obtenerPreVisualizacion();
    }

    public String obtenerVisualizacion() {
    	EtmPoint point = etmMonitor.createPoint("CarpetaLimitada:obtenerVisualizacion");
    	point.collect();
        return _carpeta.obtenerVisualizacion();
    }

    public String obtenerRuta() {
    	EtmPoint point = etmMonitor.createPoint("CarpetaLimitada:obtenerRuta");
    	point.collect();
        return _carpeta.obtenerRuta();
    }

    public Collection explorar() throws OperacionInvalida {
    	EtmPoint point = etmMonitor.createPoint("CarpetaLimitada:explorar");
    	point.collect();
        return _carpeta.explorar();
    }

    public Collection buscar(String busqueda) {
    	EtmPoint point = etmMonitor.createPoint("CarpetaLimitada:buscar");
        Collection resultado = _carpeta.buscar(busqueda);
        if (resultado.remove(_carpeta)) {
            resultado.add(this);
        }
        Iterator iResultado = resultado.iterator();
        for(int i=0; iResultado.hasNext(); i++) {
            iResultado.next();
            if (i > _tamaño) {
                iResultado.remove();
            }
        }
    	point.collect();
        return resultado;
    }

    public void añadir(Correo correo) throws OperacionInvalida {
    	EtmPoint point = etmMonitor.createPoint("CarpetaLimitada:añadir");
        _carpeta.añadir(correo);
    	point.collect();
    }

    public void eliminar(Correo correo) throws OperacionInvalida {
    	EtmPoint point = etmMonitor.createPoint("CarpetaLimitada:eliminar");
        _carpeta.eliminar(correo);
    	point.collect();
    }

    public Correo obtenerHijo(int n) throws OperacionInvalida {
    	EtmPoint point = etmMonitor.createPoint("CarpetaLimitada:obtenerHijo");
    	point.collect();
        return _carpeta.obtenerHijo(n);
    }

    public Correo obtenerPadre() {
    	EtmPoint point = etmMonitor.createPoint("CarpetaLimitada:obtenerPadre");
    	point.collect();
        return _carpeta.obtenerPadre();
    }

    protected void establecerPadre(Correo padre) {
    	EtmPoint point = etmMonitor.createPoint("CarpetaLimitada:establecerPadre");
        _carpeta.establecerPadre(padre);
    	point.collect();
    }

    private Carpeta _carpeta;
    private int _tamaño;
    private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();

}

package gal.udc.fic.vvs.email.correo;

import java.util.Collection;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public abstract class DecoradorMensaje extends MensajeAbstracto {

    public DecoradorMensaje(MensajeAbstracto decorado) {
        _decorado = decorado;
    }

    public void establecerLeido(boolean leido) {
    	EtmPoint point = etmMonitor.createPoint("DecoradorMensaje:establecerLeido");
        _decorado.establecerLeido(leido);
        point.collect();
    }

    public int obtenerNoLeidos() {
    	EtmPoint point = etmMonitor.createPoint("DecoradorMensaje:obtenerNoLeidos");
    	point.collect();
        return _decorado.obtenerNoLeidos();
    }

    public int obtenerTamaño() {
    	EtmPoint point = etmMonitor.createPoint("DecoradorMensaje:obtenerTamaño");
    	point.collect();
        return _decorado.obtenerTamaño();
    }

    public Integer obtenerIcono() {
    	EtmPoint point = etmMonitor.createPoint("DecoradorMensaje:obtenerIcono");
    	point.collect();
        return _decorado.obtenerIcono();
    }

    public String obtenerPreVisualizacion() {
    	EtmPoint point = etmMonitor.createPoint("DecoradorMensaje:obtenerPreVisualizacion");
    	point.collect();
        return _decorado.obtenerPreVisualizacion();
    }

    public String obtenerVisualizacion() {
    	EtmPoint point = etmMonitor.createPoint("DecoradorMensaje:obtenerVisualizacion");
    	point.collect();
        return _decorado.obtenerVisualizacion();
    }

    public String obtenerRuta() {
    	EtmPoint point = etmMonitor.createPoint("DecoradorMensaje:obtenerRuta");
    	point.collect();
        return _decorado.obtenerRuta();
    }

    public Collection explorar() throws OperacionInvalida {
    	EtmPoint point = etmMonitor.createPoint("DecoradorMensaje:explorar");
    	point.collect();
        return _decorado.explorar();
    }

    public Collection buscar(String busqueda) {
    	EtmPoint point = etmMonitor.createPoint("DecoradorMensaje:buscar");
        Collection resultado = _decorado.buscar(busqueda);
        if (resultado.remove(_decorado)) {
            resultado.add(this);
        }
    	point.collect();
        return resultado;
    }

    public void añadir(Correo correo) throws OperacionInvalida {
    	EtmPoint point = etmMonitor.createPoint("DecoradorMensaje:añadir");
        _decorado.añadir(correo);
    	point.collect();
    }

    public void eliminar(Correo correo) throws OperacionInvalida {
    	EtmPoint point = etmMonitor.createPoint("DecoradorMensaje:eliminar");
        _decorado.eliminar(correo);
    	point.collect();
    }

    public Correo obtenerHijo(int n) throws OperacionInvalida {
    	EtmPoint point = etmMonitor.createPoint("DecoradorMensaje:obtenerHijo");
    	point.collect();
        return _decorado.obtenerHijo(n);
    }

    public Correo obtenerPadre() {
    	EtmPoint point = etmMonitor.createPoint("DecoradorMensaje:obtenerPadre");
    	point.collect();
        return _decorado.obtenerPadre();
    }

    protected void establecerPadre(Correo padre) {
    	EtmPoint point = etmMonitor.createPoint("DecoradorMensaje:establecerPadre");
        _decorado.establecerPadre(padre);
    	point.collect();
    }

    private MensajeAbstracto _decorado;
    private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();

}

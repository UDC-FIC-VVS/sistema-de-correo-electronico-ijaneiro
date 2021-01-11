package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Texto;

public class AdjuntoTest {
	
	private Archivo archivo = new Texto("Texto","Texto");
	private Mensaje mensaje = new Mensaje(new Texto("Correo1", "Correo de prueba"));
	
	private DecoradorMensaje adjunto;

	@Before
	public void init() {
		adjunto = new Adjunto(mensaje, archivo);
	}
	
	@Test
	public void obtenerTamañoTest() {
		
		int tamaño = mensaje.obtenerTamaño() + archivo.obtenerTamaño();

		assertEquals(tamaño, adjunto.obtenerTamaño());
	}
	
	@Test
	public void obtenerVisualizacionTest() {
		
		String visualizacion = mensaje.obtenerVisualizacion() + "\n\nAdxunto: " + 
				archivo.obtenerPreVisualizacion();
		
		assertEquals(visualizacion, adjunto.obtenerVisualizacion());
	}
}

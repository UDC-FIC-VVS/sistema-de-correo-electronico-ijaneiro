package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class MensajeTest {
	
	private static final String NOMBRE_TEXTO = "TextoTest";
	private static final String CONTENIDO_TEXTO = "TextoTestContenido";
	private static final String BUSQUEDA_ERRONEA = "No_Existo";
	
	private Texto texto = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);
	private Mensaje mensaje;
	
	
	@Before
	public void init() {
		mensaje = new Mensaje(texto);
	}
	
	@Test
	public void establecerLeidoTest() {
		
		mensaje.establecerLeido(true);
		
		assertEquals(0, mensaje.obtenerNoLeidos());
	}
	
	@Test
	public void obtenerNoLeidosTest_NoLeido() {
		
		assertEquals(1, mensaje.obtenerNoLeidos());
	}
	
	@Test
	public void obtenerNoLeidosTest_Leido() {
		
		mensaje.establecerLeido(true);
		
		assertEquals(0, mensaje.obtenerNoLeidos());
	}
	
	@Test
	public void obtenerTamaño() {
		
		assertEquals(texto.obtenerTamaño(), mensaje.obtenerTamaño());
	}
	
	@Test
	public void obtenerIconoTest_IconoNuevoMensaje() {
		
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensaje.obtenerIcono());
	}
	
	@Test
	public void obtenerIconoTest_IconoMensaje() {
		
		mensaje.establecerLeido(true);
		
		assertEquals(Correo.ICONO_MENSAJE, mensaje.obtenerIcono());
	}
	
	@Test
	public void obtenerPreVisualizacionTest() {
		
		assertEquals(texto.obtenerContenido() + "...", mensaje.obtenerPreVisualizacion());
	}
	
	@Test
	public void obtenerVisualizacionTest() {
		
		assertEquals(texto.obtenerContenido(), mensaje.obtenerVisualizacion());
	}
	
	@Test
	public void buscarTest_Encuentra() {
		
		Vector<Mensaje> vector = (Vector<Mensaje>) mensaje.buscar(NOMBRE_TEXTO);
		
		assertEquals(mensaje, vector.elementAt(0));
	}
	
	@Test
	public void buscarTest_NoEncuentra() {
		
		Vector<Mensaje> vector = (Vector<Mensaje>) mensaje.buscar(BUSQUEDA_ERRONEA);
		
		assertTrue(vector.isEmpty());
	}

}

package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CarpetaTest {
	
	private static final String NOMBRE_TEXTO = "TextoTest";
	private static final String CONTENIDO_TEXTO = "TextoTestContenido";
	private static final String BUSQUEDA_ERRONEA = "No_Existo";
	
	private Correo mensaje = new Mensaje(new Texto("Correo1", "Correo de prueba"));
	private Texto texto = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);
	private Correo otroMensaje = new Mensaje(texto);

	private static final String NOMBRE_CARPETA = "nombreCarpeta";
	private static final String OTRO_NOMBRE_CARPETA = "otroNombreCarpeta";
	
	private Carpeta carpeta;
	private Carpeta otraCarpeta = new Carpeta(OTRO_NOMBRE_CARPETA);
	
	@Before
	public void init() {
		carpeta = new Carpeta(NOMBRE_CARPETA);
	}
	
	@Test
	public void explorarTest() throws OperacionInvalida {
		Collection vector = carpeta.explorar();
		
		assertTrue(vector.isEmpty());
	}
	
	@Test
	public void añadirTest_SinPadre() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		Collection vector = carpeta.explorar();
		
		assertFalse(vector.isEmpty());
	}
	
	@Test
	public void añadirTest_ConPadre() throws OperacionInvalida {
		otraCarpeta.añadir(mensaje);
		carpeta.añadir(mensaje);
		Collection vector = carpeta.explorar();
		
		assertFalse(vector.isEmpty());
	}
	
	@Test
	public void eliminarTest_Existe() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		carpeta.eliminar(mensaje);
		Collection vector = carpeta.explorar();
		
		assertTrue(vector.isEmpty());
	}
	
	@Test
	public void eliminarTest_NoExiste() throws OperacionInvalida {
		carpeta.eliminar(mensaje);
		Collection vector = carpeta.explorar();
		
		assertTrue(vector.isEmpty());
	}
	
	@Test
	public void obtenerHijoTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		Collection vector = carpeta.explorar();
		
		assertEquals(mensaje, carpeta.obtenerHijo(0));
	}
	
	@Test
	public void establecerLeidoTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		carpeta.establecerLeido(true);
		
		assertEquals(0, carpeta.obtenerNoLeidos());
	}
	
	@Test
	public void obtenerNoLeidosTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		carpeta.añadir(otroMensaje);
		
		assertEquals(2, carpeta.obtenerNoLeidos());
	}
	
	@Test
	public void obtenerTamañoTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		carpeta.añadir(otroMensaje);
		
		int tamaño = mensaje.obtenerTamaño() + otroMensaje.obtenerTamaño();
		assertEquals(tamaño, carpeta.obtenerTamaño());
	}
	
	@Test
	public void obtenerPreVisualizacionTest() throws OperacionInvalida {
		
		assertEquals(NOMBRE_CARPETA, carpeta.obtenerPreVisualizacion());
	}
	
	@Test
	public void obtenerVisualizacionTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		carpeta.añadir(otroMensaje);
		String expected = NOMBRE_CARPETA + " (2)";
		
		assertEquals(expected, carpeta.obtenerVisualizacion());
	}
	
	@Test
	public void buscarTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		carpeta.añadir(otroMensaje);
		
		Collection resultadoBusqueda = carpeta.buscar("texto");
		
		Collection resultadoEsperado = new Vector();
		resultadoEsperado.add(otroMensaje);
		
		assertEquals(resultadoEsperado, resultadoBusqueda);
	}
	
	@Test
	public void obtenerIconoTest() throws OperacionInvalida {
		
		assertEquals(Correo.ICONO_CARPETA, carpeta.obtenerIcono());
	}

}

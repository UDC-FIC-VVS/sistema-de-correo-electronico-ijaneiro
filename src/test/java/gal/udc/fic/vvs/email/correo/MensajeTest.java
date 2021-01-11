package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gal.udc.fic.vvs.email.archivo.Texto;

public class MensajeTest {
	
	private static final String NOMBRE_TEXTO = "TextoTest";
	private static final String CONTENIDO_TEXTO = "TextoTestContenido";
	private static final String BUSQUEDA_ERRONEA = "No_Existo";
	
	private Texto texto = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);
	private Mensaje mensaje;
	private Mensaje otroMensaje = new Mensaje(texto);
	
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
	
	/*Test metodos heredados*/
	
	@Test(expected = OperacionInvalida.class)
	public void explorarTest() throws OperacionInvalida{
		mensaje.explorar();
    }
	
	@Test(expected = OperacionInvalida.class)
    public void añadirTest() throws OperacionInvalida {
		mensaje.añadir(mensaje);
    }
	
	@Test(expected = OperacionInvalida.class)
    public void eliminarTest() throws OperacionInvalida {
		mensaje.eliminar(mensaje);
    }

	@Test(expected = OperacionInvalida.class)
    public void obtenerHijoTest() throws OperacionInvalida {
		mensaje.obtenerHijo(0);
    }
	
	@Test
	public void obtenerPadreTest() {
        assertNull(mensaje.obtenerPadre());
    }
	
	@Test
	public void establecerPadreTest() {
    	
       mensaje.establecerPadre(otroMensaje);
       assertEquals(otroMensaje, mensaje.obtenerPadre());
    }
	
	@Test
    public void obtenerRutaTest_SinPadre() {
		
		assertEquals(mensaje.obtenerPreVisualizacion(), mensaje.obtenerRuta());
	}
	
	@Test
    public void obtenerRutaTest_ConPadre() {
		mensaje.establecerPadre(otroMensaje);
		
		String visualizacion = otroMensaje.obtenerPreVisualizacion() + " > " + 
				mensaje.obtenerPreVisualizacion();
		
		assertEquals(visualizacion, mensaje.obtenerRuta());
	}

}

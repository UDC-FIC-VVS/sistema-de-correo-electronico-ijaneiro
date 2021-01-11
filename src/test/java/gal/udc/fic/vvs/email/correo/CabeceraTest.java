package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CabeceraTest {
	
	private String nombre = "Cabecera";
	private String valor = "Valor Cabecera";
	private Mensaje mensaje = new Mensaje(new Texto("Correo1", "Correo de prueba"));
	
	private static final String NOMBRE_TEXTO = "TextoTest";
	private static final String CONTENIDO_TEXTO = "TextoTestContenido";
	private Texto texto = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);
	private static final String BUSQUEDA_ERRONEA = "No_Existo";
	private Mensaje otroMensaje = new Mensaje(texto);
	
	private DecoradorMensaje cabecera;

	@Before
	public void init() {
		cabecera = new Cabecera(mensaje, nombre, valor);
	}
	
	@Test
	public void obtenerTamañoTest() {
		
		int tamaño = mensaje.obtenerTamaño() + nombre.length() + valor.length();

		assertEquals(tamaño, cabecera.obtenerTamaño());
	}
	
	@Test
	public void obtenerVisualizacionTest() {
		
		String visualizacion = nombre  + ": " + valor + "\n" + 
				mensaje.obtenerVisualizacion();
		
		assertEquals(visualizacion, cabecera.obtenerVisualizacion());
	}
	
	
	/*Test metodos heredados*/
	
	@Test
	public void establecerLeidoTest() {
        cabecera.establecerLeido(true);
        
        assertEquals(0, cabecera.obtenerNoLeidos());
    }
	
	@Test
    public void obtenerNoLeidosTest() {
        
        assertEquals(1, cabecera.obtenerNoLeidos());
    }
    
	@Test
    public void obtenerIconoTest() {
		
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, cabecera.obtenerIcono());
    }

	@Test
    public void obtenerPreVisualizacionTest() {
		
		assertEquals(mensaje.obtenerPreVisualizacion(), cabecera.obtenerPreVisualizacion());
    }
    
	@Test
    public void obtenerRutaTest() {
		assertEquals(mensaje.obtenerPreVisualizacion(), cabecera.obtenerRuta());
    }

	@Test(expected = OperacionInvalida.class)
    public void explorarTest() throws OperacionInvalida {
        cabecera.explorar();
    }

	@Test
	public void buscarTest_Encuentra() {
		
		Vector<MensajeAbstracto> vector = (Vector<MensajeAbstracto>) cabecera.buscar("Correo");
		
		assertEquals(cabecera, vector.elementAt(0));
	}
	
	@Test
	public void buscarTest_NoEncuentra() {
		
		Vector<Mensaje> vector = (Vector<Mensaje>) mensaje.buscar(BUSQUEDA_ERRONEA);
		
		assertTrue(vector.isEmpty());
	}

	@Test(expected = OperacionInvalida.class)
    public void añadirTest() throws OperacionInvalida {
        cabecera.añadir(cabecera);
    }

	@Test(expected = OperacionInvalida.class)
    public void eliminarTest() throws OperacionInvalida {
		cabecera.eliminar(cabecera);
    }

	@Test(expected = OperacionInvalida.class)
    public void obtenerHijoTest() throws OperacionInvalida {
        cabecera.obtenerHijo(0);
    }

	@Test
    public void obtenerPadreTest() {
        assertNull(cabecera.obtenerPadre());
    }

	@Test
    public void establecerPadre() {
		
		cabecera.establecerPadre(otroMensaje);
		
	    assertEquals(otroMensaje, mensaje.obtenerPadre());
    }

}

package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.util.JetmUtil;

public class MensajeTest {
	
	private static final String NOMBRE_TEXTO = "TextoTest";
	private static final String CONTENIDO_TEXTO = "TextoTestContenido";
	private static final String BUSQUEDA_ERRONEA = "No_Existo";
	
	private Texto texto = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);
	private Mensaje mensaje;
	private Mensaje otroMensaje = new Mensaje(texto);

	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<----------------------------------------------------------------->");
		System.out.println("<----------------------- JETM MENSAJE TEST ----------------------->");
		System.out.println("<----------------------------------------------------------------->");
		// configure measurement framework
        JetmUtil.setup();
	}
	
	@AfterClass
	public static void cerrarJetm(){		
		// shutdown measurement framework
		JetmUtil.tearDown();
	}
	
	@Before
	public void init() {
		mensaje = new Mensaje(texto);
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion establecerLeido.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void establecerLeidoTest() {
		
		mensaje.establecerLeido(true);
		
		assertEquals(0, mensaje.obtenerNoLeidos());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerNoLeidos.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerNoLeidosTest_NoLeido() {
		
		assertEquals(1, mensaje.obtenerNoLeidos());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerNoLeidos.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerNoLeidosTest_Leido() {
		
		mensaje.establecerLeido(true);
		
		assertEquals(0, mensaje.obtenerNoLeidos());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerIcono.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerIconoTest_IconoNuevoMensaje() {
		
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensaje.obtenerIcono());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerIcono.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerIconoTest_IconoMensaje() {
		
		mensaje.establecerLeido(true);
		
		assertEquals(Correo.ICONO_MENSAJE, mensaje.obtenerIcono());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerPreVisualizacion.
	 * <p>
	 * --> Nivel: Prueba de Integracion
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerPreVisualizacionTest() {
		
		assertEquals(texto.obtenerContenido() + "...", mensaje.obtenerPreVisualizacion());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerVisualizacion.
	 * <p>
	 * --> Nivel: Prueba de Integracion
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerVisualizacionTest() {
		
		assertEquals(texto.obtenerContenido(), mensaje.obtenerVisualizacion());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion buscar.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void buscarTest_Encuentra() {
		
		Vector<Mensaje> vector = (Vector<Mensaje>) mensaje.buscar(NOMBRE_TEXTO);
		
		assertEquals(mensaje, vector.elementAt(0));
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion buscar.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void buscarTest_NoEncuentra() {
		
		Vector<Mensaje> vector = (Vector<Mensaje>) mensaje.buscar(BUSQUEDA_ERRONEA);
		
		assertTrue(vector.isEmpty());
	}
	
	/*Test metodos heredados*/

	/**
	 * Test para comporbar el funcionamiento de la funcion explorar.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test(expected = OperacionInvalida.class)
	public void explorarTest() throws OperacionInvalida{
		mensaje.explorar();
    }

	/**
	 * Test para comporbar el funcionamiento de la funcion añadir.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test(expected = OperacionInvalida.class)
    public void añadirTest() throws OperacionInvalida {
		mensaje.añadir(mensaje);
    }

	/**
	 * Test para comporbar el funcionamiento de la funcion eliminar.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test(expected = OperacionInvalida.class)
    public void eliminarTest() throws OperacionInvalida {
		mensaje.eliminar(mensaje);
    }

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerHijo.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test(expected = OperacionInvalida.class)
    public void obtenerHijoTest() throws OperacionInvalida {
		mensaje.obtenerHijo(0);
    }

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerPadre.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerPadreTest() {
        assertNull(mensaje.obtenerPadre());
    }

	/**
	 * Test para comporbar el funcionamiento de la funcion establecerPadre.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void establecerPadreTest() {
    	
       mensaje.establecerPadre(otroMensaje);
       assertEquals(otroMensaje, mensaje.obtenerPadre());
    }

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerRuta.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
    public void obtenerRutaTest_SinPadre() {
		
		assertEquals(mensaje.obtenerPreVisualizacion(), mensaje.obtenerRuta());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerRuta.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
    public void obtenerRutaTest_ConPadre() {
		mensaje.establecerPadre(otroMensaje);
		
		String visualizacion = otroMensaje.obtenerPreVisualizacion() + " > " + 
				mensaje.obtenerPreVisualizacion();
		
		assertEquals(visualizacion, mensaje.obtenerRuta());
	}

}

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

	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<------------------------------------------------------------------>");
		System.out.println("<----------------------- JETM CABECERA TEST ----------------------->");
		System.out.println("<------------------------------------------------------------------>");
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
		cabecera = new Cabecera(mensaje, nombre, valor);
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerTamaño.
	 * <p>
	 * --> Nivel: Prueba de Integracion
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerTamañoTest() {
		
		int tamaño = mensaje.obtenerTamaño() + nombre.length() + valor.length();

		assertEquals(tamaño, cabecera.obtenerTamaño());
	}	
	
	/*Test metodos heredados*/

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
        cabecera.establecerLeido(true);
        
        assertEquals(0, cabecera.obtenerNoLeidos());
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
    public void obtenerNoLeidosTest() {
        
        assertEquals(1, cabecera.obtenerNoLeidos());
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
    public void obtenerIconoTest() {
		
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, cabecera.obtenerIcono());
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
		
		assertEquals(mensaje.obtenerPreVisualizacion(), cabecera.obtenerPreVisualizacion());
    }
    
	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerRuta.
	 * <p>
	 * --> Nivel: Prueba de Integracion
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
    public void obtenerRutaTest() {
		assertEquals(mensaje.obtenerPreVisualizacion(), cabecera.obtenerRuta());
    }


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
    public void explorarTest() throws OperacionInvalida {
        cabecera.explorar();
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
		
		Vector<MensajeAbstracto> vector = (Vector<MensajeAbstracto>) cabecera.buscar("Correo");
		
		assertEquals(cabecera, vector.elementAt(0));
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
        cabecera.añadir(cabecera);
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
		cabecera.eliminar(cabecera);
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
        cabecera.obtenerHijo(0);
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
        assertNull(cabecera.obtenerPadre());
    }


	/**
	 * Test para comporbar el funcionamiento de la funcion establecerPadre.
	 * <p>
	 * --> Nivel: Prueba de Integracion
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
    public void establecerPadreTest() {
		
		cabecera.establecerPadre(otroMensaje);
		
	    assertEquals(otroMensaje, mensaje.obtenerPadre());
    }

}

package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Vector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.util.JetmUtil;

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
	

	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<----------------------------------------------------------------->");
		System.out.println("<----------------------- JETM CARPETA TEST ----------------------->");
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
		carpeta = new Carpeta(NOMBRE_CARPETA);
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
	@Test
	public void explorarTest() throws OperacionInvalida {
		Collection vector = carpeta.explorar();
		
		assertTrue(vector.isEmpty());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion añadir.
	 * <p>
	 * --> Nivel: Prueba de Integracion
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void añadirTest_SinPadre() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		Collection vector = carpeta.explorar();
		
		assertFalse(vector.isEmpty());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion añadir.
	 * <p>
	 * --> Nivel: Prueba de Integracion
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void añadirTest_ConPadre() throws OperacionInvalida {
		otraCarpeta.añadir(mensaje);
		carpeta.añadir(mensaje);
		Collection vector = carpeta.explorar();
		
		assertFalse(vector.isEmpty());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion eliminar.
	 * <p>
	 * --> Nivel: Prueba de Integracion
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void eliminarTest_Existe() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		carpeta.eliminar(mensaje);
		Collection vector = carpeta.explorar();
		
		assertTrue(vector.isEmpty());
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
	@Test
	public void eliminarTest_NoExiste() throws OperacionInvalida {
		carpeta.eliminar(mensaje);
		Collection vector = carpeta.explorar();
		
		assertTrue(vector.isEmpty());
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
	@Test
	public void obtenerHijoTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		Collection vector = carpeta.explorar();
		
		assertEquals(mensaje, carpeta.obtenerHijo(0));
	}


	/**
	 * Test para comporbar el funcionamiento de la funcion establecerLeido.
	 * <p>
	 * --> Nivel: Prueba de Integracion
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void establecerLeidoTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		carpeta.establecerLeido(true);
		
		assertEquals(0, carpeta.obtenerNoLeidos());
	}


	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerNoLeidos.
	 * <p>
	 * --> Nivel: Prueba de Integracion
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerNoLeidosTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		carpeta.añadir(otroMensaje);
		
		assertEquals(2, carpeta.obtenerNoLeidos());
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
	public void obtenerTamañoTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		carpeta.añadir(otroMensaje);
		
		int tamaño = mensaje.obtenerTamaño() + otroMensaje.obtenerTamaño();
		assertEquals(tamaño, carpeta.obtenerTamaño());
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
	public void obtenerVisualizacionTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		carpeta.añadir(otroMensaje);
		String expected = NOMBRE_CARPETA + " (2)";
		
		assertEquals(expected, carpeta.obtenerVisualizacion());
	}


	/**
	 * Test para comporbar el funcionamiento de la funcion buscar.
	 * <p>
	 * --> Nivel: Prueba de Integracion
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void buscarTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		carpeta.añadir(otroMensaje);
		
		Collection resultadoBusqueda = carpeta.buscar("texto");
		
		Collection resultadoEsperado = new Vector();
		resultadoEsperado.add(otroMensaje);
		
		assertEquals(resultadoEsperado, resultadoBusqueda);
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
	public void obtenerIconoTest() throws OperacionInvalida {
		
		assertEquals(Correo.ICONO_CARPETA, carpeta.obtenerIcono());
	}

}

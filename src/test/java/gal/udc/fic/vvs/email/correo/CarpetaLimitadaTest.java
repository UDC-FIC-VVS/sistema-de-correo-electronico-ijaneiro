package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Vector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.util.JetmUtil;

public class CarpetaLimitadaTest {

	private static final String NOMBRE_TEXTO = "TextoTest";
	private static final String CONTENIDO_TEXTO = "TextoTestContenido";
	private static final String BUSQUEDA_ERRONEA = "No_Existo";
	
	private Correo mensaje = new Mensaje(new Texto("Correo1", "Correo de prueba"));
	private Texto texto = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);
	private Correo otroMensaje = new Mensaje(texto);
	
	private Texto otroTexto = new Texto("Correo2", "Otro correo de prueba");
	private Correo mensaje1 = new Mensaje(otroTexto);
	private Correo mensaje2 = new Mensaje(otroTexto);
	private Correo mensaje3 = new Mensaje(otroTexto);
	private Correo mensaje4 = new Mensaje(otroTexto);
	private Correo mensaje5 = new Mensaje(otroTexto);
	private Correo mensaje6 = new Mensaje(otroTexto);
	private Correo mensaje7 = new Mensaje(otroTexto);
	private Correo mensaje8 = new Mensaje(otroTexto);
	private Correo mensaje9 = new Mensaje(otroTexto);

	private static final String NOMBRE_CARPETA = "nombreCarpeta";
	private static final String OTRO_NOMBRE_CARPETA = "otroNombreCarpeta";
	private static final int LIMITE_CARPETA = 7;
	
	private Carpeta carpeta;
	private CarpetaLimitada carpetaLimitada;
	private Carpeta otraCarpeta = new Carpeta(OTRO_NOMBRE_CARPETA);
	private CarpetaLimitada otraCarpetaLimitada = new CarpetaLimitada(otraCarpeta, LIMITE_CARPETA);

	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<-------------------------------------------------------------------------->");
		System.out.println("<----------------------- JETM CARPETA LIMITADA TEST ----------------------->");
		System.out.println("<-------------------------------------------------------------------------->");
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
		carpetaLimitada = new CarpetaLimitada(carpeta, LIMITE_CARPETA);
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion explorar.
	 * <p>
	 * --> Nivel: Prueba de Integracion
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void explorarTest() throws OperacionInvalida {
		Collection vector = carpetaLimitada.explorar();
		
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
		carpetaLimitada.añadir(mensaje);
		Collection vector = carpetaLimitada.explorar();
		
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
		otraCarpetaLimitada.añadir(mensaje);
		carpetaLimitada.añadir(mensaje);
		Collection vector = carpetaLimitada.explorar();
		
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
		carpetaLimitada.añadir(mensaje);
		carpetaLimitada.eliminar(mensaje);
		Collection vector = carpetaLimitada.explorar();
		
		assertTrue(vector.isEmpty());
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
	public void eliminarTest_NoExiste() throws OperacionInvalida {
		carpetaLimitada.eliminar(mensaje);
		Collection vector = carpetaLimitada.explorar();
		
		assertTrue(vector.isEmpty());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerHijo.
	 * <p>
	 * --> Nivel: Prueba de Integracion
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerHijoTest() throws OperacionInvalida {
		carpetaLimitada.añadir(mensaje);
		Collection vector = carpetaLimitada.explorar();
		
		assertEquals(mensaje, carpetaLimitada.obtenerHijo(0));
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
		carpetaLimitada.añadir(mensaje);
		carpetaLimitada.establecerLeido(true);
		
		assertEquals(0, carpetaLimitada.obtenerNoLeidos());
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
		carpetaLimitada.añadir(mensaje);
		carpetaLimitada.añadir(otroMensaje);
		
		assertEquals(2, carpetaLimitada.obtenerNoLeidos());
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
		carpetaLimitada.añadir(mensaje);
		carpetaLimitada.añadir(otroMensaje);
		
		int tamaño = mensaje.obtenerTamaño() + otroMensaje.obtenerTamaño();
		assertEquals(tamaño, carpetaLimitada.obtenerTamaño());
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
		carpetaLimitada.añadir(mensaje);
		carpetaLimitada.añadir(otroMensaje);
		String expected = NOMBRE_CARPETA + " (2)";
		
		assertEquals(expected, carpetaLimitada.obtenerVisualizacion());
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
	public void buscarTest_Mensaje() throws OperacionInvalida {
		carpetaLimitada.añadir(mensaje);
		carpetaLimitada.añadir(otroMensaje);
		
		Collection resultadoBusqueda = carpetaLimitada.buscar("texto");
		
		Collection resultadoEsperado = new Vector();
		resultadoEsperado.add(otroMensaje);
		
		assertEquals(resultadoEsperado, resultadoBusqueda);
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
	public void buscarTest_Limite() throws OperacionInvalida {
		/*añado 10*/
		carpetaLimitada.añadir(mensaje);
		carpetaLimitada.añadir(mensaje1);
		carpetaLimitada.añadir(mensaje2);
		carpetaLimitada.añadir(mensaje3);
		carpetaLimitada.añadir(mensaje4);
		carpetaLimitada.añadir(mensaje5);
		carpetaLimitada.añadir(mensaje6);
		carpetaLimitada.añadir(mensaje7);
		carpetaLimitada.añadir(mensaje8);
		carpetaLimitada.añadir(mensaje9);
		
		Collection resultadoBusqueda = carpetaLimitada.buscar("Correo");
		/*se muestran 8 por ser carpeta limitada*/
		assertEquals(8, resultadoBusqueda.size());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerIcono.
	 * <p>
	 * --> Nivel: Prueba de Integracion
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerIconoTest() throws OperacionInvalida {
		
		assertEquals(Correo.ICONO_CARPETA, carpetaLimitada.obtenerIcono());
	}

}

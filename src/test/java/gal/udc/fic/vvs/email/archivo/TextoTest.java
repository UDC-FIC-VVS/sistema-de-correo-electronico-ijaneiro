package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gal.udc.fic.vvs.email.util.JetmUtil;

public class TextoTest {

	private static final String NOMBRE_ARCHIVO = "TextoTest";
	private static final String CONTENIDO_ARCHIVO = "TextoTestContenido";
	private static final int TAMAÑO_ARCHIVO = CONTENIDO_ARCHIVO.length();
	private static final String MIME_TYPE = "text/plain";
	private static final String PREVISUALIZACION_ARCHIVO = NOMBRE_ARCHIVO + "(" + TAMAÑO_ARCHIVO + " bytes, " + MIME_TYPE + ")";
	
	private Archivo texto;
	
	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<--------------------------------------------------------------->");
		System.out.println("<----------------------- JETM TEXTO TEST ----------------------->");
		System.out.println("<--------------------------------------------------------------->");
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
		texto = new Texto(NOMBRE_ARCHIVO, CONTENIDO_ARCHIVO);
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerNombre.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerNombreTest() {

		assertEquals(NOMBRE_ARCHIVO, texto.obtenerNombre());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerContenido.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerContenidoTest() {

		assertEquals(CONTENIDO_ARCHIVO, texto.obtenerContenido());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerMimeType.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerMimeTypeTest() {

		assertEquals(MIME_TYPE, texto.obtenerMimeType());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerPreVisualizacion.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerPreVisualizacionTest() {

		assertEquals(PREVISUALIZACION_ARCHIVO, texto.obtenerPreVisualizacion());
	}
}

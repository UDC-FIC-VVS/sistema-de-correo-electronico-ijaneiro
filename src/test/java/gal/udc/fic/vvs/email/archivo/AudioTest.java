package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gal.udc.fic.vvs.email.util.JetmUtil;

public class AudioTest {
	
	private static final String NOMBRE_ARCHIVO = "AudioTest";
	private static final String CONTENIDO_ARCHIVO = "AudioTestContenido";
	private static final int TAMAÑO_ARCHIVO = CONTENIDO_ARCHIVO.length();
	private static final String MIME_TYPE = "audio/ogg";
	private static final String PREVISUALIZACION_ARCHIVO = NOMBRE_ARCHIVO + "(" + TAMAÑO_ARCHIVO + " bytes, " + MIME_TYPE + ")";
	
	private Archivo audio;
	
	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<--------------------------------------------------------------->");
		System.out.println("<----------------------- JETM AUDIO TEST ----------------------->");
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
		audio = new Audio(NOMBRE_ARCHIVO, CONTENIDO_ARCHIVO);
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

		assertEquals(CONTENIDO_ARCHIVO, audio.obtenerContenido());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerTamaño.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerTamañoTest() {

		assertEquals(TAMAÑO_ARCHIVO, audio.obtenerTamaño());
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

		assertEquals(MIME_TYPE, audio.obtenerMimeType());
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

		assertEquals(PREVISUALIZACION_ARCHIVO, audio.obtenerPreVisualizacion());
	}

}

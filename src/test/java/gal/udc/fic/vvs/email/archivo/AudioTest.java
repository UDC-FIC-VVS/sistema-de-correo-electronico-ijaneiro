package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AudioTest {
	
	private static final String NOMBRE_ARCHIVO = "AudioTest";
	private static final String CONTENIDO_ARCHIVO = "AudioTestContenido";
	private static final int TAMAÑO_ARCHIVO = CONTENIDO_ARCHIVO.length();
	private static final String MIME_TYPE = "audio/ogg";
	private static final String PREVISUALIZACION_ARCHIVO = NOMBRE_ARCHIVO + "(" + TAMAÑO_ARCHIVO + " bytes, " + MIME_TYPE + ")";
	
	private Archivo audio;
	
	@Before
	public void init() {
		audio = new Audio(NOMBRE_ARCHIVO, CONTENIDO_ARCHIVO);
	}

	@Test
	public void obtenerNombreTest() {

		assertEquals(NOMBRE_ARCHIVO, audio.obtenerNombre());
	}
	
	@Test
	public void obtenerContenidoTest() {

		assertEquals(CONTENIDO_ARCHIVO, audio.obtenerContenido());
	}
	
	@Test
	public void obtenerTamañoTest() {

		assertEquals(TAMAÑO_ARCHIVO, audio.obtenerTamaño());
	}
	
	@Test
	public void obtenerMimeTypeTest() {

		assertEquals(MIME_TYPE, audio.obtenerMimeType());
	}
	
	@Test
	public void obtenerPreVisualizacionTest() {

		assertEquals(PREVISUALIZACION_ARCHIVO, audio.obtenerPreVisualizacion());
	}

}

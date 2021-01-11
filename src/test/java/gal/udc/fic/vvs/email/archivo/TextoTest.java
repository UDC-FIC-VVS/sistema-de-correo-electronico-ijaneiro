package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TextoTest {

	private static final String NOMBRE_ARCHIVO = "TextoTest";
	private static final String CONTENIDO_ARCHIVO = "TextoTestContenido";
	private static final int TAMAÑO_ARCHIVO = CONTENIDO_ARCHIVO.length();
	private static final String MIME_TYPE = "text/plain";
	private static final String PREVISUALIZACION_ARCHIVO = NOMBRE_ARCHIVO + "(" + TAMAÑO_ARCHIVO + " bytes, " + MIME_TYPE + ")";
	
	private Archivo texto;
	
	@Before
	public void init() {
		texto = new Texto(NOMBRE_ARCHIVO, CONTENIDO_ARCHIVO);
	}

	@Test
	public void obtenerNombreTest() {

		assertEquals(NOMBRE_ARCHIVO, texto.obtenerNombre());
	}
	
	@Test
	public void obtenerContenidoTest() {

		assertEquals(CONTENIDO_ARCHIVO, texto.obtenerContenido());
	}
	
	@Test
	public void obtenerTamañoTest() {

		assertEquals(TAMAÑO_ARCHIVO, texto.obtenerTamaño());
	}
	
	@Test
	public void obtenerMimeTypeTest() {

		assertEquals(MIME_TYPE, texto.obtenerMimeType());
	}
	
	@Test
	public void obtenerPreVisualizacionTest() {

		assertEquals(PREVISUALIZACION_ARCHIVO, texto.obtenerPreVisualizacion());
	}
}

package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ImagenTest {

	private static final String NOMBRE_ARCHIVO = "ImageTest";
	private static final String CONTENIDO_ARCHIVO = "ImageTestContenido";
	private static final int TAMAÑO_ARCHIVO = CONTENIDO_ARCHIVO.length();
	private static final String MIME_TYPE = "image/png";
	private static final String PREVISUALIZACION_ARCHIVO = NOMBRE_ARCHIVO + "(" + TAMAÑO_ARCHIVO + " bytes, " + MIME_TYPE + ")";
	
	private Archivo imagen;
	
	@Before
	public void init() {
		imagen = new Imagen(NOMBRE_ARCHIVO, CONTENIDO_ARCHIVO);
	}

	@Test
	public void obtenerNombreTest() {

		assertEquals(NOMBRE_ARCHIVO, imagen.obtenerNombre());
	}
	
	@Test
	public void obtenerTamañoTest() {

		assertEquals(TAMAÑO_ARCHIVO, imagen.obtenerTamaño());
	}
	
	@Test
	public void obtenerMimeTypeTest() {

		assertEquals(MIME_TYPE, imagen.obtenerMimeType());
	}
	
	@Test
	public void obtenerPreVisualizacionTest() {

		assertEquals(PREVISUALIZACION_ARCHIVO, imagen.obtenerPreVisualizacion());
	}

}

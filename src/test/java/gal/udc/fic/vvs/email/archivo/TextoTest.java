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

	@Test
	public void obtenerNombreTest() {

		assertEquals(NOMBRE_ARCHIVO, texto.obtenerNombre());
	}
	
	@Test
	public void obtenerContenidoTest() {

		assertEquals(CONTENIDO_ARCHIVO, texto.obtenerContenido());
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

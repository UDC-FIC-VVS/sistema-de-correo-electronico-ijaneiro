package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.util.JetmUtil;

public class AdjuntoTest {
	
	private Archivo archivo = new Texto("Texto","Texto");
	private Mensaje mensaje = new Mensaje(new Texto("Correo1", "Correo de prueba"));
	
	private DecoradorMensaje adjunto;
	

	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<----------------------------------------------------------------->");
		System.out.println("<----------------------- JETM ADJUNTO TEST ----------------------->");
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
		adjunto = new Adjunto(mensaje, archivo);
	}
	
	@Test
	public void obtenerTamañoTest() {
		
		int tamaño = mensaje.obtenerTamaño() + archivo.obtenerTamaño();

		assertEquals(tamaño, adjunto.obtenerTamaño());
	}
}

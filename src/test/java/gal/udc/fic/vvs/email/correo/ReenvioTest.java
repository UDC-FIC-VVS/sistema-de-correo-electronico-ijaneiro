package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.util.JetmUtil;

public class ReenvioTest {
	
	private Mensaje mensaje = new Mensaje(new Texto("Correo1", "Correo de prueba"));
	private Mensaje mensajeReenviar = new Mensaje(new Texto("Correo2", "Correo a reenviar"));
	
	private DecoradorMensaje reenvio;
	

	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<----------------------------------------------------------------->");
		System.out.println("<----------------------- JETM REENVIO TEST ----------------------->");
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
		reenvio = new Reenvio(mensaje, mensajeReenviar);
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
		
		int tamaño = mensaje.obtenerTamaño() + mensajeReenviar.obtenerTamaño();

		assertEquals(tamaño, reenvio.obtenerTamaño());
	}

}

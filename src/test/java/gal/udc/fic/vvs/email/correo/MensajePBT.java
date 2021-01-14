package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.util.JetmUtil;

@RunWith(JUnitQuickcheck.class)
public class MensajePBT {

	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<---------------------------------------------------------------->");
		System.out.println("<----------------------- JETM MENSAJE PBT ----------------------->");
		System.out.println("<---------------------------------------------------------------->");
		// configure measurement framework
        JetmUtil.setup();
	}
	
	@AfterClass
	public static void cerrarJetm(){		
		// shutdown measurement framework
		JetmUtil.tearDown();
	}

	/**
	 * Test PBT para comporbar el funcionamiento de la funcion obtenerTamaño.
	 * <p>
	 * --> Nivel: Prueba de Integracion.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: generados aleatoriamente.
	 */
	@Property public void obtenerTamañoTest(@From(StringGenerator.class) String nombreArchivo, 
			@From(StringGenerator.class) String contenidoArchivo) {
		
		Texto texto = new Texto(nombreArchivo, contenidoArchivo);
		Mensaje mensaje= new Mensaje(texto);
		
		assertEquals(texto.obtenerTamaño(), mensaje.obtenerTamaño());
	}	
}

package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.util.JetmUtil;

@RunWith(JUnitQuickcheck.class)
public class ImagenPBT {
	
	private static final String NOMBRE_ARCHIVO = "ImageTest";
	
	Imagen imagen;

	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<--------------------------------------------------------------->");
		System.out.println("<----------------------- JETM IMAGEN PBT ----------------------->");
		System.out.println("<--------------------------------------------------------------->");
		// configure measurement framework
        JetmUtil.setup();
	}
	
	@AfterClass
	public static void cerrarJetm(){		
		// shutdown measurement framework
		JetmUtil.tearDown();
	}

	/**
	 * Test PBT para comporbar el funcionamiento de la funcion obtenerContenidoTest.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: generados aleatoriamente.
	 */
	@Property public void obtenerContenidoTest(@From(StringGenerator.class) String contenido) {
		imagen = new Imagen(NOMBRE_ARCHIVO, contenido);
		
		assertEquals(contenido, imagen.obtenerContenido());
	}

}

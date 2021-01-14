package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.util.JetmUtil;


@RunWith(JUnitQuickcheck.class)
public class ArchivadorSimplePBT {
	
	private static final int ESPACIO_ARCHIVADOR = 9;
	
	private ArchivadorSimple archivadorSimple;
	
	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<-------------------------------------------------------------------------->");
		System.out.println("<----------------------- JETM ARCHIVADOR SIMPLE PBT ----------------------->");
		System.out.println("<-------------------------------------------------------------------------->");
		// configure measurement framework
        JetmUtil.setup();
	}
	
	@AfterClass
	public static void cerrarJetm(){		
		// shutdown measurement framework
		JetmUtil.tearDown();
	}
	
	/**
	 * Test PBT para comporbar el funcionamiento de la funcion obtenerNombreTest.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: generados aleatoriamente.
	 */
	@Property public void obtenerNombreTest(@From(StringGenerator.class) String nombre) {

		archivadorSimple = new ArchivadorSimple(nombre, ESPACIO_ARCHIVADOR);
		
		assertEquals(nombre, archivadorSimple.obtenerNombre());
    } 

}

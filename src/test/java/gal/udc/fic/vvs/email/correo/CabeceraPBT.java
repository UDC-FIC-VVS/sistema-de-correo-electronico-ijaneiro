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
public class CabeceraPBT {
	
	private Mensaje mensaje = new Mensaje(new Texto("1","1"));
	private Cabecera cabecera;

	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<----------------------------------------------------------------->");
		System.out.println("<----------------------- JETM CABECERA PBT ----------------------->");
		System.out.println("<----------------------------------------------------------------->");
		// configure measurement framework
        JetmUtil.setup();
	}
	
	@AfterClass
	public static void cerrarJetm(){		
		// shutdown measurement framework
		JetmUtil.tearDown();
	}

	/**
	 * Test PBT para comporbar el funcionamiento de la funcion obtenerVisualizacion.
	 * <p>
	 * --> Nivel: Prueba de Integracion.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: generados aleatoriamente.
	 */
	@Property public void obtenerVisualizacionTest(@From(StringGenerator.class) String nombre, @From(StringGenerator.class) String valor) {
		cabecera = new Cabecera(mensaje, nombre, valor);
		
		String visualizacion = nombre  + ": " + valor + "\n" + 
				mensaje.obtenerVisualizacion();
		
		assertEquals(visualizacion, cabecera.obtenerVisualizacion());
	}

}

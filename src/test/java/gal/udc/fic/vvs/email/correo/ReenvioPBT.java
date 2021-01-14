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
public class ReenvioPBT {

	private Mensaje mensaje = new Mensaje(new Texto("1","1"));
	private Reenvio reenvio;
	

	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<---------------------------------------------------------------->");
		System.out.println("<----------------------- JETM REENVIO PBT ----------------------->");
		System.out.println("<---------------------------------------------------------------->");
		// configure measurement framework
        JetmUtil.setup();
	}
	
	@AfterClass
	public static void cerrarJetm(){		
		// shutdown measurement framework
		JetmUtil.tearDown();
	}
	
	@Property public void obtenerVisualizacionTest(@From(StringGenerator.class) String nombre, @From(StringGenerator.class) String valor,
			@From(StringGenerator.class) String nombreArchivo, @From(StringGenerator.class) String contenidoArchivo) {
		
		Mensaje mensajeReenviar= new Mensaje(new Texto(nombreArchivo, contenidoArchivo));
		reenvio = new Reenvio(mensaje, mensajeReenviar);
		
		String visualizacion = mensaje.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n" + 
				mensajeReenviar.obtenerVisualizacion() + "\n---- Fin correo reenviado ----";
		
		assertEquals(visualizacion, reenvio.obtenerVisualizacion());
	}

}

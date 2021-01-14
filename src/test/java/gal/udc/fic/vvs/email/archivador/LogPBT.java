package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.java.lang.IntegerGenerator;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.util.JetmUtil;

@RunWith(JUnitQuickcheck.class)
public class LogPBT {
	
	private static final String NOMBRE_ARCHIVADOR = "nombreArchivador";
	private static final int ESPACIO_ARCHIVADOR = 9;
	
	private Mensaje mensaje = new Mensaje(new Texto("1","1"));
	private  Archivador archivadorDecorado;
	private  Archivador archivadorDelegado;
	private Log log;
	
	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<------------------------------------------------------------>");
		System.out.println("<----------------------- JETM LOG PBT ----------------------->");
		System.out.println("<------------------------------------------------------------>");
		// configure measurement framework
        JetmUtil.setup();
	}
	
	@AfterClass
	public static void cerrarJetm(){		
		// shutdown measurement framework
		JetmUtil.tearDown();
	}

	@Property public void almacenarCorreoTest_EspacioSuficiente(@From(IntegerGenerator.class) @InRange(min = "1") int espacioArchivador) {
		
		archivadorDecorado = new ArchivadorSimple(NOMBRE_ARCHIVADOR, espacioArchivador);
		log = new Log(archivadorDecorado);
		
		log.establecerDelegado(archivadorDelegado);
		
		assertTrue(log.almacenarCorreo(mensaje));
	}

}

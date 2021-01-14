package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.IntegerGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.util.JetmUtil;

@RunWith(JUnitQuickcheck.class)
public class DelegadoPBT {
	
	private static final String NOMBRE_ARCHIVADOR = "nombreArchivador";
	
	private Delegado delegado;
	private Archivador archivadorSimple;
	
	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<----------------------------------------------------------------->");
		System.out.println("<----------------------- JETM DELEGADO PBT ----------------------->");
		System.out.println("<----------------------------------------------------------------->");
		// configure measurement framework
        JetmUtil.setup();
	}
	
	@AfterClass
	public static void cerrarJetm(){		
		// shutdown measurement framework
		JetmUtil.tearDown();
	}
	
	@Property public void obtenerEspacioTotalTest(@From(IntegerGenerator.class) int espacio) {
		
		archivadorSimple = new ArchivadorSimple(NOMBRE_ARCHIVADOR, espacio);
		
		delegado = new Delegado(archivadorSimple);
		
		assertEquals(espacio, delegado.obtenerEspacioTotal());
	}

}

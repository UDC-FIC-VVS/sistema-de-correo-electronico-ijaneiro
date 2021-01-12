package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.IntegerGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class DelegadoPBT {
	
	private static final String NOMBRE_ARCHIVADOR = "nombreArchivador";
	
	private Delegado delegado;
	private Archivador archivadorSimple;
	
	@Property public void obtenerEspacioTotalTest(@From(IntegerGenerator.class) int espacio) {
		
		archivadorSimple = new ArchivadorSimple(NOMBRE_ARCHIVADOR, espacio);
		
		delegado = new Delegado(archivadorSimple);
		
		assertEquals(espacio, delegado.obtenerEspacioTotal());
	}

}

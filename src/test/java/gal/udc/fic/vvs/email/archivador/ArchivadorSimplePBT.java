package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;


@RunWith(JUnitQuickcheck.class)
public class ArchivadorSimplePBT {
	
	private static final int ESPACIO_ARCHIVADOR = 9;
	
	private ArchivadorSimple archivadorSimple;

	@Property public void obtenerNombreTest(@From(StringGenerator.class) String nombre) {

		archivadorSimple = new ArchivadorSimple(nombre, ESPACIO_ARCHIVADOR);
		
		assertEquals(nombre, archivadorSimple.obtenerNombre());
    } 

}

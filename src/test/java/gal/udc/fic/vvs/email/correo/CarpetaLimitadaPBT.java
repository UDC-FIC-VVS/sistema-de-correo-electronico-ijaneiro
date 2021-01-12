package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class CarpetaLimitadaPBT {
	
	private static final int TAMAÑO_CARPETA = 10;

	@Property public void obtenerPreVisualizacionTest(@From(StringGenerator.class) String nombre) {

		Carpeta carpeta = new Carpeta(nombre);
		
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, TAMAÑO_CARPETA);
		
		assertEquals(nombre, carpetaLimitada.obtenerPreVisualizacion());
	}

}

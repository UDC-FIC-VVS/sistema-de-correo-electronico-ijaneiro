package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class ImagenPBT {
	
	private static final String NOMBRE_ARCHIVO = "ImageTest";
	
	Audio audio;

	@Property public void obtenerContenidoTest(@From(StringGenerator.class) String contenido) {
		audio = new Audio(NOMBRE_ARCHIVO, contenido);
		
		assertEquals(contenido, audio.obtenerContenido());
	}

}
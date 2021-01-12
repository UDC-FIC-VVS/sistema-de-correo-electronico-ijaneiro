package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class AudioPBT {
	
	private static final String CONTENIDO_ARCHIVO = "AudioTestContenido";
	
	Audio audio;

	@Property public void obtenerNombreTest(@From(StringGenerator.class) String nombre) {
		audio = new Audio(nombre, CONTENIDO_ARCHIVO);
		
		assertEquals(nombre, audio.obtenerNombre());
	}

}

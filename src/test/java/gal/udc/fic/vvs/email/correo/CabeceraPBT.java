package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;

@RunWith(JUnitQuickcheck.class)
public class CabeceraPBT {
	
	private Mensaje mensaje = new Mensaje(new Texto("1","1"));
	private Cabecera cabecera;
	
	@Property public void obtenerVisualizacionTest(@From(StringGenerator.class) String nombre, @From(StringGenerator.class) String valor) {
		cabecera = new Cabecera(mensaje, nombre, valor);
		
		String visualizacion = nombre  + ": " + valor + "\n" + 
				mensaje.obtenerVisualizacion();
		
		assertEquals(visualizacion, cabecera.obtenerVisualizacion());
	}

}

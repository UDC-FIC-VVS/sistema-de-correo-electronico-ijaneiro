package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class ReenvioTest {
	
	private Mensaje mensaje = new Mensaje(new Texto("Correo1", "Correo de prueba"));
	private Mensaje mensajeReenviar = new Mensaje(new Texto("Correo2", "Correo a reenviar"));
	
	private DecoradorMensaje reenvio;

	@Before
	public void init() {
		reenvio = new Reenvio(mensaje, mensajeReenviar);
	}
	
	@Test
	public void obtenerTamañoTest() {
		
		int tamaño = mensaje.obtenerTamaño() + mensajeReenviar.obtenerTamaño();

		assertEquals(tamaño, reenvio.obtenerTamaño());
	}
	
	@Test
	public void obtenerVisualizacionTest() {
		
		String visualizacion = mensaje.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n" + 
							mensajeReenviar.obtenerVisualizacion() + "\n---- Fin correo reenviado ----";
		
		assertEquals(visualizacion, reenvio.obtenerVisualizacion());
	}

}

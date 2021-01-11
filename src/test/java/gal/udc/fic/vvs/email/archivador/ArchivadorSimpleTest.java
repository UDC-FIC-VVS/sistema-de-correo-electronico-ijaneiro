package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class ArchivadorSimpleTest {
	
	private static final String NOMBRE_ARCHIVADOR = "nombreArchivador";
	private static final int ESPACIO_ARCHIVADOR = 9;
	
	private ArchivadorSimple archivadorSimple;
	private static final Mensaje CORREO_TAMAÑO_1 = new Mensaje(new Texto("Prueba", "P"));
	private static final Mensaje CORREO_TAMAÑO_10 = new Mensaje(new Texto("Prueba", "0123456789"));
	
	@Before
	public void init() {
		archivadorSimple = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR);
	}

	@Test
	public void obtenerNombreTest() {
		
		String nombreObtenido = archivadorSimple.obtenerNombre();
		
		assertEquals(NOMBRE_ARCHIVADOR, nombreObtenido);
	}
	
	@Test
	public void almacenarCorreoTest_EspacioSuficiente() {
		
		boolean salida = archivadorSimple.almacenarCorreo(CORREO_TAMAÑO_1);
		
		assertTrue(salida);
	}
	
	@Test
	public void almacenarCorreoTest_EspacioInsuficiente() {
		
		boolean salida = archivadorSimple.almacenarCorreo(CORREO_TAMAÑO_10);
		
		assertFalse(salida);
	}
	
	@Test
	public void obtenerEspacioTotalTest() {
		
		int espacioTotalObtenido = archivadorSimple.obtenerEspacioTotal();
		
		assertEquals(ESPACIO_ARCHIVADOR, espacioTotalObtenido);
	}
	
	@Test
	public void obtenerEspacioDisponibleTest() {
		
		archivadorSimple.almacenarCorreo(CORREO_TAMAÑO_1);
		
		int espacioDisponibleObtenido = archivadorSimple.obtenerEspacioDisponible();
		
		assertEquals(ESPACIO_ARCHIVADOR - CORREO_TAMAÑO_1.obtenerTamaño(), espacioDisponibleObtenido);
	}
	
	@Test
	public void obtenerDelegadoTest() {
		
		Archivador delegado = archivadorSimple.obtenerDelegado();
		
		assertNull(delegado);
	}
	
	@Test
	public void establecerDelegadoTest() {
		
		Archivador delegado = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR);
		
		archivadorSimple.establecerDelegado(delegado);
		
		assertTrue(true);
	}

}

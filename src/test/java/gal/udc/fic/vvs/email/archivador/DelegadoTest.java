package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class DelegadoTest {
	
	private Delegado delegado;
	
	private static final String NOMBRE_ARCHIVADOR = "nombreArchivador";
	private static final String OTRO_NOMBRE_ARCHIVADOR = "otroNombreArchivador";
	private static final int ESPACIO_ARCHIVADOR_DECORADO = 5;
	private static final int ESPACIO_ARCHIVADOR_DELEGADO = 9;
	
	private  Archivador archivadorDecorado;
	private  Archivador archivadorDelegado;
	private  Archivador otroArchivadorDelegado;
	
	private static final Mensaje CORREO_TAMAÑO_1 = new Mensaje(new Texto("Prueba", "P"));
	private static final Mensaje CORREO_TAMAÑO_5 = new Mensaje(new Texto("Prueba", "01234"));
	private static final Mensaje CORREO_TAMAÑO_10 = new Mensaje(new Texto("Prueba", "0123456789"));
	
	@Before
	public void init() {
		
		archivadorDecorado = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_DECORADO);
		archivadorDelegado = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_DELEGADO);
		otroArchivadorDelegado = new ArchivadorSimple(OTRO_NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_DELEGADO);	
		
		delegado = new Delegado(archivadorDecorado);
		delegado.establecerDelegado(archivadorDelegado);
	}
	
	@Test
	public void almacenarCorreoTest_EspacioSuficienteDecorado() {
		
		boolean salida = delegado.almacenarCorreo(CORREO_TAMAÑO_1);
		
		assertTrue(salida);
	}
	
	@Test
	public void almacenarCorreoTest_EspacioInsuficienteDecorado() {
		
		boolean salida = delegado.almacenarCorreo(CORREO_TAMAÑO_5);
		
		assertTrue(salida);
	}
	
	@Test
	public void almacenarCorreoTest_EspacioInsuficienteDecoradoDelegado() {
		
		boolean salida = delegado.almacenarCorreo(CORREO_TAMAÑO_10);
		
		assertFalse(salida);
	}
	
	@Test
	public void establecerDelegadoTest() {
		
		delegado.establecerDelegado(otroArchivadorDelegado);
		
		assertEquals(OTRO_NOMBRE_ARCHIVADOR, delegado.obtenerDelegado().obtenerNombre());
	}
	
	@Test
	public void obtenerDelegadoTest() {
		
		Archivador delegado = this.delegado.obtenerDelegado();
		
		assertEquals(NOMBRE_ARCHIVADOR, delegado.obtenerNombre());
	}
	
	@Test
	public void obtenerNombreTest() {
		
		assertEquals(NOMBRE_ARCHIVADOR, delegado.obtenerNombre());
	}

	@Test
	public void obtenerEspacioDisponibleTest() {
		
		delegado.almacenarCorreo(CORREO_TAMAÑO_1);
		
		assertEquals(ESPACIO_ARCHIVADOR_DECORADO - CORREO_TAMAÑO_1.obtenerTamaño(), delegado.obtenerEspacioDisponible());
	}


}

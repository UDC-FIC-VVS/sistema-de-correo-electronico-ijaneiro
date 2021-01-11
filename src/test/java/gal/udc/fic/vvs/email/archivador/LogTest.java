package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class LogTest {
	
	private Log log; 
	
	private static final String NOMBRE_ARCHIVADOR = "nombreArchivador";
	private static final String OTRO_NOMBRE_ARCHIVADOR = "otroNombreArchivador";
	private static final int ESPACIO_ARCHIVADOR_DECORADO = 5;
	
	private  Archivador archivadorDecorado = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_DECORADO);
	private  Archivador otroArchivadorDecorado = new ArchivadorSimple(OTRO_NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_DECORADO);
	private  Archivador archivadorDelegado; 
	
	private static final Mensaje CORREO_TAMAÑO_1 = new Mensaje(new Texto("Prueba", "P"));
	private static final Mensaje CORREO_TAMAÑO_6 = new Mensaje(new Texto("Prueba", "012345"));
	
	@Before
	public void init() {
		archivadorDelegado = new Delegado(archivadorDecorado); 
		archivadorDelegado.establecerDelegado(archivadorDecorado);
		
		log = new Log(archivadorDelegado);
	}
	
	@Test
	public void almacenarCorreoTest_EspacioSuficiente() {
		
		boolean salida = log.almacenarCorreo(CORREO_TAMAÑO_1);
		
		assertTrue(salida);
	}
	
	@Test
	public void almacenarCorreoTest_EspacioInsuficiente() {
		
		boolean salida = log.almacenarCorreo(CORREO_TAMAÑO_6);
		
		assertFalse(salida);
	}
	
	@Test
	public void obtenerDelegadoTest() {
		
		Archivador decorado = log.obtenerDelegado();
		
		assertEquals(archivadorDecorado, decorado);
	}
	
	@Test
	public void establecerDelegadoTest() {
		
		log.establecerDelegado(otroArchivadorDecorado);
		
		assertEquals(otroArchivadorDecorado.obtenerNombre(), log.obtenerDelegado().obtenerNombre());
	}
	
	
	
}

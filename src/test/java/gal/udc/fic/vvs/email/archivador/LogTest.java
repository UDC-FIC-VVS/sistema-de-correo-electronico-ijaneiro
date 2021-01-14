package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.util.JetmUtil;

public class LogTest {
	
	private Log log; 
	
	private static final String NOMBRE_ARCHIVADOR = "nombreArchivador";
	private static final String OTRO_NOMBRE_ARCHIVADOR = "otroNombreArchivador";
	private static final int ESPACIO_ARCHIVADOR_DECORADO = 5;
	
	private  Archivador archivadorDecorado = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_DECORADO);
	private  Archivador otroArchivadorDecorado = new ArchivadorSimple(OTRO_NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_DECORADO);
	private  Archivador archivadorDelegado; 
	
	private static final Mensaje CORREO_TAMAÑO_6 = new Mensaje(new Texto("Prueba", "012345"));
	
	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<------------------------------------------------------------->");
		System.out.println("<----------------------- JETM LOG TEST ----------------------->");
		System.out.println("<------------------------------------------------------------->");
		// configure measurement framework
        JetmUtil.setup();
	}
	
	@AfterClass
	public static void cerrarJetm(){		
		// shutdown measurement framework
		JetmUtil.tearDown();
	}
	
	@Before
	public void init() {
		archivadorDelegado = new Delegado(archivadorDecorado); 
		archivadorDelegado.establecerDelegado(archivadorDecorado);
		
		log = new Log(archivadorDelegado);
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion almacenarCorreoTest.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void almacenarCorreoTest_EspacioInsuficiente() {
		
		boolean salida = log.almacenarCorreo(CORREO_TAMAÑO_6);
		
		assertFalse(salida);
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerDelegado.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerDelegadoTest() {
		
		Archivador decorado = log.obtenerDelegado();
		
		assertEquals(archivadorDecorado, decorado);
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion establecerDelegado.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void establecerDelegadoTest() {
		
		log.establecerDelegado(otroArchivadorDecorado);
		
		assertEquals(otroArchivadorDecorado.obtenerNombre(), log.obtenerDelegado().obtenerNombre());
	}
	
	
	
}

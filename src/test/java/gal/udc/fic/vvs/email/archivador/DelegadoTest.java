package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.util.JetmUtil;

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
	
	@BeforeClass
	public static void lanzarJetm() {
		System.out.println("<------------------------------------------------------------------>");
		System.out.println("<----------------------- JETM DELEGADO TEST ----------------------->");
		System.out.println("<------------------------------------------------------------------>");
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
		
		archivadorDecorado = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_DECORADO);
		archivadorDelegado = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_DELEGADO);
		otroArchivadorDelegado = new ArchivadorSimple(OTRO_NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_DELEGADO);	
		
		delegado = new Delegado(archivadorDecorado);
		delegado.establecerDelegado(archivadorDelegado);
	}
	
	/**
	 * Test para comporbar el funcionamiento de la funcion almacenarCorreo.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void almacenarCorreoTest_EspacioSuficienteDecorado() {
		
		boolean salida = delegado.almacenarCorreo(CORREO_TAMAÑO_1);
		
		assertTrue(salida);
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion almacenarCorreo.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void almacenarCorreoTest_EspacioInsuficienteDecorado() {
		
		boolean salida = delegado.almacenarCorreo(CORREO_TAMAÑO_5);
		
		assertTrue(salida);
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion almacenarCorreo.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void almacenarCorreoTest_EspacioInsuficienteDecoradoDelegado() {
		
		boolean salida = delegado.almacenarCorreo(CORREO_TAMAÑO_10);
		
		assertFalse(salida);
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
		
		delegado.establecerDelegado(otroArchivadorDelegado);
		
		assertEquals(OTRO_NOMBRE_ARCHIVADOR, delegado.obtenerDelegado().obtenerNombre());
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
		
		Archivador delegado = this.delegado.obtenerDelegado();
		
		assertEquals(NOMBRE_ARCHIVADOR, delegado.obtenerNombre());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerNombre.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerNombreTest() {
		
		assertEquals(NOMBRE_ARCHIVADOR, delegado.obtenerNombre());
	}

	/**
	 * Test para comporbar el funcionamiento de la funcion obtenerEspacio.
	 * <p>
	 * --> Nivel: Prueba de Unidad.
	 * <p>
	 * --> Categoría: prueba funcional dinámica de caja negra positiva.
	 * <p>
	 * --> Selección de datos: datos estaticos, pensados de antemano y especificos para la prueba.
	 */
	@Test
	public void obtenerEspacioDisponibleTest() {
		
		delegado.almacenarCorreo(CORREO_TAMAÑO_1);
		
		assertEquals(ESPACIO_ARCHIVADOR_DECORADO - CORREO_TAMAÑO_1.obtenerTamaño(), delegado.obtenerEspacioDisponible());
	}


}

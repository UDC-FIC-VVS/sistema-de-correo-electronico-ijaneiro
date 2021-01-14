package gal.udc.fic.vvs.email;

import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.renderer.SimpleTextRenderer;
import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.cliente.Cliente;
import gal.udc.fic.vvs.email.cliente.ClienteImp;
import gal.udc.fic.vvs.email.correo.Cabecera;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.CarpetaLimitada;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.Reenvio;

/**
 * Hello world!
 *
 */
public class App 
{
	private static EtmMonitor monitor;
	
    public static void main( String[] args )
    {
    	// configure measurement framework
        setup();
        
        System.out.println( "Hello World!" );

        try
        {
            Carpeta global = new Carpeta("O meu correo");
            Carpeta personal = new Carpeta("Persoal");
            Carpeta personalAmigos = new Carpeta("Amizades");
            Carpeta personalFamilia = new Carpeta("Familia");
            Carpeta trabajo = new Carpeta("Traballo");
            Carpeta trabajoVVS = new Carpeta("VVS");
            Carpeta trabajoDepartamento = new Carpeta("Departamento");
            Carpeta trabajoGeneral = new Carpeta("Xeral");
            Carpeta listas = new Carpeta("Listas");
            Carpeta listasPF = new Carpeta("Programación Funcional");
            Carpeta listasVA = new Carpeta("Validación Automática");

            global.añadir(listas);
            global.añadir(trabajo);
            global.añadir(new CarpetaLimitada(personal, 3));

            listas.añadir(listasPF);
            listas.añadir(listasVA);

            trabajo.añadir(trabajoVVS);
            trabajo.añadir(trabajoDepartamento);
            trabajo.añadir(trabajoGeneral);

            personal.añadir(personalAmigos);
            personal.añadir(personalFamilia);
            personal.añadir(new Mensaje(new Texto("contido", "Contido do correo electrónico.")));

            personalFamilia.añadir(new Reenvio(new Cabecera(new Cabecera(new Mensaje(new Texto("contido", "Contido do correo electrónico persoal 1.")), "Para", "lcastro@udc.es"), "De", "vvs@fic.udc.es"), new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 1."))));
            personalFamilia.añadir(new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 1.")));
            personalFamilia.añadir(new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 2.")));
            personalFamilia.añadir(new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 3.")));
            personalFamilia.añadir(new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 4.")));

            Cliente cliente = new ClienteImp(global);

            ArchivadorSimple gmail = new ArchivadorSimple("GMail", 100);
            ArchivadorSimple outlook = new ArchivadorSimple("Outlook", 100);
            cliente.agregarArchivador(outlook);
            cliente.agregarArchivador(gmail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		// visualize results
		monitor.render(new SimpleTextRenderer());
		
		// shutdown measurement framework
		tearDown();
    }
    
    private static void setup() {
        BasicEtmConfigurator.configure();
        monitor = EtmManager.getEtmMonitor();
        monitor.start();
    }
    
    private static void tearDown() {
    	monitor.stop();
    }
}

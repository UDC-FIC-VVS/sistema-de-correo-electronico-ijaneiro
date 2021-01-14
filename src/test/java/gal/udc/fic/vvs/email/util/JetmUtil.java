package gal.udc.fic.vvs.email.util;

import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.renderer.SimpleTextRenderer;

public class JetmUtil {
	
	private static EtmMonitor monitor;
	
    public static void setup() {
        BasicEtmConfigurator.configure();
        monitor = EtmManager.getEtmMonitor();
        monitor.start();
    }
    
    public static void tearDown() {
    	// visualize results
    	monitor.render(new SimpleTextRenderer());
    			
    	monitor.stop();
    }

}

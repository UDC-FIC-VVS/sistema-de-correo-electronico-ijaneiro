package gal.udc.fic.vvs.email.archivador;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

import org.junit.runner.RunWith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "gal.udc.fic.vvs.email.archivador")
public class ArchUnitArchivadorMetodosTest {
	
	@ArchTest
    public static ArchRule los_metodos_son_o_public_o_protected = 
    	methods().should().bePublic().orShould().beProtected();
	
	@ArchTest
    public static ArchRule los_metodos_no_deberian_ser_final_ni_private = 
    	methods().should().notBeFinal().andShould().notBePrivate();

	@ArchTest
    public static ArchRule los_metodos_con_nombre_o_contenido_devuelven_una_cadena_de_texto = 
    	methods().that().haveNameMatching(".*Nombre")
    		.and().haveNameMatching(".*Contenido")
    		.should().haveRawReturnType(String.class);
	
	@ArchTest
    public static ArchRule los_metodos_con_tamaño_devuelven_un_numero = 
    	methods().that().haveNameMatching(".*Tamaño")
    		.should().haveRawReturnType("int");

}

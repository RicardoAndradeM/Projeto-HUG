package componentes;

import easyaccept.EasyAccept;

/**
 * Classe que inicia o sistema
 * @since 18/09/16
 */
public class Main {
	
	 public static void main(String[] args) {
	        args = new String[] { 
	        		"componentes.Facade", "testacept/testes_uc1.txt/",
	                "testacept/testes_uc1_exception.txt/", 
	                "testacept/testes_uc2.txt/",
	                "testacept/testes_uc2_exception.txt/", 
	                "testacept/testes_uc3.txt/",
	                "testacept/testes_uc3_exception.txt/", 
	                "testacept/testes_uc4.txt/",
	                "testacept/testes_uc4_exception.txt/",
	                "testacept/testes_uc5.txt/"
	                };
	        EasyAccept.main(args);
	    }

}
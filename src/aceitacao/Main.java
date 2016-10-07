package aceitacao;

import easyaccept.EasyAccept;

public class Main {

	public static void main(String[] args) {
	    args = new String[] {"aceitacao.Facade",
	    					"testacept/testes_uc1.txt",
	    					"testacept/testes_uc1_exception.txt"};
	    EasyAccept.main(args);
	}
}

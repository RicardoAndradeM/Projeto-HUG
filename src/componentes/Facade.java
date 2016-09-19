package componentes;

import componentes.Hospede;
import easyaccept.EasyAccept;
import execeptions.EmailInvalidoException;
import execeptions.HospedeNaoEncontradoException;
import execeptions.NomeDeAtributoInvalidoException;
import execeptions.NomeInvalidoException;
import execeptions.dataNascimentoInvalidaException;
import componentes.ControlerRecepcao;

public class Facade {
	private ControlerRecepcao controller;
	
	public Facade(){
		controller = new ControlerRecepcao();
	}
	
	public String cadastraHospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException, dataNascimentoInvalidaException{
		return controller.cadastraHospede(nome, email, dataNascimento);
	}
	
	public String getInfoHospede(String email, String atributo) throws NomeDeAtributoInvalidoException, HospedeNaoEncontradoException{
		return controller.getInfoHospede(email, atributo);
	}

	public void atualizaCadastro(String id, String atributo, String valor) throws EmailInvalidoException, NomeInvalidoException, dataNascimentoInvalidaException, NomeDeAtributoInvalidoException, HospedeNaoEncontradoException{
		controller.atualizaCadastro(id, atributo, valor);
	}

	public boolean removeHospede(String email) throws HospedeNaoEncontradoException{
		return controller.removeHospede(email);
	}

	public Hospede buscaHospede(String email) throws HospedeNaoEncontradoException{
		return controller.buscaHospede(email);
	}
	
	 public static void main(String[] args) {
	        args = new String[] { 
	        		"componentes.Facade", "testacept/testes_uc1.txt/",
	                "testacept/testes_uc1_exception.txt/", 
	                "testacept/testes_uc2.txt/",
	                "testacept/testes_uc2_exception.txt/", 
	                "testacept/testes_uc3.txt/",
	                "testacept/testes_uc3_exception.txt/", 
	                "testacept/testes_uc4.txt/",
	                "testacept/testes_uc4_exception.txt/" 
	                };
	        EasyAccept.main(args);
	    }
	
}
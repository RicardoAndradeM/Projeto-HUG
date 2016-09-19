package componentes;

import componentes.Hospede;
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
	
}
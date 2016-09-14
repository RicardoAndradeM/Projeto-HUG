package componentes;

import componentes.Hospede;
import execeptions.EmailInvalidoException;
import execeptions.NomeInvalidoException;
import componentes.Controler;

public class Facade {
	private Controler controller;
	
	public Facade(){
		controller = new Controler();
	}
	
	public String cadastraHospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException{
		return controller.cadastraHospede(nome, email, dataNascimento);
	}
	
	public String getInfoHospede(String email, String atributo){
		return controller.getInfoHospede(email, atributo);
	}

	public void atualizaCadastro(String id, String atributo, String valor) throws EmailInvalidoException, NomeInvalidoException{
		controller.atualizaCadastro(id, atributo, valor);
	}

	public boolean removeHospede(String email){
		return controller.removeHospede(email);
	}

	public Hospede buscaHospede(String email){
		return controller.buscaHospede(email);
	}
	
}
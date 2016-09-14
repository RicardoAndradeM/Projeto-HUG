package componentes;

import execeptions.EmailInvalidoException;
import execeptions.NomeInvalidoException;

public class FactoryDeHospedes {
	public Hospede criaHospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException{	
		return new Hospede(nome, email, dataNascimento);
	}
	
}

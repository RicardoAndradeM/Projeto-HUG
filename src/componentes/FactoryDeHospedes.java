package componentes;

import execeptions.EmailInvalidoException;
import execeptions.NomeInvalidoException;
import execeptions.dataNascimentoInvalidaException;

public class FactoryDeHospedes {
	public Hospede criaHospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException, dataNascimentoInvalidaException{	
		return new Hospede(nome, email, dataNascimento);
	}
	
}

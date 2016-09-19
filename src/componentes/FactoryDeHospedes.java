package componentes;

import exceptions.DataNascimentoInvalidaException;
import exceptions.EmailInvalidoException;
import exceptions.NomeInvalidoException;

public class FactoryDeHospedes {
	public Hospede criaHospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException, DataNascimentoInvalidaException{	
		return new Hospede(nome, email, dataNascimento);
	}
	
}

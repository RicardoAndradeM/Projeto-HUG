package factorys;

import exceptions.DataNascimentoInvalidaException;
import exceptions.EmailInvalidoException;
import exceptions.NomeInvalidoException;
import recepcao.Hospede;

public class FactoryDeHospedes {
	public Hospede criaHospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException, DataNascimentoInvalidaException{	
		return new Hospede(nome, email, dataNascimento);
	}
	
}

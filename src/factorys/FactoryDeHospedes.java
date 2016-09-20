package factorys;

import exceptions.valordeatributoinvalido.DataNascimentoInvalidaException;
import exceptions.valordeatributoinvalido.EmailInvalidoException;
import exceptions.valordeatributoinvalido.NomeInvalidoException;
import recepcao.Hospede;

public class FactoryDeHospedes {
	public Hospede criaHospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException, DataNascimentoInvalidaException{	
		try {
			return new Hospede(nome, email, dataNascimento);			
		} catch (NomeInvalidoException e) {
			throw new NomeInvalidoException("Erro no cadastro de Hospede. " + e.getMessage());
		} catch (EmailInvalidoException e) {
			throw new NomeInvalidoException("Erro no cadastro de Hospede. " + e.getMessage());
		} catch (DataNascimentoInvalidaException e) {
			throw new NomeInvalidoException("Erro no cadastro de Hospede. " + e.getMessage());
		}
	}
	
}

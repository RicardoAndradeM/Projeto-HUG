package recepcao.factories;

import cadastro.exception.DataNascimentoInvalidaException;
import cadastro.exception.EmailInvalidoException;
import cadastro.exception.NomeInvalidoException;
import recepcao.hospede.Hospede;

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

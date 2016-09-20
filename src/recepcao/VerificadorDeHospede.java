package recepcao;

import exceptions.valordeatributoinvalido.DataNascimentoInvalidaException;
import exceptions.valordeatributoinvalido.EmailInvalidoException;
import exceptions.valordeatributoinvalido.NomeInvalidoException;

public class VerificadorDeHospede {
	
	public void verificaNome(String nome) throws NomeInvalidoException{
		if(nome == null || nome.trim().equals("")){
			throw new NomeInvalidoException("Erro no cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.");
		}
		//verifica se nome de hospede tem @
		for (int letra = 0; letra < nome.length(); letra++) {
			if(nome.charAt(letra) == '@'){
				throw new NomeInvalidoException("Erro no cadastro de Hospede. Nome do(a) hospede esta invalido.");
			}
		}
	}
	
	public void verificaEmail(String email) throws EmailInvalidoException{
		if(email.trim().equals("") || email == null){
			throw new EmailInvalidoException("Erro no cadastro de Hospede. Email do(a) hospede nao pode ser vazio.");
		}
		String[] parteDoEmail = email.split("@");
		if(parteDoEmail.length != 2){
			throw new EmailInvalidoException("Erro no cadastro de Hospede. Email do(a) hospede esta invalido.");
		}
		String[] partesDoDominioEmail = parteDoEmail[1].split(".");
		if(partesDoDominioEmail.length == 1){
			throw new EmailInvalidoException("Erro no cadastro de Hospede. Email do(a) hospede esta invalido.");
		}
	}
	
	public void verificaDataNascimento(String dataNascimento) throws DataNascimentoInvalidaException{
		if(dataNascimento.trim().equals("") || dataNascimento == null){
			throw new DataNascimentoInvalidaException("Erro no cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.");		
		}
		String[] componetesDeData = dataNascimento.split("/");
		if(componetesDeData.length != 3 || componetesDeData[0].length() != 2 || componetesDeData[1].length() != 2 || componetesDeData[2].length() != 4){
			throw new DataNascimentoInvalidaException("Erro no cadastro de Hospede. Formato de data invalido.");
		}
	}
	
}

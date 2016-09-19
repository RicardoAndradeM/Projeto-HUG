package componentes;

import exceptions.DataNascimentoInvalidaException;
import exceptions.EmailInvalidoException;
import exceptions.NomeInvalidoException;

public class VerificadorDeHospede {
	
	public void verificaNome(String nome) throws NomeInvalidoException{
		if(nome == null || nome.equals("")){
			throw new NomeInvalidoException("Erro no cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.");
		}
		
		// verificando se o nome é apenas um string de espacos
		for (int letra = 0; letra < nome.length(); letra++) {
			if(nome.charAt(letra) != ' '){
				return;				
			}
		}
		throw new NomeInvalidoException("Erro no cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.");
	}
	
	public void verificaEmail(String email) throws EmailInvalidoException{
		if(email == null || email.equals("")){
			throw new EmailInvalidoException("Erro no cadastro de Hospede. Email do(a) hospede nao pode ser vazio.");
		}
		
		// verificando se o email tem um usuario(antes do @) e um dominio(depois do @)
		if(email.charAt(0) == '@' || email.charAt(0) == '.' || email.charAt(email.length()-1) == '@' || email.charAt(email.length()-1) == '.'){
			throw new EmailInvalidoException("Erro no cadastro de Hospede. Email do(a) hospede esta invalido.");
		}
		boolean hasArroba = false;
		boolean hasPonto = false;
		for (int letra = 0; letra < email.length(); letra++) {
			if(!hasArroba){
				if(email.charAt(letra) == '@'){
					hasArroba = true;
				}
			} else {
				if(email.charAt(letra) == '@'){
					throw new EmailInvalidoException("Erro no cadastro de Hospede. Email do(a) hospede esta invalido.");
				} else if (email.charAt(letra) == '.') {
					hasPonto = true;
				}
			}
		}
		if(!hasPonto){
			throw new EmailInvalidoException("Formato de email invalido");
		}
	}
	
	public void verificaDataNascimento(String dataNascimento) throws DataNascimentoInvalidaException{
		if(dataNascimento == null || dataNascimento.equals("")){
			throw new DataNascimentoInvalidaException("dataNascimento nao pode ser vazio ou nulo");
		}
		String[] componetesDeData = dataNascimento.split("/");
		if(componetesDeData.length != 3 || componetesDeData[0].length() != 2 || componetesDeData[1].length() != 2 || componetesDeData[2].length() != 4){
			throw new DataNascimentoInvalidaException("Formato de dataNascimento invalido");
		}
	}
	
}

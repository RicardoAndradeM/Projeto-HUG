package recepcao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.valordeatributoinvalido.DataNascimentoInvalidaException;
import exceptions.valordeatributoinvalido.EmailInvalidoException;
import exceptions.valordeatributoinvalido.NomeInvalidoException;

public class VerificadorDeHospede {
	private final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
	
	public void verificaNome(String nome) throws NomeInvalidoException{
		if(nome == null || nome.trim().equals("")){
			throw new NomeInvalidoException("Nome do(a) hospede nao pode ser vazio.");
		}
		//verifica se nome de hospede tem @
		for (int letra = 0; letra < nome.length(); letra++) {
			if(nome.charAt(letra) == '@'){
				throw new NomeInvalidoException("Nome do(a) hospede esta invalido.");
			}
		}
	}
	
	public void verificaEmail(String email) throws EmailInvalidoException{
		if(email.trim().equals("") || email == null){
			throw new EmailInvalidoException("Email do(a) hospede nao pode ser vazio.");
		}
		Matcher matcher = pattern.matcher(email);
	    if(!matcher.matches()){
	    	throw new EmailInvalidoException("Email do(a) hospede esta invalido.");	    	
	    }
	}
	
	public void verificaDataNascimento(String dataNascimento) throws DataNascimentoInvalidaException{
		if(dataNascimento.trim().equals("") || dataNascimento == null){
			throw new DataNascimentoInvalidaException("Data de Nascimento do(a) hospede nao pode ser vazio.");		
		}
		String[] componetesDeData = dataNascimento.split("/");
		if(componetesDeData.length != 3 || componetesDeData[0].length() != 2 || componetesDeData[1].length() != 2 || componetesDeData[2].length() != 4){
			throw new DataNascimentoInvalidaException("Formato de data invalido.");
		}
	}
	
}

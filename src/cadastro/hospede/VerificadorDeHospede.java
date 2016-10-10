package cadastro.hospede;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cadastro.exception.DataNascimentoInvalidaException;
import cadastro.exception.EmailInvalidoException;
import cadastro.exception.NomeInvalidoException;

/** Classe que verifica se valore relacionados a hospede sao validos
 * @since 15/09/16
 * @author Ricardo Andrade
 */
public class VerificadorDeHospede {
	
	private final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
	
	/** verifica se o nome do hospede eh valido
	 * @param nome nome a ser avaliado
	 * @throws NomeInvalidoException lanca exception caso nome seja invalido
	 */
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
	
	/** verifica se o email do hospede eh valido
	 * @param email email a se avaliado
	 * @throws EmailInvalidoException lanca exception caso email seja invalido
	 */
	public void verificaEmail(String email) throws EmailInvalidoException{
		if(email == null || email.trim().equals("")) {
			throw new EmailInvalidoException("Email do(a) hospede nao pode ser vazio.");
		}
		Matcher matcher = pattern.matcher(email);
	    if(!matcher.matches()){
	    	throw new EmailInvalidoException("Email do(a) hospede esta invalido.");	    	
	    }
	}
	
	/** verifica se a data de nascimento do hospede eh valida
	 * @param dataNascimento data a ser avalida
	 * @throws DataNascimentoInvalidaException lanca exception caso a data de nascimento seja invalido
	 */
	public void verificaDataNascimento(String dataNascimento) throws DataNascimentoInvalidaException{
		if(dataNascimento.trim().equals("") || dataNascimento == null){
			throw new DataNascimentoInvalidaException("Data de Nascimento do(a) hospede nao pode ser vazio.");		
		}
		String[] componetesDeData = dataNascimento.split("/");
		if(componetesDeData.length != 3 || componetesDeData[0].length() != 2 || componetesDeData[1].length() != 2 || componetesDeData[2].length() != 4){
			throw new DataNascimentoInvalidaException("Formato de data invalido.");
		}
		int dias;
		int meses;
		int anos;
		try {
			dias = Integer.parseInt(componetesDeData[0]);
			meses = Integer.parseInt(componetesDeData[1]);
			anos = Integer.parseInt(componetesDeData[2]);			
		} catch (NumberFormatException e) {
			throw new DataNascimentoInvalidaException("Formato de data invalido.");
		}
		LocalDate nascimentoHospede;
		try {
			nascimentoHospede = LocalDate.of(anos, meses, dias);			
		} catch (DateTimeException e) {
			throw new DataNascimentoInvalidaException("Formato de data invalido.");
		}
		LocalDate dataAtual = LocalDate.now();
		Period idade = Period.between(nascimentoHospede, dataAtual);
		if(idade.getYears() < 18){
			throw new DataNascimentoInvalidaException("A idade do(a) hospede deve ser maior que 18 anos.");
		}
	}
	
}

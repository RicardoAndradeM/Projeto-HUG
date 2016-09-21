package recepcao;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.valordeatributoinvalido.DataNascimentoInvalidaException;
import exceptions.valordeatributoinvalido.EmailInvalidoException;
import exceptions.valordeatributoinvalido.NomeInvalidoException;
import jdk.nashorn.internal.objects.NativeNumber;

/** Classe que verifica se valore relacionados a hospede sao validos
 * @since 15/09/16
 *
 */
public class VerificadorDeHospede {
	private final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
	
	/** verifica se nome eh valido
	 * @param nome nome a ser avaliado
	 * @throws NomeInvalidoException caso nome sejan invalido
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
	
	/** verifica se email eh valido
	 * @param email email a se avaliado
	 * @throws EmailInvalidoException
	 */
	public void verificaEmail(String email) throws EmailInvalidoException{
		if(email.trim().equals("") || email == null){
			throw new EmailInvalidoException("Email do(a) hospede nao pode ser vazio.");
		}
		Matcher matcher = pattern.matcher(email);
	    if(!matcher.matches()){
	    	throw new EmailInvalidoException("Email do(a) hospede esta invalido.");	    	
	    }
	}
	
	/** verifica se data de nascimento eh valido
	 * @param dataNascimento data a ser avalida
	 * @throws DataNascimentoInvalidaException caso data seja invalida
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

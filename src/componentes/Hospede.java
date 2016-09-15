package componentes;

//1 - é nescesario documentar metodos sets, metodos obvios ou documentar exception?
//2 - caso eu documento tenho que explicar para que serva cada parametro e exception mesmo que seja obvio?
//3 - para explicar um trexo de codigo, deve utilizar comentario de fim de linha ou normal?
import execeptions.EmailInvalidoException;
import execeptions.NomeInvalidoException;
import execeptions.dataNascimentoInvalidaException;

/**
 * @author Ricardo Andrade
 * @author Gabriel Schubert
 * @since 13/09/16
 * @version v1.0
 */
public class Hospede {
	private String nome;
	private String email;
	private String dataNascimento;
	
	/**
	 * @param nome nome do hospede
	 * @param email email do hospede que sera usado de login
	 * @param dataNascimento data completa de nascimento no formato DD/MM/AAAA
	 * @throws NomeInvalidoException caso o nome seja invalido
	 * @throws EmailInvalidoException caso o email seja invalido
	 * @throws dataNascimentoInvalidaException 
	 */
	public Hospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException, dataNascimentoInvalidaException{
		this.verificaNome(nome);
		this.nome = nome;
		this.verificaEmail(email);
		this.email = email;
		this.verificaDataNascimento(dataNascimento);
		this.dataNascimento = dataNascimento;
	}
	
	private void verificaNome(String nome) throws NomeInvalidoException{
		if(nome == null || nome.equals("")){
			throw new NomeInvalidoException("Nome nao pode ser vazio ou nulo");
		}
		
		// verificando se o nome é apenas um string de espacos
		for (int letra = 0; letra < nome.length(); letra++) {
			if(nome.charAt(letra) != ' '){
				return;				
			}
		}
		throw new NomeInvalidoException("Formato de nome invalido");
	}
	
	private void verificaEmail(String email) throws EmailInvalidoException{
		if(nome == null || nome.equals("")){
			throw new EmailInvalidoException("Nome nao pode ser vazio ou nulo");
		}
		
		// verificando se o email tem um usuario(antes do @) e um dominio(depois do @)
		if(email.charAt(0) == '@' || email.charAt(0) == '.' || email.charAt(email.length()-1) == '@' || email.charAt(email.length()-1) == '.'){
			throw new EmailInvalidoException("Formato de email invalido");
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
					throw new EmailInvalidoException("Formato de email invalido");
				} else if (email.charAt(letra) == '.') {
					hasPonto = true;
				}
			}
		}
		if(!hasPonto){
			throw new EmailInvalidoException("Formato de email invalido");
		}
	}
	
	private void verificaDataNascimento(String dataNascimento) throws dataNascimentoInvalidaException{
		if(dataNascimento == null || dataNascimento.equals("")){
			throw new dataNascimentoInvalidaException("dataNascimento nao pode ser vazio ou nulo");
		}
		String[] componetesDeData = dataNascimento.split("/");
		if(componetesDeData.length != 3 || componetesDeData[0].length() != 2 || componetesDeData[1].length() != 2 || componetesDeData[2].length() != 4){
			throw new dataNascimentoInvalidaException("Formato de dataNascimento invalido");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws NomeInvalidoException {
		this.verificaNome(nome);
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws EmailInvalidoException {
		this.verificaEmail(email);
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) throws dataNascimentoInvalidaException {
		this.verificaDataNascimento(dataNascimento);
		this.dataNascimento = dataNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Hospede))
			return false;
		Hospede other = (Hospede) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
}

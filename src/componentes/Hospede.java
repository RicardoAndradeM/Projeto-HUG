package componentes;

import execeptions.EmailInvalidoException;
import execeptions.NomeInvalidoException;

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
	 */
	public Hospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException{
		this.verificaNome(nome);
		this.nome = nome;
		this.verificaEmail(email);
		this.email = email;
		this.verificaDataNascimento();
		//this.dataNascimento = dataNascimento;
	}
	
	private void verificaNome(String nome) throws NomeInvalidoException{
		if(nome == null || nome.equals("")){
			throw new NomeInvalidoException("Nome nao pode ser vazio ou nulo");
		}
	}
	
	//melhorar espaçamentos de linhas de codigo e sobre padronizar messaguem de erro / fazer documentacao
	private void verificaEmail(String email) throws EmailInvalidoException{
		if(nome == null || nome.equals("")){
			throw new EmailInvalidoException("Nome nao pode ser vazio ou nulo");
		}
		if(email.charAt(0) == '@' || email.charAt(0) == '.' || email.charAt(email.length()-1) == '@' || email.charAt(email.length()-1) == '.'){
			throw new EmailInvalidoException("Formato de email invalido");
		}
		
		int quantidadeDeArrobas = 0;
		int quantidadeDePontos = 0;
		
		//pergunta ao professor se devo ir do primeiro ao ultimo ou não / fazer documentacao
		for (int letra = 0; letra < email.length(); letra++) {
			if(email.charAt(letra) == '@'){
				quantidadeDeArrobas++;
			} else if( email.charAt(letra) == '.'){
				quantidadeDePontos++;
			}
		}
		
		if(quantidadeDeArrobas != 1 || quantidadeDePontos < 1){
			throw new EmailInvalidoException("Formato de email invalido");
		}
	}
	
	//fazer depois / fazer documentacao
	private void verificaDataNascimento(){}

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

	public void setDataNascimento(String dataNascimento) {
		//this.verificaDataNascimento();
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

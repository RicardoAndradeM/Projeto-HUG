package componentes;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.DataNascimentoInvalidaException;
import exceptions.EmailInvalidoException;
import exceptions.NomeInvalidoException;

/**
 * @author Ricardo Andrade
 * @since 13/09/16
 * @version v1.0
 */
public class Hospede {
	private String nome;
	private String email;
	private String dataNascimento;
	private HashMap<String, Estadia> estadias;
	private VerificadorDeHospede verificador = new VerificadorDeHospede();
	
	/**
	 * @param nome nome do hospede
	 * @param email email do hospede que sera usado de login
	 * @param dataNascimento data completa de nascimento no formato DD/MM/AAAA
	 * @throws NomeInvalidoException caso o nome seja invalido
	 * @throws EmailInvalidoException caso o email seja invalido
	 * @throws DataNascimentoInvalidaException caso data de nascimento esteja no formato errado
	 */
	public Hospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException, DataNascimentoInvalidaException{
		this.verificador.verificaNome(nome);
		this.nome = nome;
		this.verificador.verificaEmail(email);
		this.email = email;
		this.verificador.verificaDataNascimento(dataNascimento);
		this.dataNascimento = dataNascimento;
		this.estadias = new HashMap<String, Estadia>();
	}
	
	/** associa uma estadia ao hospede
	 * @param estadia estadia a ser associadsa
	 */
	public void redebeEstadia(Estadia estadia){
		this.estadias.put(estadia.getQuartoNumero(), estadia);
	}
	
	/** remove e retorna a estadia associada ao hospede no momento do checkout
	 * @param numeroQuarto numero do quarto da estadia
	 * @return a estadia solicitada
	 */
	public Estadia devolveEstadia(String numeroQuarto){
		return this.estadias.remove(numeroQuarto);
	}
	
	/**
	 * @return retonar nome do hospede
	 */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws NomeInvalidoException {
		this.verificador.verificaNome(nome);
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws EmailInvalidoException {
		this.verificador.verificaEmail(email);
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) throws DataNascimentoInvalidaException {
		this.verificador.verificaDataNascimento(dataNascimento);
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

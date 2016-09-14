package componentes;

//melhorar javadoc
import java.util.HashSet;

import execeptions.EmailInvalidoException;
import execeptions.NomeInvalidoException;

/**
 * @author Ricardo Andrade
 * @author Gabriel Schubert
 * @since 14/09/16
 * @version v1.0
 */
public class Controler {
	private HashSet<Hospede> hospedes;
	private FactoryDeHospedes factoryDeHospedes;
	
	//pergunta se precisa documentar construtores obvios
	public Controler() {
		this.hospedes = new HashSet<Hospede>();
		factoryDeHospedes = new FactoryDeHospedes(); // lembrar de colocar construtores no UML e toStrings
	}
	
	/**
	 * @param nome nome do hospede
	 * @param email email do hospede que sera usado de login
	 * @param dataNascimento data completa de nascimento no formato DD/MM/AAAA
	 * @return id do hospede, neste caso, o email
	 * @throws EmailInvalidoException 
	 * @throws NomeInvalidoException 
	 */
	public String cadastraHospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException{
		Hospede novoHospede = factoryDeHospedes.criaHospede(nome, email, dataNascimento);
		hospedes.add(novoHospede);
		return novoHospede.getEmail();
	}
	
	/**
	 * @param id email do hospede
	 * @param atributo informacao a ser consultada
	 * @return informacao solicitada
	 */
	public String getInfoHospede(String id, String atributo){
		Hospede hospede = this.buscaHospede(id);
		if(atributo.equals("nome")){
			return hospede.getNome();
		}
		if(atributo.equals("Data de Nascimento")){
			return hospede.getDataNascimento();
		}
		// erro se atributo estiver errado
	}

	/**
	 * @param id email do hospede
	 * @param atributo informacao a ser atualizado
	 * @param valor novo valor
	 */
	public void atualizaCadastro(String id, String atributo, String valor){
		Hospede hospede = this.buscaHospede(id);
		if(atributo.equals("nome")){
			hospede.setNome(valor);
		}
		if(atributo.equals("Data de Nascimento")){
			hospede.setDataNascimento(valor);
		}
		if(atributo.equals("Data de Nascimento")){
			hospede.setEmail(valor);
		}
		//erro se atributo estiver errado
	}
	
	// perguntar se é boa pratica manter o nome dos parametros iguais e se precisam ser iguais aos testes
	/**
	 * @param email email do hospede
	 * @return retorna verdadeiro caso seja concluido com sucesso
	 */
	public boolean removeHospede(String email){
		return hospedes.remove(this.buscaHospede(email));
	}
	
	/**
	 * @param id email do hospede
	 * @return retorna o hospede buscado
	 */
	public Hospede buscaHospede(String id) {
		for (Hospede hospede : hospedes) {
			if(hospede.getEmail().equals(id)){
				return hospede;
			}
		}
		// erro caso nao encontre hospede
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hospedes == null) ? 0 : hospedes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Controler))
			return false;
		Controler other = (Controler) obj;
		if (hospedes == null) {
			if (other.hospedes != null)
				return false;
		} else if (!hospedes.equals(other.hospedes))
			return false;
		return true;
	}
	
}

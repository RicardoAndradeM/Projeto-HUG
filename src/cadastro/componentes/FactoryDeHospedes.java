package cadastro.componentes;

import cadastro.Hospede;

/** Classe Responsavel por criar novos hospedes
 * @author ricardo
 * @since 01/10/2016
 */
public class FactoryDeHospedes {
	
	/** cria um nov hospede
	 * @param nome nome do hospede
	 * @param email email do hospde
	 * @param dataNascimento data de nascimento do hospede
	 * @return retorna o hospede criado
	 */
	public Hospede criaHospede(String nome, String email, String dataNascimento){
		return new Hospede(nome, email, dataNascimento);
	}
}

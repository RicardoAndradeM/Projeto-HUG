package restaurante.cardapio.refeicao;

import java.util.HashMap;

import restaurante.cardapio.Comestivel;
import restaurante.exception.DescricaoInvalidaException;
import restaurante.exception.NomeInvalidoException;
import restaurante.exception.PratosInvalidoException;

public class VerificadorDeRefeicao {

	/** Valida nome
	 * @param nome Nome a ser avaliado
	 * @throws NomeInvalidoException Lanca exception caso nome seja invalido
	 */
	public void verificaNome(String nome) throws NomeInvalidoException{
		if(nome == null || nome.trim().equals("")){
			throw new NomeInvalidoException("Nome da refeicao esta vazio.");
		}
	}
	
	/** Valida descricao
	 * @param Descricao Descricao a ser avalida
	 * @throws DescricaoInvalidaException Lanca exception caso descricao seja invalida
	 */
	public void verificaDescricao(String Descricao) throws DescricaoInvalidaException{
		if(Descricao == null || Descricao.trim().equals("")){
			throw new DescricaoInvalidaException("Descricao da refeicao esta vazia.");
		}
	}
	
	/** Valida Pratos
	 * @param pratosDaRefeicao Pratos a serem validados
	 * @param cardapio Lista de pratos cadastrados no sistema
	 * @throws PratosInvalidoException lanca Exception caso os pratos sejam invalidos
	 */
	public void verificaPratos(String pratosAvaliados, HashMap<String, Comestivel> cardapio) throws PratosInvalidoException{
		if(pratosAvaliados == null || pratosAvaliados.trim().equals("")){
			throw new PratosInvalidoException("Erro no cadastro de refeicao. Componente(s) esta(o) vazio(s).");
		}
		String[] pratosDaRefeicao = pratosAvaliados.split(";");
		if(pratosDaRefeicao.length < 3 || pratosDaRefeicao.length > 4){
			throw new PratosInvalidoException("Erro no cadastro de refeicao completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");
		}
		for (String pratoAvaliado : pratosDaRefeicao) {
			if(!cardapio.containsKey(pratoAvaliado) || cardapio.get(pratoAvaliado) instanceof Refeicao){
				throw new PratosInvalidoException("Erro no cadastro de refeicao. So eh possivel cadastrar refeicoes com pratos ja cadastrados.");
			}
		}
	}
}

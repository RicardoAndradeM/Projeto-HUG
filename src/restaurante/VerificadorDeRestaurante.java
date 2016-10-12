package restaurante;

import java.util.ArrayList;

import restaurante.exception.DescricaoInvalidaException;
import restaurante.exception.NomeInvalidoException;
import restaurante.exception.PratosInvalidoException;
import restaurante.exception.PrecoInvalidoException;

/** Classe que valida informacoes passadas para controlerRestaurante
 * @author Ricardo Andrade
 * @since 12/10/2016
 */
public class VerificadorDeRestaurante {
	
	/** Valida nome
	 * @param nome Nome a ser avaliado
	 * @throws NomeInvalidoException Lanca exception caso nome seja invalido
	 */
	public void verificaNome(String nome) throws NomeInvalidoException{
		if(nome == null || nome.trim().equals("")){
			throw new NomeInvalidoException("Nome do prato esta vazio.");
		}
	}
	
	/** Valida preco
	 * @param preco Preco a ser avaliado 
	 * @throws PrecoInvalidoException Lanca exception caso preco seja invalido
	 */
	public void verificaPreco(double preco) throws PrecoInvalidoException{
		if(preco < 0){
			throw new PrecoInvalidoException("Preco do prato eh invalido.");
		}
	}
	
	/** Valida descricao
	 * @param Descricao Descricao a ser avalida
	 * @throws DescricaoInvalidaException Lanca exception caso descricao seja invalida
	 */
	public void verificaDescricao(String Descricao) throws DescricaoInvalidaException{
		if(Descricao == null || Descricao.trim().equals("")){
			throw new DescricaoInvalidaException("Descricao do prato esta vazia.");
		}
	}
	
	/** Valida Pratos
	 * @param pratosDaRefeicao Pratos a serem validados
	 * @param pratos Lista de pratos cadastrados no sistema
	 * @throws PratosInvalidoException lanca Exception caso os pratos sejam invalidos
	 */
	public void verificaPratos(String[] pratosDaRefeicao, ArrayList<String> pratos) throws PratosInvalidoException{
		if(pratosDaRefeicao.length < 3 || pratosDaRefeicao.length > 4){
			throw new PratosInvalidoException("Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");
		}
		for (String pratoAvaliado : pratosDaRefeicao) {
			if(!pratos.contains(pratoAvaliado)){
				throw new PratosInvalidoException("So eh possivel cadastrar refeicoes com pratos ja cadastrados.");
			}
		}
	}
}

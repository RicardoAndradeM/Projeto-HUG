package restaurante.comida.prato;

import java.util.ArrayList;

import restaurante.exception.DescricaoInvalidaException;
import restaurante.exception.NomeInvalidoException;
import restaurante.exception.PratosInvalidoException;
import restaurante.exception.PrecoInvalidoException;

/** Classe que valida informacoes passadas para controlerRestaurante
 * @author Ricardo Andrade
 * @since 12/10/2016
 */
public class VerificadorDePrato {
	
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
}

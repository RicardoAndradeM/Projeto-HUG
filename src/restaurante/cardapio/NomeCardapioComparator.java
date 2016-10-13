package restaurante.cardapio;

/** Classe que compara item de cardapio por nome
 * @author Ricardo Andrade
 * @since 12/10/2016
 */
public class NomeCardapioComparator extends EstrategiaOrdenacaoCadapio{

	@Override
	public int compare(Comestivel atual, Comestivel comparado) {
		return atual.getNome().compareTo(comparado.getNome());
	}

}
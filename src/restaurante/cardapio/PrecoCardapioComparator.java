package restaurante.cardapio;

/** Classe que compara item de cardapio por preco
 * @author Ricardo Andrade
 * @since 12/10/2016
 */
public class PrecoCardapioComparator extends EstrategiaOrdenacaoCadapio{

	@Override
	public int compare(Comestivel atual, Comestivel comparado) {
		if((atual.getPreco() - comparado.getPreco()) > 0){
			return 1;
		} else if((atual.getPreco() - comparado.getPreco()) == 0){
			return 0;
		}
		return -1;
	}

}

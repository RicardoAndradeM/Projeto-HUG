package enums;
/**
 * @author Gabriel Schubert
 * @since 19/09/2016
 * @version v1.0
 */
public enum TipoDeQuarto {
	
	SIMPLES(100),
	LUXO(250),
	PRESIDENCIAL(450);
	
	double preco;
	

	private TipoDeQuarto(double preco){
		this.preco = preco;
	}
	
	public double getPreco(){
		return preco;
	}
}

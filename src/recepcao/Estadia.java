package recepcao;

import exceptions.valordeatributoinvalido.QuantidadedeDiasInvalidaException;

/**
 * Classe que representa uma estadia
 * @since 15/09/16
 */
public class Estadia {
	private Quarto quarto;
	private int quantidadeDias;
	
	public Estadia(Quarto quarto, int quantidadeDias) throws QuantidadedeDiasInvalidaException{
		verificaQuantidadedeDias(quantidadeDias);
		
		this.quarto = quarto;
		this.quantidadeDias = quantidadeDias;
	}
	
	/** calcula valor da estadia
	 * @return valor da estadia
	 */
	public double calculaValor(){
		return quarto.getValorDoQuarto() * quantidadeDias;
	}
	
	/**
	 * @return retorna numero do quarto
	 */
	public String getQuartoNumero(){
		return quarto.getNumeroQuarto();
	}
	
	/**
	 * @return retorna a duracao da estadia
	 */
	public int getQuantidadeDias(){
		return this.quantidadeDias;
	}
	
	/** muda numero do quarto
	 * @param novoQuartoID novo numero de quarto
	 */
	public void setQuartoNumero(String novoQuartoID){
		quarto.setNumeroQuarto(novoQuartoID);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quantidadeDias;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Estadia))
			return false;
		Estadia other = (Estadia) obj;
		if (quantidadeDias != other.quantidadeDias)
			return false;
		return true;
	}

	private void verificaQuantidadedeDias(int quantidadeDias) throws QuantidadedeDiasInvalidaException {
		if (quantidadeDias<=0){
			throw new QuantidadedeDiasInvalidaException("Quantidade de dias invalida");
		}
	}
}

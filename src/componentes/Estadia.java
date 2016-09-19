package componentes;

import execeptions.QuantidadedeDiasInvalidaException;

public class Estadia {
	private Quarto quarto;
	private int quantidadeDias;
	
	public Estadia(Quarto quarto, int quantidadeDias) throws QuantidadedeDiasInvalidaException{
		verificaQuantidadedeDias(quantidadeDias);
		
		this.quarto = quarto;
		this.quantidadeDias = quantidadeDias;
	}
	
	public double calculaValor(){
		return quarto.getValorDoQuarto() * quantidadeDias;
	}
	
	public String getQuartoNumero(){
		return quarto.getNumeroQuarto();
	}
	
	public int getQuantidadeDias(){
		return this.quantidadeDias;
	}
	
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

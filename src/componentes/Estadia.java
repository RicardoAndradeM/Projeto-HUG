package componentes;

import execeptions.QuantidadedeDiasInvalidaException;

public class Estadia {
	private Quarto quarto;
	private int quantidadeDias;
	
	public Estadia(Quarto quarto, int quantidadeDias){
		verificaQuantidadedeDias(quantidadeDias);
		
		this.quarto = quarto;
		this.quantidadeDias = quantidadeDias;
	}
	
	public double calculaValor(){
		return quarto.getValorQuarto() * quantidadeDias;
	}
	
	public String getQuartoID(){
		return quarto.getNumeroDeQuarto();
	}
	
	public int getQuantidadeDias(){
		return this.quantidadeDias;
	}
	
	public void setQuartoID(String novoQuartoID){
		quarto.setNumeroDeQuarto(novoQuartoID);
	}
	
	private void verificaQuantidadedeDias(int quantidadeDias) throws QuantidadedeDiasInvalidaException {
		if (quantidadeDias<=0){
			throw new QuantidadedeDiasInvalidaException("Quantidade de dias invalida");
		}
	}
}

package componentes;

import execeptions.QuantidadedeDiasInvalidaException;

public class Estadia {
	private Quarto quarto;
	private int quantidadeDias;
	
	public Estadia(String quartoID, int quantidadeDias){
		verificaQuantidadedeDias(quantidadeDias);
		
		quarto = new Quarto(quartoID);
		this.quantidadeDias = quantidadeDias;
	}
	
	public double calculaValor(){
		return quarto.getValorQuarto() * quantidadeDias;
	}
	
	public String getQuartoID(){
		return quarto.getID();
	}
	
	public int getQuantidadeDias(){
		return this.quantidadeDias;
	}
	
	public void setQuartoID(String novoQuartoID){
		quarto.setId(novoQuartoID);
	}
	
	private void verificaQuantidadedeDias(int quantidadeDias) throws QuantidadedeDiasInvalidaException {
		if (quantidadeDias<=0){
			throw new QuantidadedeDiasInvalidaException("Quantidade de dias invalida");
		}
	}
}

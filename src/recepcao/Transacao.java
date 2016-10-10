package recepcao;

/** Classe que representa uma trasacao no hotel
 * @author Ricardo Andrade
 * @since 09/10/2016
 */
public class Transacao {
	private String dataDeSaida;
	private String nomeHospede;
	private String numeroDoQuarto;
	private double totalPago;
	
	/**
	 * @return retorna a data de saida do hotel
	 */
	public String getDataDeSaida() {
		return dataDeSaida;
	}
	
	/**
	 * @return retorna o nome do o hospede
	 */
	public String getNomeHospede() {
		return nomeHospede;
	}
	
	/**
	 * @return retorna o numero do quarto em que estava hospedado
	 */
	public String getNumeroDoQuarto() {
		return numeroDoQuarto;
	}
	
	/**
	 * @return retorna o valor pago ao fazer checkout
	 */
	public double getTotalPago() {
		return totalPago;
	}
}

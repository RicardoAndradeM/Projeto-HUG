package recepcao;

/**
 * @since 18/09/16
 */
public class Checkout {
	String dataDeSaida;
	String nomeHospede;
	String numeroDoQuarto;
	double totalPago;
	
	/**
	 * @param dataDeSaida data da saida do hospede
	 * @param nomeHospede nome do hospede
	 * @param numeroDoQuarto numero do quarto
	 * @param totalPago total pago pelo hospede na estadia
	 */
	public Checkout(String dataDeSaida, String nomeHospede, String numeroDoQuarto, double totalPago) {
		this.dataDeSaida = dataDeSaida;
		this.nomeHospede = nomeHospede;
		this.numeroDoQuarto = numeroDoQuarto;
		this.totalPago = totalPago;
	}
	
	/**
	 * @return a data de saida do hospede
	 */
	public String getDataDeSaida() {
		return dataDeSaida;
	}
	
	/**
	 * @return nome do hospede
	 */
	public String getNomeHospede() {
		return nomeHospede;
	}
	
	/**
	 * @return numero do quarto da estadia
	 */
	public String getNumeroDoQuarto() {
		return numeroDoQuarto;
	}
	
	/**
	 * @return total pego pego hospena na estadia
	 */
	public double getTotalPago() {
		return totalPago;
	}
}

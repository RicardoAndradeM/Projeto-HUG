package recepcao;

import java.time.LocalDate;

/** Classe que representa uma trasacao no hotel
 * @author Ricardo Andrade
 * @since 09/10/2016
 */
public class Transacao {
	private LocalDate dataDeSaida;
	private String nomeHospede;
	private String numeroDoQuarto;
	private double totalPago;
	
	/** Controi uma nova transacao
	 * @param dataDeSaida data de saida do hospede
	 * @param nomeHospede nome do hospede
	 * @param numeroDoQuarto numero do quarto em que ele ficou hospedado
	 * @param totalPago total pago na hora do checkout
	 */
	public Transacao(LocalDate dataDeSaida, String nomeHospede, String numeroDoQuarto, double totalPago) {
		this.dataDeSaida = dataDeSaida;
		this.nomeHospede = nomeHospede;
		this.numeroDoQuarto = numeroDoQuarto;
		this.totalPago = totalPago;
	}
	
	/**
	 * @return retorna a data de saida do hotel
	 */
	public LocalDate getDataDeSaida() {
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

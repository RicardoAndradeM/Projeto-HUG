package componentes;

public class Checkout {
	String dataDeSaida;
	String nomeHospede;
	String numeroDoQuarto;
	double totalPago;
	
	public Checkout(String dataDeSaida, String nomeHospede, String numeroDoQuarto, double totalPago) {
		this.dataDeSaida = dataDeSaida;
		this.nomeHospede = nomeHospede;
		this.numeroDoQuarto = numeroDoQuarto;
		this.totalPago = totalPago;
	}
	
	public String getDataDeSaida() {
		return dataDeSaida;
	}
	public String getNomeHospede() {
		return nomeHospede;
	}
	public String getNumeroDoQuarto() {
		return numeroDoQuarto;
	}
	public double getTotalPago() {
		return totalPago;
	}
}

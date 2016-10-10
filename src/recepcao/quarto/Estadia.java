package recepcao.quarto;

/**
 * Classe que representa uma estadia
 * @author Ricardo Andrade
 * @author Gabriel
 * @since 15/09/16
 */
public class Estadia {
	private String idHospede;
	private int dias;
	
	/** Cria uma nova estadia
	 * @param idHospede email do hospede
	 * @param dias dias que o hospede ficar hospedado
	 */
	public Estadia(String idHospede, int dias) {
		this.idHospede = idHospede;
		this.dias = dias;
	}

	/** Metodo que calcula o valor da estadia
	 * @param tipo tipo de quarto em que ele esta hospedado
	 * @return retorna o valor da estadia
	 */
	public double calculaValor(TipoDeQuarto tipo) {
		return tipo.getPreco() * this.dias;
	}

	/**
	 * @return retorna o email do hospede
	 */
	public String getIdHospede() {
		return idHospede;
	}

	/**
	 * @return retorna a quantidade de dias que hospede ficara hospedado
	 */
	public int getDias() {
		return dias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dias;
		result = prime * result + ((idHospede == null) ? 0 : idHospede.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estadia other = (Estadia) obj;
		if (dias != other.dias)
			return false;
		if (idHospede == null) {
			if (other.idHospede != null)
				return false;
		} else if (!idHospede.equals(other.idHospede))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Estadia de %s dias", this.getDias());
	}
}

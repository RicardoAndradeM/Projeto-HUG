package recepcao.quarto;

import recepcao.exception.QuartoDesocupadoException;
import recepcao.exception.QuartoOcupadoException;

/** 
 * Classe que representa um quarto
 * @since 15/09/16
 * @since Ricardo Andrade
 * @since Ygor
 */
public class Quarto {
	private String numero;
	private TipoDeQuarto tipo ;
	private Estadia estadia;
	
	/** Cria um novo quarto
	 * @param numero Numero do Quarto
	 * @param tipo Tipo do quarto
	 */
	public Quarto(String numero, TipoDeQuarto tipo) {
		this.numero = numero;
		this.tipo = tipo;
	}
	
	/** Metodo que recebe uma nova estadia quando o hospede faz checkin
	 * @param estadia Estadia a ser recebida
	 * @throws QuartoOcupadoException Lanca exception caso o quarto ja esteja ocupado
	 */
	public void recebeEstadia(Estadia estadia) throws QuartoOcupadoException{
		if(this.getEstadia() == null ){
			this.estadia = estadia;
		}
		throw new QuartoOcupadoException(String.format("Quarto %s ja esta ocupado.", this.getNumero()));
	}
	
	/** Metodo que devolve a estadia quando o hospede faz checkout(desocupa o quarto)
	 * @return Retorna a estadia do quarto
	 * @throws QuartoDesocupadoException Lanca exception caso quarto ja esta desocupado
	 */
	public Estadia devolveEstadia() throws QuartoDesocupadoException{
		if(this.getEstadia() != null){
			Estadia estadiaASerEntrege = this.getEstadia();
			this.estadia = null;
			return  estadiaASerEntrege;
		}
		throw new QuartoDesocupadoException(String.format("Quarto %s nao esta ocupado.", this.getNumero()));
	}
	
	/** Metodo que Calcula o valor da estadia no quarto
	 * @return o valor da estadia
	 * @throws QuartoDesocupadoException Lanca exception quando quarto esta desocupado
	 */
	public double calculaValor() throws QuartoDesocupadoException{
		if(this.getEstadia() != null){
			return this.getEstadia().calculaValor(this.tipo);			
		}
		throw new QuartoDesocupadoException(String.format("Quarto %s nao esta ocupado.", this.getNumero()));
	}

	/**
	 * @return retorna o numero do quarto
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @return retorna o tipo do quarto
	 */
	public TipoDeQuarto getTipo() {
		return tipo;
	}
	
	/**
	 * @return retorna a estadia do quarto
	 */
	public Estadia getEstadia() {
		return estadia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Quarto other = (Quarto) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		switch (this.tipo) {
		case LUXO:
			return String.format("Quarto %s Luxo", this.getNumero());
			
		case PRESIDENCIAL:
			return String.format("Quarto %s Simples", this.getNumero());
		
		default:
			return String.format("Quarto %s Simples", this.getNumero());
		}
	}

}

package recepcao.exception;

/** Representa Exception caso hospede nao tenha nenhuma hospedagem
 * @since 11/10/2016
 */
public class HospedeNaoHospedadoException extends RecepcaoException {
	private static final long serialVersionUID = 4877411977598691762L;

	public HospedeNaoHospedadoException(String msg) {
		super(msg);
	}

}

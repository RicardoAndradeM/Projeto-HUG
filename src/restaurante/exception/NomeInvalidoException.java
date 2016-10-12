package restaurante.exception;

import recepcao.exception.RecepcaoException;

/** Lanca exception caso nome seja invalido
 * @author  Ricardo Andrade
 * @since 12/10/2016
 */
public class NomeInvalidoException extends RecepcaoException {

	private static final long serialVersionUID = -7495953997815692326L;

	public NomeInvalidoException(String msg) {
		super(msg);
	}

}

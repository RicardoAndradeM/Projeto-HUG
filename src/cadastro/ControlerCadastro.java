package cadastro;

import java.util.HashMap;

import cadastro.componentes.FactoryDeHospedes;
import exceptions.valordeatributoinvalido.DataNascimentoInvalidaException;
import exceptions.valordeatributoinvalido.EmailInvalidoException;
import exceptions.valordeatributoinvalido.NomeInvalidoException;

public class ControlerCadastro {
	private HashMap<String, Hospede> hospedes;
	private FactoryDeHospedes factoryDeHospedes;
	private VerificadorDeHospede verificadorDeHospede;
	
	public ControlerCadastro() {
		this.hospedes = new HashMap<String, Hospede>();
		this.factoryDeHospedes = new FactoryDeHospedes();
		this.verificadorDeHospede = new VerificadorDeHospede();
	}
	
	public String cadastraHospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException, DataNascimentoInvalidaException{
		this.verificadorDeHospede.verificaNome(nome);
		this.verificadorDeHospede.verificaEmail(email);
		this.verificadorDeHospede.verificaDataNascimento(dataNascimento);
		return null;
	}
}

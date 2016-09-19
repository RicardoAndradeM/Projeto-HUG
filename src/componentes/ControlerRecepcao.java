package componentes;

import java.time.LocalDate;
import java.util.ArrayList;
//melhorar javadoc
//lembra de colocar tostring hashcod e eguals no UML
//4 - perguntar se é boa pratica manter o nome dos parametros iguais e se precisam ser iguais aos testes
import java.util.HashSet;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QDecoderStream;
import com.sun.xml.internal.ws.message.AttachmentUnmarshallerImpl;

import enums.TipoDeQuarto;
import execeptions.EmailInvalidoException;
import execeptions.HospedeNaoEncontradoException;
import execeptions.NomeDeAtributoInvalidoException;
import execeptions.NomeInvalidoException;
import execeptions.dataNascimentoInvalidaException;
import sun.nio.cs.HistoricallyNamedCharset;

/**
 * @author Ricardo Andrade
 * @since 14/09/16
 * @version v1.0
 */
public class ControlerRecepcao {
	private HashSet<Hospede> hospedes;
	private ArrayList<Checkout> historicoDeCheckout;
	private FactoryDeHospedes factoryDeHospedes;
	private FactoryDeQuarto factoryDeQuarto;
	private FactoryDeEstadia factoryDeEstadia;
	
	public ControlerRecepcao() {
		this.hospedes = new HashSet<Hospede>();
		this.factoryDeHospedes = new FactoryDeHospedes();
		this.historicoDeCheckout = new ArrayList<Checkout>();
	}
	
	/**
	 * @param nome nome do hospede
	 * @param email email do hospede que sera usado de logind
	 * @param dataNascimento data completa de nascimento no formato DD/MM/AAAA
	 * @return id do hospede, neste caso, o email
	 * @throws EmailInvalidoException 
	 * @throws NomeInvalidoException 
	 * @throws dataNascimentoInvalidaException 
	 */
	public String cadastraHospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException, dataNascimentoInvalidaException{
		Hospede novoHospede = factoryDeHospedes.criaHospede(nome, email, dataNascimento);
		hospedes.add(novoHospede);
		return novoHospede.getEmail();
	}
	
	/**
	 * @param id email do hospede
	 * @param atributo informacao a ser consultada
	 * @return informacao solicitada
	 * @throws NomeDeAtributoInvalidoException 
	 * @throws HospedeNaoEncontradoException 
	 */
	public String getInfoHospede(String id, String atributo) throws NomeDeAtributoInvalidoException, HospedeNaoEncontradoException{
		Hospede hospede = this.buscaHospede(id);
		if(atributo.equals("Nome")){
			return hospede.getNome();
		}
		if(atributo.equals("Data de Nascimento")){
			return hospede.getDataNascimento();
		}
		throw new NomeDeAtributoInvalidoException("Atributo nao existe");
	}

	/**
	 * @param id email do hospede
	 * @param atributo informacao a ser atualizado
	 * @param valor novo valor
	 * @throws EmailInvalidoException 
	 * @throws NomeInvalidoException 
	 * @throws dataNascimentoInvalidaException 
	 * @throws NomeDeAtributoInvalidoException 
	 * @throws HospedeNaoEncontradoException 
	 */
	public void atualizaCadastro(String id, String atributo, String valor) throws EmailInvalidoException, NomeInvalidoException, dataNascimentoInvalidaException, NomeDeAtributoInvalidoException, HospedeNaoEncontradoException{
		Hospede hospede = this.buscaHospede(id);
		if(atributo.equals("Nome")){
			hospede.setNome(valor);
		} else if(atributo.equals("Data de Nascimento")){
			hospede.setDataNascimento(valor);
		} else if(atributo.equals("Email")){
			hospede.setEmail(valor);
		} else {
		throw new NomeDeAtributoInvalidoException("Atributo nao existe");
		}
	}
	
	/**
	 * @param email email do hospede
	 * @return retorna verdadeiro caso seja concluido com sucesso
	 * @throws HospedeNaoEncontradoException 
	 */
	public boolean removeHospede(String email) throws HospedeNaoEncontradoException{
		return hospedes.remove(this.buscaHospede(email));
	}
	
	/**
	 * @param id email do hospede
	 * @return retorna o hospede buscado
	 * @throws HospedeNaoEncontradoException 
	 */
	public Hospede buscaHospede(String id) throws HospedeNaoEncontradoException {
		for (Hospede hospede : hospedes) {
			if(hospede.getEmail().equals(id)){
				return hospede;
			}
		}
		throw new HospedeNaoEncontradoException(String.format("Erro na consulta de hospede. Hospede de email %s nao foi cadastrado(a).", id));
	}
	
	public void checkin(String id, String numeroQuarto, TipoDeQuarto tipoDeQuarto, int quantidadeDias){
		Quarto novoQuarto = this.factoryDeQuarto.criaQuarto(numeroQuarto, tipoDeQuarto);
		Estadia novaEstadia = this.factoryDeEstadia.criaEstadia(novoQuarto,quantidadeDias);
		this.buscaHospede(id).redebeEstadia(novaEstadia);
	}
	
	public void checkout(String id, String numeroQuarto) throws HospedeNaoEncontradoException{
		Estadia estadiaASerFechada = this.buscaHospede(id).devolveEstadia(numeroQuarto);
		this.historicoDeCheckout.add(new Checkout(LocalDate.now().toString(), buscaHospede(id).getNome(), estadiaASerFechada.getQuartoID(), estadiaASerFechada.calculaValor()));
	}
}

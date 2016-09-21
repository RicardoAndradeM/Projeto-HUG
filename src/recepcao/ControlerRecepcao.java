package recepcao;

import java.time.LocalDate;
import java.util.ArrayList;
//melhorar javadoc
//lembra de colocar tostring hashcod e eguals no UML
//4 - perguntar se é boa pratica manter o nome dos parametros iguais e se precisam ser iguais aos testes
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import enums.TipoDeQuarto;
import exceptions.naocadastrado.HospedeNaoEncontradoException;
import exceptions.naocadastrado.NaoCadastradoException;
import exceptions.valordeatributoinvalido.DataNascimentoInvalidaException;
import exceptions.valordeatributoinvalido.EmailInvalidoException;
import exceptions.valordeatributoinvalido.NomeDeAtributoInvalidoException;
import exceptions.valordeatributoinvalido.NomeInvalidoException;
import exceptions.valordeatributoinvalido.QuantidadedeDiasInvalidaException;
import factorys.FactoryDeEstadia;
import factorys.FactoryDeHospedes;
import factorys.FactoryDeQuarto;

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
	private final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
	
	public ControlerRecepcao() {
		this.hospedes = new HashSet<Hospede>();
		this.factoryDeHospedes = new FactoryDeHospedes();
		this.historicoDeCheckout = new ArrayList<Checkout>();
	}
	
	/** cadastra hospede no sitema
	 * @param nome nome do hospede
	 * @param email email do hospede que sera usado de logind
	 * @param dataNascimento data completa de nascimento no formato DD/MM/AAAA
	 * @return id do hospede, neste caso, o email
	 * @throws EmailInvalidoException caso email seja invalido
	 * @throws NomeInvalidoException caso nome seja invalido
	 * @throws DataNascimentoInvalidaException caso data de nascimento seja invalido
	 */
	public String cadastraHospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException, DataNascimentoInvalidaException{
		Hospede novoHospede = factoryDeHospedes.criaHospede(nome, email, dataNascimento);
		hospedes.add(novoHospede);
		return novoHospede.getEmail();
	}
	
	/** retorna informacoes do hospede
	 * @param id email do hospede
	 * @param atributo informacao a ser consultada
	 * @return informacao solicitada
	 * @throws NomeDeAtributoInvalidoException caso nome do atributo seja invalido
	 * @throws HospedeNaoEncontradoException caso hospede nao esteja cadastrado no sistema
	 */
	public String getInfoHospede(String id, String atributo) throws NomeDeAtributoInvalidoException, HospedeNaoEncontradoException{
		Hospede hospede = this.buscaHospede(id);
		if(atributo.equals("Nome")){
			return hospede.getNome();
		}
		if(atributo.equals("Data de Nascimento")){
			return hospede.getDataNascimento();
		}
		if(atributo.equals("Email")){
			return hospede.getEmail();
		}
		throw new NomeDeAtributoInvalidoException("Atributo nao existe");
	}

	/** retorna informacoes do espede
	 * @param email email do hospede
	 * @param atributo atributo solicitado
	 * @return atribulo que foi solicitado
	 * @throws Exception .
	 */
	public String getInfoHospedagem(String email, String atributo) throws Exception{
		
		Hospede hospedeTemp = buscaHospede(email);
		
		if (atributo.equals("Hospedagens ativas")){
			int infoHospedagem = hospedeTemp.getHospedagensAtivas();
			if (infoHospedagem==0){
				throw new Exception("Erro na consulta de hospedagem. Hospede Alfred Nobel nao esta hospedado(a).");
			}
			return String.valueOf(infoHospedagem);
			
		}else if (atributo.equals("Total")){
			String valorTotal = String.valueOf(hospedeTemp.getValorTotalEstadias());
			return "R$"+valorTotal;
					
		}else if (atributo.equals("Quarto")){
		 String quartos = String.valueOf(hospedeTemp.getQuarto());
		 
		 quartos = quartos.replace("]", "");
		 quartos = quartos.replace("[", "");
		 quartos = quartos.replace(" ", "");
		 
			return quartos;
		}
		return "0";
	}
	
	/** atualiza dados de hospede
	 * @param id email do hospede
	 * @param atributo informacao a ser atualizado
	 * @param valor novo valor
	 * @throws EmailInvalidoException caso email seja invalido
	 * @throws NomeInvalidoException caso nome seja invalido
	 * @throws DataNascimentoInvalidaException caso data seja invalida
	 * @throws NomeDeAtributoInvalidoException caso nome do atributo seja invalido
	 * @throws HospedeNaoEncontradoException caso hospede nao esteja cadastrado
	 */
	public void atualizaCadastro(String id, String atributo, String valor) throws EmailInvalidoException, NomeInvalidoException, DataNascimentoInvalidaException, NomeDeAtributoInvalidoException, HospedeNaoEncontradoException{
		Hospede hospede = this.buscaHospede(id);
		if(atributo.equals("Nome")){
			try {
				hospede.setNome(valor);				
			} catch (NomeInvalidoException e) {
				throw new NomeDeAtributoInvalidoException("Erro na atualizacao do cadastro de Hospede. " + e.getMessage());
			}
		} else if(atributo.equals("Data de Nascimento")){
			try {
				hospede.setDataNascimento(valor);				
			} catch (DataNascimentoInvalidaException e) {
				throw new DataNascimentoInvalidaException("Erro na atualizacao do cadastro de Hospede. " + e.getMessage());
			}
		} else if(atributo.equals("Email")){
			try {
				hospede.setEmail(valor);				
			} catch (EmailInvalidoException e) {
				throw new EmailInvalidoException("Erro na atualizacao do cadastro de Hospede. " + e.getMessage());
			}
		} else {
			throw new NomeDeAtributoInvalidoException("Atributo nao existe");
		}
	}
	
	/** remove hospede do sistema
	 * @param email email do hospede
	 * @return retorna verdadeiro caso seja concluido com sucesso
	 * @throws HospedeNaoEncontradoException caso hospede nao esteja cadastrado
	 * @throws EmailInvalidoException caso email seja invalido
	 */
	public boolean removeHospede(String email) throws HospedeNaoEncontradoException, EmailInvalidoException{
		if(email.trim().equals("") || email == null){
			throw new EmailInvalidoException("Erro na remocao do Hospede. Email do(a) hospede nao pode ser vazio.");
		}
		Matcher matcher = pattern.matcher(email);
	    if(!matcher.matches()){
	    	throw new EmailInvalidoException("Erro na remocao do Hospede. Formato de email invalido.");	    	
	    }
		return hospedes.remove(this.buscaHospede(email));
	}
	
	/** busca hospede no sistema
	 * @param id email do hospede
	 * @return retorna o hospede buscado
	 * @throws HospedeNaoEncontradoException  caso hospede nao seja encontrado
	 */
	public Hospede buscaHospede(String id) throws HospedeNaoEncontradoException {
		for (Hospede hospede : hospedes) {
			if(hospede.getEmail().equals(id)){
				return hospede;
			}
		}
		throw new HospedeNaoEncontradoException(String.format("Erro na consulta de hospede. Hospede de email %s nao foi cadastrado(a).", id));
	}
	
	/** realiza o chekin do hospede
	 * @param id email do hospede
	 * @param quantidadeDias dia que ficara hospedado
	 * @param numeroQuarto numero do quarto em que ficara
	 * @param tipoDeQuartoString string do tipo de quarto que ocupara
	 * @throws NomeDeAtributoInvalidoException caso nome seja invalido
	 * @throws QuantidadedeDiasInvalidaException caso a quantidade de dias seja invalida
	 * @throws HospedeNaoEncontradoException caso hospe não esja cadastrado
	 */
	public void realizaCheckin(String id, String numeroQuarto, String tipoDeQuartoString, int quantidadeDias) throws NomeDeAtributoInvalidoException, QuantidadedeDiasInvalidaException, HospedeNaoEncontradoException{
		TipoDeQuarto tipoDeQuarto;
		if(tipoDeQuartoString.equals("Presidencial")){
			tipoDeQuarto = TipoDeQuarto.PRESIDENCIAL;
		} else if (tipoDeQuartoString.equals("Luxo")){
			tipoDeQuarto = TipoDeQuarto.LUXO;
		} else {
			tipoDeQuarto = TipoDeQuarto.SIMPLES;
		}
		//Quarto novoQuarto = this.factoryDeQuarto.criaQuarto(numeroQuarto, tipoDeQuarto);
		Quarto novoQuarto = new Quarto(numeroQuarto, tipoDeQuarto);
		//Estadia novaEstadia = this.factoryDeEstadia.criaEstadia(novoQuarto,quantidadeDias);
		Estadia novaEstadia = new Estadia(novoQuarto, quantidadeDias);
		this.buscaHospede(id).redebeEstadia(novaEstadia);
	}
	
	/** faz o checkout do hospede no sistema
	 * @param id email do hospede
	 * @param numeroQuarto numero do quarto em que ficara
	 * @throws HospedeNaoEncontradoException caso hospede não seja encontrado
	 */
	public void checkout(String id, String numeroQuarto) throws HospedeNaoEncontradoException{
		Estadia estadiaASerFechada = this.buscaHospede(id).devolveEstadia(numeroQuarto);
		this.historicoDeCheckout.add(new Checkout(LocalDate.now().toString(), buscaHospede(id).getNome(), estadiaASerFechada.getQuartoNumero(), estadiaASerFechada.calculaValor()));
	}
}

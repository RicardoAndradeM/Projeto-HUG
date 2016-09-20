package componentes;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.jacadastrado.JaCadastradoException;
import exceptions.naocadastrado.NaoCadastradoException;
import exceptions.valordeatributoinvalido.NomeDeAtributoInvalidoException;
import restaurante.ControlerRestaurante;
import restaurante.Prato;
import restaurante.Refeicao;

public class ControlerRestauranteTest {
	
	public final String PRATO_JA_CADASTRADO = "prato jah esta cadastrado";
	public final String REFEICAO_JA_CADASTRADA = "Refeicao jah esta cadastrada";
	public final String REFEICAO_INEXISTENTE = "Refeicao nao cadastrada";
	public final String PRATO_INEXISTENTE = "Prato nao existe";
	
	ControlerRestaurante restaurante;
	Prato burger1;
	Prato burger2;
	Prato burger3;
	Prato burger4;
	Refeicao engorda1;
	
	@Before
	public void setUp() throws Exception {
		restaurante = new ControlerRestaurante();
		
		burger1 = new Prato("Burger1", 8.00, "Burger de carne");
		burger2 = new Prato("Burger2", 8.00, "Burger de Frango");
		burger3 = new Prato("Burger3", 16.00, "Burger de Bode");
		burger4 = new Prato("Burger4", 80.0, "Burger de Rolinha");
		
		restaurante.cadastraRefeicao("engorda1", "Fique gordinho", burger4, burger4, burger4, burger4);
	}

	@Test
	public void testCadastraPrato() throws Exception {
		restaurante.cadastraPrato("McBurger", 7.00, "Hamburger Venenoso");
		try{
			restaurante.cadastraPrato("McBurger", 7.00, "Hamburger Venenoso");
			fail("Deveria ter retornado uma exception");
		}catch(JaCadastradoException e){
			assertEquals(PRATO_JA_CADASTRADO, e.getMessage());
		}
	}

	@Test
	public void testCadastraRefeicao3() throws Exception {
		restaurante.cadastraRefeicao("Mega Burgers", "Serie de hamburgers imperdivel", burger1, burger2, burger3);
		Refeicao refeicao = new Refeicao("Mega Burgers", "Serie de hamburgers imperdivel", burger1, burger2, burger3);
		assertEquals(refeicao, restaurante.buscaRefeicao("Mega Burgers"));
		
		try {
			restaurante.cadastraRefeicao("Mega Burgers", "Serie de hamburgers imperdivel", burger1, burger2, burger3);
			fail("Deveria ter retornado uma exception pois a refeicao jah esta cadastrada");
		} catch (JaCadastradoException e) {
			assertEquals(REFEICAO_JA_CADASTRADA, e.getMessage());
		}
		
		
	}

	@Test
	public void testCadastraRefeicao4() throws Exception {
		restaurante.cadastraRefeicao("Mega Burgers", "Serie de hamburgers imperdivel", burger1, burger2, burger3, burger4);
		Refeicao refeicao = new Refeicao("Mega Burgers", "Serie de hamburgers imperdivel", burger1, burger2, burger3, burger4);
		assertEquals(refeicao, restaurante.buscaRefeicao("Mega Burgers"));
	}

	@Test
	public void testAtualizaPrato() throws Exception {
		restaurante.cadastraPrato("Salada Bomba", 1.00, "Salada de frutas e verduras");
		restaurante.atualizaPrato("Salada Bomba","preco", "666.0");
		assertEquals(666.0, restaurante.buscaPrato("Salada Bomba").getPreco(), 0);
		
		try {
			restaurante.cadastraPrato("Petit Gateau", 1.00, "Sorvete com nome chique");	
		} catch (JaCadastradoException e) {
			assertEquals("prato jah cadastrado", e.getMessage());
		}
	}

	@Test
	public void testAtualizaRefeicao() throws Exception {
			restaurante.atualizaRefeicao("engorda1", "nome", "Vida curta");
			assertEquals("Vida curta", restaurante.buscaRefeicao("Vida curta").getNome());
			
			try {
				restaurante.atualizaRefeicao("Feijoada", "preco", "25.0");
			} catch (NaoCadastradoException e) {
				assertEquals(REFEICAO_INEXISTENTE, e.getMessage());
			}
	}

	@Test
	public void testBuscaRefeicao() throws NomeDeAtributoInvalidoException {
		Refeicao refeicaoTemp = new Refeicao("engorda1", "Fique gordinho", burger4, burger4, burger4, burger4);
		assertEquals(refeicaoTemp, restaurante.buscaRefeicao("engorda1"));
		
	}

	@Test
	public void testVerificaPrato() throws Exception {
		restaurante.cadastraPrato("MilkGalinha", 24.00, "Delicioso MilkShake sabor Galinha Caipira");
		assertEquals(true, restaurante.verificaPrato("MilkGalinha"));
	}

	@Test
	public void testVerificaRefeicao() throws Exception {
		restaurante.cadastraRefeicao("amburgers maravilhosos", "Amburgers tipo 2, eh massa", burger2, burger2, burger2);
		assertEquals(true, restaurante.verificaRefeicao("amburgers maravilhosos"));
	}

	@Test
	public void testRemovePrato() throws Exception {
		restaurante.cadastraPrato("Diamante Negro", 6.00, "Chocolate bom");
		restaurante.removePrato("Diamante Negro");
		assertEquals(null, restaurante.buscaPrato("Diamante Negro"));
		
		try {
			restaurante.removePrato("Diamante Negro");
			fail("Deveria ter retornado uma exception, pois o prato nao esta mais cadastrado");
		} catch (NaoCadastradoException e) {
			assertEquals(PRATO_INEXISTENTE, e.getMessage());
		}
	}

	@Test
	public void testRemoveRefeicao() throws Exception {
		restaurante.cadastraRefeicao("Divino's Burger", "Amburgers tipo 2, eh massa", burger2, burger2, burger2);
		restaurante.removeRefeicao("Divino's Burger");
		assertEquals(null, restaurante.buscaPrato("Divino's Burger"));
	}

}

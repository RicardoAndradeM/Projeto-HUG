package componentes;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import execeptions.NomeDeAtributoInvalidoException;

public class ControlerRestauranteTest {
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
		}catch(Exception e){
			assertEquals("prato jah esta cadastrado", e.getMessage());
		}
	}

	@Test
	public void testCadastraRefeicao3() throws Exception {
		restaurante.cadastraRefeicao("Mega Burgers", "Serie de hamburgers imperdivel", burger1, burger2, burger3);
		Refeicao refeicao = restaurante.buscaRefeicao("Mega Burgers");
	}

	@Test
	public void testCadastraRefeicao4() throws Exception {
		restaurante.cadastraRefeicao("Mega Burgers", "Serie de hamburgers imperdivel", burger1, burger2, burger3);
		Refeicao refeicao = restaurante.buscaRefeicao("Mega Burgers");
	}

	@Test
	public void testAtualizaPrato() throws Exception {
		restaurante.atualizaPrato("burger1", "preco", "12.00");
		if (!(burger1.getPreco()==12.0)){
			fail("A atualizacao do preco deveria ter mudado para 12.00");
		}
	}

	@Test
	public void testAtualizaRefeicao() throws Exception {
			restaurante.atualizaRefeicao("engorda1", "nome", "Vida curta");
			assertEquals("Vida curta", restaurante.buscaRefeicao("Vida curta").getNome());
			
	}

	@Test
	public void testBuscaRefeicao() throws NomeDeAtributoInvalidoException {
		Refeicao refeicaoTemp = new Refeicao("engorda1", "Fique gordinho", burger4, burger4, burger4, burger4);
		assertEquals(refeicaoTemp, restaurante.buscaRefeicao("engorda1"));
		
	}

	@Test
	public void testVerificaPrato() {
		
	}

	@Test
	public void testVerificaRefeicao() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemovePrato() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveRefeicao() {
		fail("Not yet implemented");
	}

}

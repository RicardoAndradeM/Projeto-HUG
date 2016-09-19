package componentes;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ControlerRestauranteTest {
	ControlerRestaurante restaurante;
	Prato burger1;
	Prato burger2;
	Prato burger3;
	Prato burger4;
	
	@Before
	public void setUp() throws Exception {
		restaurante = new ControlerRestaurante();
		burger1 = new Prato("Burger1", 8.00, "Burger de carne");
		burger2 = new Prato("Burger2", 8.00, "Burger de Frango");
		burger3 = new Prato("Burger3", 16.00, "Burger de Bode");
		burger4 = new Prato("Burger4", 80.0, "Burger de Rolinha");
	}

	@Test
	public void testCadastraPrato() throws Exception {
		restaurante.cadastraPrato("McBurger", 7.00, "Hamburger Venenoso");
		assertFalse(restaurante.cadastraPrato("McBurger", 7.00, "Hamburger Venenoso"));
	}

	@Test
	public void testCadastraRefeicao3() throws Exception {
		restaurante.cadastraRefeicao("Mega Burgers", "Serie de hamburgers imperdivel", burger1, burger2, burger3);
		Refeicao refeicao = restaurante.buscaRefeicao(Mega Burgers);
	}

	@Test
	public void testCadastraRefeicao4() {
		restaurante.cadastraRefeicao("Mega Burgers", "Serie de hamburgers imperdivel", burger1, burger2, burger3);
		Refeicao refeicao = restaurante.buscaRefeicao(Mega Burgers);
	}

	@Test
	public void testAtualizaPrato() {
		restaurante.atualizaPrato("burger1", "preco", "12.00");
		if (!(burger1.getPreco()==12.0)){
			fail("A atualizacao do preco deveria ter mudado para 12.00");
		}
	}

	@Test
	public void testAtualizaRefeicao() {
		
	}

	@Test
	public void testBuscaRefeicao() {
		fail("Not yet implemented");
	}

	@Test
	public void testVerificaPrato() {
		fail("Not yet implemented");
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

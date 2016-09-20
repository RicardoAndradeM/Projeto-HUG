package testrestaurante;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import restaurante.Prato;

public class PratoTest {

	@Before
	public void setUp() throws Exception {
		Prato macarraoIntegral = new Prato("Macarrone", 7.00,"Super bom" );
	}

	@Test
	public void testPrato() {
		Prato McLanche = new Prato("McLanche", 50.0, "Acabe com sua saude");
		
//	@Test(expected = NullPointerException.class)
//		public void construction() throws Exception {
//		GBFile broken1 = new GBFile(null, null, null);
//		GBFile broken2 = new GBFile(null, ".txt", sb1);
//		GBFile broken3 = new GBFile("broken", ".txt", null);
//		GBFile broken4 = new GBFile("broken", null, sb1);
		
//	}

	@Test
	public void testGetNome() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNome() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPreco() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPreco() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDescricao() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDescricao() {
		fail("Not yet implemented");
	}

}

package cadastro;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cadastro.exception.QuartoNaoEncontradoException;
import cadastro.exception.QuartoOcupadoException;

public class HospedeTest {
	Hospede h;
	
	@Before
	public void setup(){
		h = new Hospede("Vadinho Solsa", "vandinho@gmail.com", "17/01/1999");
	}
	
	@Test
	public void testHospede() {
		assertEquals(h, new Hospede("Vadinho Solsa", "vandinho@gmail.com", "17/01/1999"));
	}

	@Test
	public void testRecebeChave() throws QuartoOcupadoException {
		h.recebeChave("A1", 400);
		assertEquals("A1", h.getChaves().get(0));
		
		try {
			h.recebeChave("A1", 300);
		} catch (QuartoOcupadoException e) {
			assertEquals("Erro ao Fazer checkin, hospede ja esta ocupando este quarto", e.getMessage());
		}
	}

	@Test
	public void testRemoveChave() throws QuartoOcupadoException, QuartoNaoEncontradoException {
		h.recebeChave("A1", 400);
		h.removeChave("A1");
		assertEquals(new ArrayList<String>(), h.getChaves());
		try {
			h.removeChave("B2");
		} catch (QuartoNaoEncontradoException e) {
			assertEquals("Erro ao Fazer checkout, quarto nao encontrado", e.getMessage());
		}
	}

	@Test
	public void testGetDebito() throws QuartoOcupadoException {
		h.recebeChave("A1", 300);
		h.recebeChave("c4", 142);
		assertEquals(442, h.getDebito(),0);
	}

}

package cadastro.componentes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cadastro.Hospede;

public class FactoryDeHospedesTest {
	private final String NOME = "Anderson Barros";
	private final String EMAIL = "senhoanderson@bol.com.br";
	private final String DATA = "17/05/1966";
	private FactoryDeHospedes f;
	private Hospede h;
	
	@Before
	public void setup(){
		this.f = new FactoryDeHospedes();
		this.h = new Hospede(NOME, EMAIL, DATA);
	}
	
	@Test
	public void testCriaHospede() {
		assertEquals(h, f.criaHospede(NOME, EMAIL, DATA));
	}

}

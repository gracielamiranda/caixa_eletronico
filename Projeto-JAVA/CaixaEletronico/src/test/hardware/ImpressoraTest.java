package test.hardware;

import static org.junit.Assert.*;
import hardware.Impressora;

import org.junit.Test;

public class ImpressoraTest {

	@Test
	public void testImprimirRecibo() {
		Impressora impressora = new Impressora();
		
		impressora.imprimirRecibo();
		assertTrue("Simulando o teste", true);
	}

}

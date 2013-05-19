package test.hardware;

import static org.junit.Assert.*;
import hardware.Impressora;

import org.junit.Test;

import dominio.Recibo;

public class ImpressoraTest {

	@Test
	public void testImprimirRecibo() {
		Impressora impressora = new Impressora();
		Recibo recibo = new Recibo();
		recibo.informacao = "TESTE DE INFORMACAO";
		impressora.imprimirRecibo(recibo);
		assertTrue("Simulando o teste", true);
	}

}

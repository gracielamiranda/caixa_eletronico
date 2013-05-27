package test.hardware;

import static org.junit.Assert.*;
import hardware.Impressora;

import org.junit.Test;

import dominio.Conta;
import dominio.Recibo;

public class ImpressoraTest {

	@Test
	public void testImprimirRecibo() {
		
		Impressora impressora = new Impressora();
		Recibo recibo = new Recibo();
		recibo.informacao = "TESTE DE INFORMACAO";
		Conta conta = new Conta();
		conta.numero = "00000";
		recibo.conta = conta;
 		recibo.data = "00/00/9999";
 		recibo.hora = "12:22";
		try{
			impressora.imprimirRecibo(recibo);
		
			assertTrue("Simulando uma impressao", true);
			
		}catch(Exception e){
			fail("Erro ao imprimir recibo");
		}
	}
}

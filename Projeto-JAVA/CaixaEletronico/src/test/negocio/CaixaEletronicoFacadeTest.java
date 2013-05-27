package test.negocio;

import static org.junit.Assert.*;

import negocio.CaixaEletronicoFacade;
import negocio.QuantiaDisponivelNoCaixaException;

import org.junit.Test;

import util.QuantiaDesejadaException;
import util.QuantiaMultiplaDezException;

import dominio.Conta;

public class CaixaEletronicoFacadeTest {

	@Test
	public void testDepositar() {
		assertTrue("Not yet implemented",true);
	}

	@Test
	public void testConsultarSaldo() {
		assertTrue("Not yet implemented",true);
	}

	@Test
	public void testTransferir() {
		assertTrue("Not yet implemented",true);
	}

	@Test
	public void testSacar() {
		Conta conta = new Conta();
		conta.saldo = 1000D;
		try {
			new CaixaEletronicoFacade().sacar(100, conta);
		} catch (QuantiaMultiplaDezException | 
				 QuantiaDisponivelNoCaixaException | 
				 QuantiaDesejadaException e) {

			fail("Erro ao efetuar operacao de saque:"+e.getMessage());
		}
		assertTrue(conta.saldo == 900);
	}
}
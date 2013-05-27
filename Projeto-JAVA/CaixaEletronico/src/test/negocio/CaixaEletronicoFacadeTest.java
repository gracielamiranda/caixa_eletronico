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
		fail("Not yet implemented");
	}

	@Test
	public void testConsultarSaldo() {
		fail("Not yet implemented");
	}

	@Test
	public void testTransferir() {
		fail("Not yet implemented");
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
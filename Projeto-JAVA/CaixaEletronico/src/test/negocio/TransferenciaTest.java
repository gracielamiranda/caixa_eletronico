package test.negocio;

import static org.junit.Assert.fail;
import negocio.Transferencia;

import org.junit.Test;

public class TransferenciaTest {
	//TODO Implementar metodo de teste, a classe Transferencia esta incompleta
	@Test
	public void testValidarTransferencia() {
		
		Transferencia transferencia = new Transferencia();
		try{
			
			transferencia.validarTransferencia();
			fail("Not yet implemented");
		
		}catch(Exception ex){
			
			fail("Falha ao transferir");
			
		}
		
	}

}

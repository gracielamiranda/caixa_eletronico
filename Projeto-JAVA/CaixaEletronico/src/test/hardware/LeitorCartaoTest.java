package test.hardware;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import hardware.LeitorCartao;

import org.junit.Test;

public class LeitorCartaoTest {

	@Test
	public void reterCartao(){
		LeitorCartao leitorCartao = new LeitorCartao();
		try{
			
			leitorCartao.reterCartao();
			
			assertTrue("Teste de Retenção de Cartão",true);
			
		}catch(Exception ex){
			
			fail("Erro ao tentar reter o cartao");
			
		}
	}
}

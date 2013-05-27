package hardware;
/**
 * 
 */

/**
 * @author amfirmo
 *
 */
public class LeitorCartao {
	public void reterCartao(){
		System.err.println("Cartao retido com sucesso!");
		//chama a api da leitora de cartoes para reter o cartao
	}
	//TODO Que tipo e cartao?
	public int lerCartao(){

		System.err.print("Lendo cartao, aguarde");
		try {
			Thread.sleep(1000);
			System.err.print(".");
			Thread.sleep(1000);
			System.err.print(".");
			Thread.sleep(1000);
			System.err.println(".");
			Thread.sleep(500);
			System.err.println("Cartao lido com sucesso!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 004;
	}
}
package hardware;

import dominio.Recibo;
/**
 * 
 */

/**
 * @author Andre
 *
 */
public class Impressora {
	public void imprimirRecibo(Recibo recibo){
		System.out.println("Impressao de recibo");
		System.out.println("Informacao: "+recibo.informacao );
		System.out.println("Data: "+recibo.informacao );
		System.out.println("Conta: "+recibo.conta );
		System.out.println("Informacao:"+recibo.informacao );
	}
}

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
		if(recibo != null){
			System.err.println("Impressao de recibo");
			System.err.println("Informacao: "+recibo.informacao );
			System.err.println("Data: "+recibo.data );
			System.err.println("Hora: "+recibo.hora );
			System.err.println("Conta: "+recibo.conta.numero );
		}
	}
}

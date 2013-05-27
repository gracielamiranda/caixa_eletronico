package negocio;
import dominio.*;

public class ReciboController {

	private static ReciboController reciboController;
	
	private ReciboController(){
		
	}
	
	public static ReciboController getInstance(){
		if(reciboController == null){
			reciboController = new ReciboController();
		}
		return reciboController;
	}
	
	public Recibo criarRecibo() {
		return new Recibo();
	}
}

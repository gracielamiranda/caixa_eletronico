package negocio;
//TODO Implementar quando classes de negocio estiverem melhor definidas
public class CaixaEletronicoFacade {

	public void Depositar(){
		Deposito deposito  = new Deposito();
		//deposito.Depositar();
	}
	
	public void ConsultarSaldo(){
		Saldo saldo  = new Saldo();
		//saldo.ConsultarSaldo();
	}
	
	public void Transferir(){
		Transferencia transferencia  = new Transferencia();
		//transferencia.TransferirValor(contaOrigem,contaDestino, valor);
	}
	
	public void Sacar(){
		Saque saque  = new Saque();
		//saque.Sacar(conta,quantia);
	}
}
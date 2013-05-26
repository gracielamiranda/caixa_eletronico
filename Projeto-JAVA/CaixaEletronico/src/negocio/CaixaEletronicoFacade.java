package negocio;
import dominio.Conta;
import dominio.Cliente;

//TODO Implementar quando classes de negocio estiverem melhor definidas
public class CaixaEletronicoFacade {

	public void depositar(int quantia, Conta numero){
		Deposito deposito  = new Deposito();
		//deposito.Depositar();
	}
	
	public void consultarSaldo(Conta numero){
		Saldo saldo  = new Saldo();
		//saldo.ConsultarSaldo();
	}
	
	public void transferir(Conta origem, Conta destino, int valor){
		Transferencia transferencia  = new Transferencia();
		//transferencia.TransferirValor(contaOrigem,contaDestino, valor);
	}
	
	public void sacar(int valor, Conta numero){
		Saque saque  = new Saque();
		//saque.Sacar(conta,quantia);
	}
	
	public void validarCliente(Conta cartao, Cliente senha) {
		
	}
}
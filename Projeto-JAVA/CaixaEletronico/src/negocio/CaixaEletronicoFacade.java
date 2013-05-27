package negocio;
import util.DepositoNaoPermitidoException;
import util.LimiteTentativasException;
import util.QuantiaDesejadaException;
import util.QuantiaMultiplaDezException;
import util.TransferenciaNaoPermitidaException;
import dominio.Conta;
import dominio.Cliente;
import dominio.Recibo;

//TODO Implementar quando classes de negocio estiverem melhor definidas
public class CaixaEletronicoFacade {

	public void depositar(int quantia, Conta numero) throws DepositoNaoPermitidoException {
		Deposito deposito  = new Deposito();
		//deposito.Depositar();
	}
	
	public void consultarSaldo(Conta numero){
		Saldo saldo  = new Saldo();
		//saldo.ConsultarSaldo();
	}
	
	public void transferir(Conta origem, Conta destino, int valor)throws TransferenciaNaoPermitidaException{
		Transferencia transferencia  = new Transferencia();
		//transferencia.TransferirValor(contaOrigem,contaDestino, valor);
	}
	
	public Recibo sacar(int valor, Conta conta) throws QuantiaMultiplaDezException, QuantiaDisponivelNoCaixaException, QuantiaDesejadaException{
		Saque saque  = new Saque();
		return saque.sacar(conta,valor);
	}
	
	public boolean validarCliente(int cartao, String senha) throws LimiteTentativasException {
		Autenticacao aut = new Autenticacao();
		return aut.validarCliente(cartao, senha);
	}
}
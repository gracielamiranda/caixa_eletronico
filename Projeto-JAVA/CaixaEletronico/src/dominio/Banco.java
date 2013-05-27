package dominio;
/**
 * 
 */
//TODO O relacionamento entre Banco e Contas parece estar invertido no diagrama
public class Banco {
	/**
	 * 
	 */
	public Contas contas;
	
	public Banco() {
		//conta fake
		Conta conta = new Conta();
		conta.agencia = "1000";
		conta.cartao = 004;
		conta.numero = "00798";
		conta.saldo = 1200.00;
		//cliente fake
		Cliente cliente = new Cliente();
		cliente.nome = "Catherine Zeta-Jones";
		cliente.senha = "123";
		//adiciona referecia de conta para cliente
		conta.cliente = cliente;
		//nova lista de contas
		contas = new Contas();
		//adiciona nova conta na lista de contas
		contas.addConta(conta);
	}

	public boolean autorizarCliente(int cartao, String senha){
		Conta conta = contas.buscarContaPorCartao(cartao);
		//o codigo abaixo e de facil interpretacao...
		return conta!=null? conta.cliente.senha.equals(senha):false;
	}
}
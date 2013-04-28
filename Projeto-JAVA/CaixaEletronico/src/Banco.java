/**
 * 
 */

/**
 * Classe que representa a entidade Banco, apenas dever� simular as transa
 * Classe ainda se um pacote definido.
 * @author amfirmo
 *
 */
public abstract class Banco {
	public abstract void validarDeposito();
	public abstract void cancelarDeposito();
	public abstract void validarCliente();
	public abstract void consultarSaldo();
	public abstract void transferirValor();
	public abstract void validarTransferencia();
	
}

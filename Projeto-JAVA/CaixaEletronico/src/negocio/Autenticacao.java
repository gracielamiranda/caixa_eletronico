package negocio;

import util.LimiteTentativasException;
import dominio.*;

public class Autenticacao {
	
	static int tentativasErroCliente=0;
	int TOTAL_TENTATIVA_ERRO = 3;
	
	public boolean iniciarSessao(String cartao, String senha) {
		
		return false;
	}
	
	public String finalizarSessao() {
		tentativasErroCliente = 0;
		return "Sessao finalizada!";
	}
	
	public boolean validarCliente(int cartao, String senha) throws LimiteTentativasException {
		Banco banco = new Banco();
		boolean autorizado = false;
		
		autorizado = banco.autorizarCliente(cartao, senha);
		if(!autorizado){
			
			tentativasErroCliente++;
			
			if(tentativasErroCliente == TOTAL_TENTATIVA_ERRO){
				throw new LimiteTentativasException();
			}
		}
		return autorizado;
	}
}

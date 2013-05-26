package negocio;

import dominio.*;

public class Autenticacao {
	
	int tentativasErroCliente;
	int TOTAL_TENTATIVA_ERRO = 3;
	
	public boolean iniciarSessao(Conta cartao, Cliente senha) {
		
		return false;
	}
	
	public String finalizarSessao() {
		return "Sessao finalizada!";
	}
	
	public boolean validarCliente(Conta cartao, Cliente senha) {
		return false;
	}
}

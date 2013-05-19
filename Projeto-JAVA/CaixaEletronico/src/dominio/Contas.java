package dominio;

import java.util.List;

public class Contas {
	
	public List<Conta> listaDeContas;

	public void addConta(Conta conta){
		listaDeContas.add(conta);
	}
	//TODO Implementar o método equals no tipo Conta para que o metodo abaixo
	//funcione como esperado
	public void removerConta(Conta conta){
		listaDeContas.remove(conta);
	}
	//TODO numero e agencia estao sem tipos definidos no diagrama, assumindo String
	//TODO Nao ha um tipo definido no retorno deste método no diagrama, assumindo Conta
	public Conta buscarConta(String numero,String agencia){
		for (Conta conta : listaDeContas) {
			if(conta.agencia.equals(agencia) && conta.numero.equals(numero)){
				return conta;
			}
		}
		return null;
	}
}

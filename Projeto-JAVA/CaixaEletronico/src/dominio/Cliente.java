package dominio;

public class Cliente {
	//TODO DEFINIR como privado e definir os dois m�todos de acesso.
	public Conta conta;
	//TODO DEFINIR como privado e definir os dois m�todos de acesso.
	public String nome;
	//TODO DEFINIR como privado e definir os dois m�todos de acesso.
	public String senha;
	
	/**
	 * Obtem a conta
	 * @return Conta
	 */
	public Conta getConta(){
		return conta;
	}
	/**
	 * Obtem o nome do Cliente.
	 * @return
	 */
	public String getNome(){
		return nome;
	}
	//TODO Melhorar o nome deste m�todo
	public String senha(){
		return senha;
	}
	
	
}


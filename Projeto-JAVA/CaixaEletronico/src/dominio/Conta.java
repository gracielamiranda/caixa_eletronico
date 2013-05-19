package dominio;

//TODO O relacionamento de agregacao no diagrama de classes parece estar invertido.
public class Conta {
	//TODO DEFINIR como privado e definir metodos de acesso.
	public String numero;
	//TODO DEFINIR como privado e definir metodos de acesso.
	public String agencia;
	//TODO DEFINIR como privado e definir metodos de acesso.
	public Double saldo;
	//TODO DEFINIR como privado e definir metodos de acesso.
	public int cartao;
	//TODO A conta possui um cliente?
	//TODO DEFINIR como privado e definir metodos de acesso.
	public Cliente cliente;
}

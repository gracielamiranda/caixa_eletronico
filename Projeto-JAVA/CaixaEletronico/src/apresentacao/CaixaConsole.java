package apresentacao;
import hardware.Impressora;
import hardware.LeitorCartao;

import java.util.InputMismatchException;
import java.util.Scanner;

import dominio.Conta;
import dominio.Log;
import dominio.Recibo;

import util.LimiteTentativasException;
import util.QuantiaDesejadaException;
import util.QuantiaMultiplaDezException;
import util.TransferenciaNaoPermitidaException;

import negocio.CaixaEletronicoFacade;
import negocio.QuantiaDisponivelNoCaixaException;

public class CaixaConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CaixaConsole caixa = new CaixaConsole();
		caixa.menuAutenticarCliente();

	}

	public int operacaoEscolhida() {
		return 0;
	}

	public boolean menuAutenticarCliente() {
		
		String senha;
		System.out.print("Insira o cartao e informe a senha: ");
		
		Scanner scanIn = new Scanner(System.in);
		senha = scanIn.nextLine();
		
		if(senha.equals("-123")){
			scanIn.close();
			return false;
		}
		LeitorCartao leitora = new LeitorCartao();
		int cartao = leitora.lerCartao();
		
		//scanIn.close(); 

		autenticar(cartao,senha);
		scanIn.close();
		return true;
	}

	private void autenticar(int cartao, String senha){
		CaixaEletronicoFacade caixaFacade = new CaixaEletronicoFacade();
		try{
			if(caixaFacade.validarCliente(cartao, senha)){
				menuOperacoes();
			}else{
				System.out.println("Senha incorreta!!!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				menuAutenticarCliente();
			}
		}catch(LimiteTentativasException e){
			System.out.println("Limite de tentativas alcançado: O Cartao será retido");
			new LeitorCartao().reterCartao();
			Log log = new Log();
			log.log("Cartao retido por limite de tentativas ultrapassado");
			menuAutenticarCliente();
		}
	}

	private void menuOperacoes(){
		boolean houveErro  = false;
		byte opcaoByte = 0;
		Scanner scanIn = null;
		try{
			do{
				if(houveErro){
					System.out.println("Opcao invalida, nao foi possível compreender a opcao solicitada");
				}
				System.out.println("Digite o numero correspondente a opcao desejada: ");
				System.out.println("1 : Consultar ");
				System.out.println("2 : Depositar ");
				System.out.println("3 : Sacar ");
				System.out.println("4 : Consultar ");
				System.out.println("5 : Transferir ");
				System.out.println("6 : Sair ");

				scanIn = new Scanner(System.in);
				String opcao = scanIn.nextLine();
				//scanIn.close();

				try{
					opcaoByte = Byte.parseByte(opcao);	
					if(opcaoByte < 1 || opcaoByte > 6){
						houveErro = true;
					}
				}catch(Exception e){
					opcaoByte = 0; 
					houveErro = true;
				}
			}while(opcaoByte == 0 ||(opcaoByte < 1 || opcaoByte > 6));
		}catch(Exception e ){
			e.printStackTrace();
		}

		if (opcaoByte == 3){
			saque();
			menuOperacoes();
		}else if (opcaoByte == 6){
			CaixaConsole caixa = new CaixaConsole();
			caixa.menuAutenticarCliente();
		}else{
			scanIn.close();
			System.exit(0);
		}

	}
	
	private void saque(){
		int valor =0;
		do{
			System.out.println("Informe o valor do saque:");
			Scanner scanIn = new Scanner(System.in);
			try{
				valor = scanIn.nextInt();
			}catch(InputMismatchException ime){
				valor = 0;
			}
			
		}while(valor == 0);
		
		sacar(valor);
	}

	private void sacar(int valor){

		CaixaEletronicoFacade caixaFacade = new CaixaEletronicoFacade();
		Recibo recibo = null;
		try {
			//FIXME definir de onde vira o objeto conta
			Conta conta = new Conta();
			conta.saldo = 1000D;
			conta.numero = "79812";
			conta.agencia = "1000";
			
			recibo = caixaFacade.sacar(valor, conta);
			
		} catch (QuantiaMultiplaDezException e) {
			System.out.println("Quantia invalida, digite outro valor!!!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			saque();
		} catch (QuantiaDisponivelNoCaixaException e) {
			System.out.println("O caixa nao possui a quantia desejada em caixa");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			saque();
		} catch (QuantiaDesejadaException e) {
			System.out.println("Voce nao possui saldo suficiente, digite outro valor!!!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			saque();
		}
		
		if(recibo != null){
			Impressora imp = new Impressora();
			
			imp.imprimirRecibo(recibo);
			//FIXME de onde sai o dinheiro???
			//chamar o hardware que conta nota aqui
			System.out.println("Saque efetuado com sucesso, retire o dinheiro");
		}	
	}
	
	private void transferirDinheiro(){
		String numeroConta = null;
		int valorTransferencia =0;
		do{
			System.out.println("Informe a conta para transferencia:");
			Scanner scanIn = new Scanner(System.in);
			try{
				numeroConta = scanIn.nextLine();
			}catch(InputMismatchException ime){
				numeroConta = null;
			}
			
		}while(numeroConta == null || numeroConta.equals(""));
		//FIXME Nao ha isso no diagrama de sequencia
		do{
			System.out.println("Informe o valor para transferencia:");
			Scanner scanIn = new Scanner(System.in);
			try{
				valorTransferencia = scanIn.nextInt();
			}catch(InputMismatchException ime){
				valorTransferencia = 0;
			}
			
		}while(valorTransferencia == 0);

		transferir(numeroConta, valorTransferencia);
	}	
	
	private void transferir(String numeroContaDestino, int valor){
		
		CaixaEletronicoFacade caixaFacade = new CaixaEletronicoFacade();
		Recibo recibo = null;
		try {
			//FIXME definir de onde vira o objeto conta
			Conta contaOrigem = new Conta();
			contaOrigem.saldo = 1000D;
			contaOrigem.numero = "79812";
			contaOrigem.agencia = "1000";
			
			Conta contaDestino = new Conta();
			contaDestino.numero = numeroContaDestino;
			
			/*recibo =*/ caixaFacade.transferir(contaOrigem, contaDestino, valor);
			
		} catch (TransferenciaNaoPermitidaException e) {
			System.out.println("A transferencia nao pode ser realizada");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			transferirDinheiro();
		}
		
		if(recibo != null){
			Impressora imp = new Impressora();
			
			imp.imprimirRecibo(recibo);
			//FIXME de onde sai o dinheiro???
			//chamar o hardware que conta nota aqui
			System.out.println("Saque efetuado com sucesso, retire o dinheiro");
		}	
	}
	
}
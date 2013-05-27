package negocio;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import util.QuantiaDesejadaException;
import util.QuantiaMultiplaDezException;
import dominio.Conta;
import dominio.Log;
import dominio.Recibo;

public class Saque {

	public Recibo sacar(Conta conta, int quantia) throws QuantiaMultiplaDezException, QuantiaDisponivelNoCaixaException, QuantiaDesejadaException{
		
		validarQuantiaMultipla10(quantia);
		
		validarValorEmCaixa(quantia);
		
		new Log().log("SAQUE: Quantia solicitada: "+quantia+" conta numero: "+conta.numero);
		
		validarQuantiaContaCliente(conta, quantia);
		
		debitarValorSaldoCliente(conta, quantia);
		
		CaixaEletronicoController caixaController = new CaixaEletronicoController();
		
		caixaController.retirarValorCaixa(quantia);

		Recibo recibo = ReciboController.getInstance().criarRecibo();
		
		recibo.conta = conta;
		recibo.data = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		recibo.hora = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
		recibo.informacao = "Operacao de Saque efetuada";
		
		return recibo;
	}
	
	private void debitarValorSaldoCliente(Conta conta, int quantia) {
		conta.saldo = conta.saldo - quantia;
	}

	private void validarValorEmCaixa(int valor) throws QuantiaDisponivelNoCaixaException{
		CaixaEletronicoController caixaController = new CaixaEletronicoController();
		if(valor > caixaController.getValorEmCaixa()){
			throw new QuantiaDisponivelNoCaixaException();
		}
		
	}

	public Recibo construirRecibo() {
		return null;
	}
	
	public void validarQuantiaContaCliente(Conta conta, int quantia) throws QuantiaDesejadaException{
		if(conta.saldo < quantia){
			throw new QuantiaDesejadaException();
		}
	}
	
	public void validarQuantiaMultipla10(int quantia) throws QuantiaMultiplaDezException {
		if(quantia%10!=0){
			throw new QuantiaMultiplaDezException();
		}
	}
	
}

package facade;

import java.util.List;

import modelo.Conta;
import modelo.ContaBancaria;

/**
 * Classe Facade para Contas Bancárias.
 * @author jefferson
 * @date 
 */
public class Banco {
	
	private ContaBancaria contaBancaria;
	
	public Banco(ContaBancaria bancaria) {
		this.contaBancaria = bancaria;
	}
	
	public void cadastrarConta(Conta conta) {
		contaBancaria.cadastrarConta(conta);
	}
	
	public List<Conta> listarContas() {
		return contaBancaria.listarConta();
	}
}

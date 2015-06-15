package facade;

import java.util.List;




import javax.swing.JTextField;

import modelo.ContaBancaria;

/**
 * Classe Facade para Contas Bancárias.
 * @author jefferson
 * @date 
 */
public class Banco {
	//Classe criada para conexao com pacote modelo
	private ContaBancaria contaBancaria;
	
	public Banco() {
		this.contaBancaria = new ContaBancaria();
	}
	
	public void cadastrarConta(Conta conta) {
		contaBancaria.cadastrarConta(conta);
	}
	public void deletarConta(String string){
		contaBancaria.deletarConta(string);
	}
	public void creditarConta(double saldo){
		contaBancaria.creditarConta(saldo);
	}
	public List<Conta> listarContas() {
		return contaBancaria.listarConta();
	}
	
}

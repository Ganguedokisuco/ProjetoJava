package modelo;

import java.util.List;

import javax.swing.JTextField;

import persistencia.ContasBancariasBD;
import facade.Conta;

public class ContaBancaria {
	//Classe para conexao do pacote persistencia
	
	ContasBancariasBD persitencia;
	
	public ContaBancaria() {
		this.persitencia = new ContasBancariasBD();
	}
	
	public void cadastrarConta(Conta conta) {
		persitencia.adicionar(conta);
	}
	public void deletarConta(String numero){
		persitencia.deletar(numero);
	}
	public void creditarConta(double saldo){
		persitencia.creditar(saldo);
	}
	public List<Conta> listarConta() {
		return persitencia.listar();
	}
	
}

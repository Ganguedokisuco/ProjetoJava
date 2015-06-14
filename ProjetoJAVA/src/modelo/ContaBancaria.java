package modelo;

import java.util.List;

import facade.Conta;
import persistencia.IContasBancarias;

public class ContaBancaria {
	//Classe para conexao do pacote persistencia
	
	IContasBancarias persitencia;
	
	public ContaBancaria(IContasBancarias persitencia) {
		this.persitencia = persitencia;
	}
	
	public void cadastrarConta(Conta conta) {
		persitencia.adicionar(conta);
	}
	
	public List<Conta> listarConta() {
		return persitencia.listar();
	}
	
}

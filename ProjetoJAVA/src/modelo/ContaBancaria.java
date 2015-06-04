package modelo;

import java.util.List;

import persistencia.IContasBancarias;

public class ContaBancaria {
	
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

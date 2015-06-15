package persistencia;

import java.util.List;

import facade.Conta;

public interface IContasBancarias {
	
//	declarações do métodos de persistência.
	
	public void adicionar(Conta conta);
	public void deletar(String numero);
	public void atualizar(String numero);
	public void debitar(double saldo);
	public void creditar(double saldo);
	public List<Conta> listar();
}

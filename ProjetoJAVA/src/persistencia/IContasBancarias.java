package persistencia;

import java.util.List;

import facade.Conta;

public interface IContasBancarias {
	
//	declarações do métodos de persistência.
	
	public void adicionar(Conta conta);
	public void deletar(Conta conta);
	public void atualizar(Conta conta);
	public List<Conta> listar();
}

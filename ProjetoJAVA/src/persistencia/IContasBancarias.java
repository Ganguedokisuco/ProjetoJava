package persistencia;

import java.util.List;

import modelo.Conta;

public interface IContasBancarias {
	
//	declarações do métodos de persistência.
	
	public void adicionar(Conta conta);
	public List<Conta> listar();
//	...

}

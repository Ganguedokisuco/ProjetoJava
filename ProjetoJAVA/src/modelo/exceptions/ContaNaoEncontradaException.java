package modelo.exceptions;

public class ContaNaoEncontradaException extends Exception {
	
	//Código que cria o construtor.
	private String msg="Conta n�o encontrada!";
	
	public ContaNaoEncontradaException(String msg){
		super(msg);
		this.msg = msg;
	}
	
}

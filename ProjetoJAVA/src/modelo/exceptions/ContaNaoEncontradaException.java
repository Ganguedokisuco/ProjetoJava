package modelo.exceptions;

public class ContaNaoEncontradaException extends Exception {
	
	//CÃ³digo que cria o construtor.
	private String msg="Conta não encontrada!";
	
	public ContaNaoEncontradaException(String msg){
		super(msg);
		this.msg = msg;
	}
	
}

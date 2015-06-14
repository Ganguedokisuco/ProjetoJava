package modelo.exceptions;

public class ContaJaCadastradaException extends Exception{
	
	private String msg="Conta já exitente!";
	
	public ContaJaCadastradaException(String msg){
		super(msg);
		this.msg = msg;
	}
}

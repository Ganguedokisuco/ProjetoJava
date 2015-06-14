package facade;

public abstract class Conta {
	
	private String numero;
	protected double saldo;
	
	public abstract double debitar (float valor, double taxa);
	public abstract double creditar (float valor);
	
	public Conta(String numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}

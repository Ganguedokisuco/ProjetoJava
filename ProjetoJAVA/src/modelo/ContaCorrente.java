package modelo;

import facade.Conta;

public abstract  class ContaCorrente extends Conta {
	
	public ContaCorrente(String numero, double saldo) {
		super(numero, saldo);
	}
		

	
	public void debitar(float valor) {
		if(valor < saldo) 
			saldo = saldo - valor;
		else 
			System.out.println("Valor insuficiente!!!");
		
	}

	
	public double creditar(float valor) {
		return this.saldo+=valor;
		
	}
	
}

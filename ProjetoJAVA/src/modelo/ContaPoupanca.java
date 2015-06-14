package modelo;

import facade.Conta;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(String numero, double saldo) {
		super(numero, saldo);
	}
	
	public double debitar(float valor, double taxa) {
		taxa = (saldo*0.01);
		return this.saldo-=(valor*taxa);
		
	}

	
	public double creditar(float valor) {
		return this.saldo+=valor;
		
	}
	
	
}

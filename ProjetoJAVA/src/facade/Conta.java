package facade;

import java.util.List;

public class Conta {
	
	private String numero;
	private double saldo;
	private String nome;
	private String data;
	private String cpf;	
	
	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + ", nome="
				+ nome + ", data=" + data + ", cpf=" + cpf + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public void setListaConta(List<Conta> listaConta) {
		// TODO Auto-generated method stub
		
	}
}

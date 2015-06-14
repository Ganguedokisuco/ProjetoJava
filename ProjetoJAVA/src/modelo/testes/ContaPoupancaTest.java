package modelo.testes;

public class ContaPoupancaTest {

	public ContaPoupancaTest() {
	}

	
	public void setUp() throws Exception {
	}


	public void tearDown() throws Exception {
	}

	public void testDebitar(float valor, double saldo, float taxa) {
		valor = (float) (30.50);
		saldo = (double) (430.00);
		taxa = (float) (1.50);
		if(valor < saldo) 
			saldo = (saldo - valor - taxa);
		else 
			System.out.println("Valor insuficiente!!!");
	}

	
	public double testCreditar(float valor, double saldo) {
		saldo = (double) (400.00);
		valor = (float) (150.00);
		return saldo += valor;
	}

}

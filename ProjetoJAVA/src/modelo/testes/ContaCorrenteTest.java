package modelo.testes;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContaCorrenteTest extends TestCase {
	
	

	public ContaCorrenteTest() {
	}
	
		

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDebitar(float valor, double saldo, float taxa) {
		valor = (float) (200.50);
		saldo = (double) (430.00);
		taxa = (float) (1.50);
		if(valor < saldo) 
			saldo = (saldo - valor - taxa);
		else 
			System.out.println("Valor insuficiente!!!");
	}

	@Test
	public double testCreditar(float valor, double saldo) {
		saldo = (double) (400.00);
		valor = (float) (150.00);
		return saldo += valor;
	}

}

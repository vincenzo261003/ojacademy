package TestSemplice.testSemplice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalcolatriceTest {

	@Test
	public void testSomma() {
		Calcolatrice c = new Calcolatrice();
		
		int res = c.somma(12, 9);
		
		assertEquals(21, res);
	}
	
}

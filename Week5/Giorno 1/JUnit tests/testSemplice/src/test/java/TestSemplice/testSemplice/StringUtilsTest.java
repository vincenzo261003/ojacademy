package TestSemplice.testSemplice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testReverse() {
		String frase = "Hello";
		String expected = "olleH";
		
		String output = StringUtils.reverse(frase);
		
		assertEquals(expected, output);
	}
	
}

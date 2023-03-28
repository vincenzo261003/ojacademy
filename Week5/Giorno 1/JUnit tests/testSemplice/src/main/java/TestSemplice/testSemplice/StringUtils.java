package TestSemplice.testSemplice;

public class StringUtils {

	public static String reverse(String s) {
		if (s.isBlank() || s == null)
			return s;
		return new StringBuilder(s).reverse().toString();
	}
	
}

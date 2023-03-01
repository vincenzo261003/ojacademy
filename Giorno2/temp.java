package main;

public class temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] s = Dividi("Prova");
		
		System.out.println(s[0] + " " + s[1]);
	}
	
	public static String[] Dividi (String x){
		String[] s3 = {x.substring(0, x.length() / 2), x.substring(x.length() / 2)};
		return s3;
	}

}

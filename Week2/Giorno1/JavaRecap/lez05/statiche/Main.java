package com.lez05.statiche;

public class Main {

	public static void main(String[] args) {
		
		System.out.println(Studente.getContatore());

		
		
		Studente stuUno = new Studente();
		Studente stuDue = new Studente();
		Studente stuTre = new Studente();
		
//		Studente.contatore = 899;

		System.out.println(Studente.getContatore());
		
	}

}

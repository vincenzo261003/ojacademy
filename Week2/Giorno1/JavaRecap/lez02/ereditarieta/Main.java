package com.lez02.ereditarieta;

public class Main {

	public static void main(String[] args) {
		Persona per = new Persona("Giovanni", "Pace");
		System.out.println(per);
//		per.stampa();
		
		Studente stu = new Studente("Mario", "Rossi", "AB12345");
//		stu.stampa();
		
		System.out.println(stu.toString());
		System.out.println(stu);
	}

}

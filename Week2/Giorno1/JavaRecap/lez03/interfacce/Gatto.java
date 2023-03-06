package com.lez03.interfacce;

public class Gatto implements Animale{
	
	private String razza;
	private boolean haPelo;
	
	@Override
	public void versoEmesso() {
		System.out.println("Meow");
	}
	@Override
	public void locomozione() {
		System.out.println("Cammina");		
	}
	
	

}

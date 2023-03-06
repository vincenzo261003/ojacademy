package com.lez03.astrazione;

public abstract class Animale {

	private Integer numZampe;
	private String razza;
	private boolean haPeli;
	private boolean vola;
	
	public Animale() {
		System.out.println("Sono il costruttore di Animale");
	}
	
	public Integer getNumZampe() {
		return numZampe;
	}
	public void setNumZampe(Integer numZampe) {
		this.numZampe = numZampe;
	}
	public String getRazza() {
		return razza;
	}
	public void setRazza(String razza) {
		this.razza = razza;
	}
	public boolean isHaPeli() {
		return haPeli;
	}
	public void setHaPeli(boolean haPeli) {
		this.haPeli = haPeli;
	}
	public boolean isVola() {
		return vola;
	}
	public void setVola(boolean vola) {
		this.vola = vola;
	}
	
	@Override
	public String toString() {
		return "Animale [numZampe=" + numZampe + ", razza=" + razza + ", haPeli=" + haPeli + ", vola=" + vola + "]";
	}
	
	public abstract void versoEmesso();
	
	
	
}

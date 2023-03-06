package com.lez04.inclusione;

public class Indirizzo {

	private String via;
	private String citta;
	private String provincia;
	private String cap;
	
	/**
	 * Metodo per l'inizializzazione di un nuovo indirizzo
	 * @param via		Stringa contenente la via
	 * @param citta		Stringa contenente la città
	 * @param provincia Stringa contenente la provincial
	 * @param cap		Stringa contenente il CAP
	 */
	public Indirizzo(String via, String citta, String provincia, String cap) {
		super();
		this.via = via;
		this.citta = citta;
		this.provincia = provincia;
		this.cap = cap;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	@Override
	public String toString() {
		return "Indirizzo [via=" + via + ", citta=" + citta + ", provincia=" + provincia + ", cap=" + cap + "]";
	}
	
	
	
}

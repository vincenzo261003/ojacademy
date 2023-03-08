package models;

public class Libro {
	
	private Integer idLibro;
	private String titolo;
	private String descrizione;
	private Integer annoPubblicazione;
	private Float prezzo;
	private String autore;
	private String ISBN;
	
	
	public Libro(String titolo, String descrizione, Integer annoPubblicazione, Float prezzo, String autore,
			String iSBN) {
		super();
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.annoPubblicazione = annoPubblicazione;
		this.prezzo = prezzo;
		this.autore = autore;
		ISBN = iSBN;
	}


	public Libro() {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdLibro() {
		return idLibro;
	}


	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public Integer getAnnoPubblicazione() {
		return annoPubblicazione;
	}


	public void setAnnoPubblicazione(Integer annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}


	public Float getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}


	public String getAutore() {
		return autore;
	}


	public void setAutore(String autore) {
		this.autore = autore;
	}


	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titolo=" + titolo + ", descrizione=" + descrizione
				+ ", annoPubblicazione=" + annoPubblicazione + ", prezzo=" + prezzo + ", autore=" + autore + ", ISBN="
				+ ISBN + "]";
	}
	
}

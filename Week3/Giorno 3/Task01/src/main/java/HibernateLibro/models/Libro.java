package HibernateLibro.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Libreria")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="libroID")
	private Integer id;
	
	@Column
	private String titolo;
	
	@Column
	private String descrizione;
	
	@Column
	private String autore;
	
	@Column
	private String data_pubblicazione;
	
	@Column
	private String isbn;
	
	@Column
	private String casaedtrice;
	
	@Column
	private Float prezzo;

	public Libro(String titolo, String descrizione, String autore, String data_pubblicazione, String isbn,
			String casaedtrice, Float prezzo) {
		super();
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.autore = autore;
		this.data_pubblicazione = data_pubblicazione;
		this.isbn = isbn;
		this.casaedtrice = casaedtrice;
		this.prezzo = prezzo;
	}
	
	public Libro() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getData_pubblicazione() {
		return data_pubblicazione;
	}

	public void setData_pubblicazione(String data_pubblicazione) {
		this.data_pubblicazione = data_pubblicazione;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCasaedtrice() {
		return casaedtrice;
	}

	public void setCasaedtrice(String casaedtrice) {
		this.casaedtrice = casaedtrice;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}
	
}

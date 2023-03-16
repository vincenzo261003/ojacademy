package Albergo.Task02.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Stanze")
public class Stanza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idStanza;
	
	@Column
	private String nome;
	
	@Column
	private String codice;
	
	@Column
	private boolean statoOccupazione;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "idAlbergoRIF")
	private Albergo struttura;

	public Stanza(String nome, String codice, boolean statoOccupazione) {
		super();
		this.nome = nome;
		this.codice = codice;
		this.statoOccupazione = statoOccupazione;
	}
	
	public Stanza() {}

	public Integer getIdStanza() {
		return idStanza;
	}

	public void setIdStanza(Integer idStanza) {
		this.idStanza = idStanza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Albergo getStruttura() {
		return struttura;
	}

	public void setStruttura(Albergo struttura) {
		this.struttura = struttura;
	}

	public boolean isStatoOccupazione() {
		return statoOccupazione;
	}

	public void setStatoOccupazione(boolean statoOccupazione) {
		this.statoOccupazione = statoOccupazione;
	}

	@Override
	public String toString() {
		return "Stanza [idStanza=" + idStanza + ", nome=" + nome + ", codice=" + codice + ", statoOccupazione="
				+ ((this.statoOccupazione) ? "Occupata" : "Libera") + ", struttura=" + struttura.dettagli() + "]";
	}
	
	public String getDettagli() {
		return "Stanza [idStanza=" + idStanza + ", nome=" + nome + ", codice=" + codice + ", statoOccupazione="
				+ ((this.statoOccupazione) ? "Occupata" : "Libera") + "]";
	}
	
}

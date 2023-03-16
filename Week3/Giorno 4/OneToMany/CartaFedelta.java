package mattino.HibernateOneToMany.models;

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
@Table(name = "Carta")
public class CartaFedelta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartaID")
	private Integer idCarta;
	
	@Column
	private String codice;
	
	@Column
	private String numero;
	
	@Column
	private String negozio;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "personaRIF")
	private Persona proprietario;

	public CartaFedelta(String codice, String numero, String negozio) {
		super();
		this.codice = codice;
		this.numero = numero;
		this.negozio = negozio;
	}

	public Integer getIdCarta() {
		return idCarta;
	}

	public void setIdCarta(Integer idCarta) {
		this.idCarta = idCarta;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNegozio() {
		return negozio;
	}

	public void setNegozio(String negozio) {
		this.negozio = negozio;
	}
	
	public String dettaglioCarta() {
		return "CartaFedelta [id=" + id + ", codice=" + codice + ", negozio=" + negozio + "]";
	}
	
	@Override
	public String toString() {
		return "CartaFedelta [id=" + id + ", codice=" + codice + ", negozio=" + negozio + ", proprietario="
				+ proprietario.dettaglioPersona() + "]";
	}
	
}

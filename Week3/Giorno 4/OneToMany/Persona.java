package mattino.HibernateOneToMany.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "personaID")
	private Integer idPersona;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Column(name = "cod_fis")
	private String cf;
	
	@Column
	public String email;
	
	@OneToMany(mappedBy = "proprietario", fetch = FetchType.LAZY)
	private List<CartaFedelta> elencoCarte;

	public Persona(String nome, String cognome, String cf, String email) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
		this.email = email;
	}
	
	public Persona() {}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String dettaglioPersona() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codice_fiscale=" + codice_fiscale + ", email=" + email + 
				"]";
	}
	
	@Override
	public String toString() {
		String elenco = "";
		for(CartaFedelta car: elenco_carte)
			elenco += car.dettaglioCarta() + "\n";
		
		
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codice_fiscale=" + codice_fiscale + ", email=" + email + 
				", elenco_carte=" + elenco + "]";
	}
	
	
}

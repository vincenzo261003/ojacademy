package dto;

public class StudenteDto {

	private String nominativo;
	private String matricola;
	
	public StudenteDto(String nominativo, String matricola) {
		super();
		this.nominativo = nominativo;
		this.matricola = matricola;
	}
	
	public StudenteDto() {}

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
}

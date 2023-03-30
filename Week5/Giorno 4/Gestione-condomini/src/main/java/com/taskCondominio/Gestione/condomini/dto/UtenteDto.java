package com.taskCondominio.Gestione.condomini.dto;


public class UtenteDto {
	
    private String nominativo;
    private String email;
    private String telefono;
    private String pass;
    private String codiceappartamento;
    private boolean isadmin;
	private CondominioDto condominio;
	
	public UtenteDto() {}

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCodiceappartamento() {
		return codiceappartamento;
	}

	public void setCodiceappartamento(String codiceappartamento) {
		this.codiceappartamento = codiceappartamento;
	}

	public boolean isIsadmin() {
		return isadmin;
	}

	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}

	public CondominioDto getCondominio() {
		return condominio;
	}

	public void setCondominio(CondominioDto condominio) {
		this.condominio = condominio;
	}

}

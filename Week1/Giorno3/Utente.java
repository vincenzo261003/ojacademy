package main;

public class Utente {
	private String username;
	private String password;
	private float soldi;
	private boolean isAdmin;
	private int id;

	public Utente (String u, String p, int id) {
		this.username = u;
		this.password = p;
		this.soldi = (float) (Math.random() * 400);
		this.isAdmin = false;
		this.id = id;
	}
	
	public Utente (String u, String p, int id, boolean a) {
		this.username = u;
		this.password = p;
		this.isAdmin = a;
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public float getSoldi() {
		return soldi;
	}

	public void setSoldi(float soldi) {
		this.soldi = soldi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
}

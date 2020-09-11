package model;

public class ContUtilizator{
   
	//public Utilizator utilizator;
	public String functia;
	public String username;
	public String parola;
	
	public ContUtilizator() {
		super();
	}

	public ContUtilizator(String functia, String username, String parola) {
		super();
		this.functia = functia;
		this.username = username;
		this.parola = parola;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
	
	
	
	
}

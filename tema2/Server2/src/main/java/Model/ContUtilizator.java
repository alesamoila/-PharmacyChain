package Model;

public class ContUtilizator implements java.io.Serializable{
   
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

	public String getFunctia() {
		return functia;
	}

	public void setFunctia(String functia) {
		this.functia = functia;
	}
	
	
	
	
	
}

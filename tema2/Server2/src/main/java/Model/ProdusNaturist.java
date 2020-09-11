package Model;

public class ProdusNaturist  implements java.io.Serializable{

	public String nume;
	public float pret;
	public int disponibilitate;
	public String valabilitate;
	public String producator;
	public ProdusNaturist(String nume, double pret, int disponibilitate, String valabilitate, String producator) {
		super();
		this.nume = nume;
		this.pret = (float) pret;
		this.disponibilitate = disponibilitate;
		this.valabilitate = valabilitate;
		this.producator = producator;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public float getPret() {
		return pret;
	}
	public void setPret(float pret) {
		this.pret = pret;
	}
	public int getDisponibilitate() {
		return disponibilitate;
	}
	public void setDisponibilitate(int disponibilitate) {
		this.disponibilitate = disponibilitate;
	}
	public String getValabilitate() {
		return valabilitate;
	}
	public void setValabilitate(String valabilitate) {
		this.valabilitate = valabilitate;
	}
	public String getProducator() {
		return producator;
	}
	public void setProducator(String producator) {
		this.producator = producator;
	}

	
		
	
	
}

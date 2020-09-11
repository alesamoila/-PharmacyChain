package Model;
import java.util.*;

public class Utilizator implements java.io.Serializable{
    public String nume;
    public String prenume;
    public int varsta;
	public String functie;
        
        
		public Utilizator(String functie) {
			super();
			this.functie = functie;
		}

		public Utilizator(String nume, String prenume, int varsta, String functie) {
			super();
			this.nume = nume;
			this.prenume = prenume;
			this.varsta = varsta;
			this.functie = functie;
		}

		public String getFunctie() {
			return functie;
		}

		public void setFunctie(String functie) {
			this.functie = functie;
		}

		public String getNume() {
			return nume;
		}

		public void setNume(String nume) {
			this.nume = nume;
		}

		public String getPrenume() {
			return prenume;
		}

		public void setPrenume(String prenume) {
			this.prenume = prenume;
		}

		public int getVarsta() {
			return varsta;
		}

		public void setVarsta(int varsta) {
			this.varsta = varsta;
		}

		
		
		
		
		
		
		
        
        
}

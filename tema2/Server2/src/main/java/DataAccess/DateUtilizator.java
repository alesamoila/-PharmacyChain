package DataAccess;

import java.sql.SQLException;
import java.sql.Statement;

import Model.Utilizator;


public class DateUtilizator {

	 Conectare dbC = new Conectare();
	    //adaugareUtilizator - admin
	    public void adaugareUtilizator(Utilizator u) throws ClassNotFoundException {
	        try {
	            Statement stmt = dbC.connect().createStatement();
	            stmt.execute("INSERT INTO `utilizator`(`nume`, `prenume`, `varsta`, `functie`) VALUES ('" + u.getNume()
	            +"','" + u.getPrenume() + "'," + u.getVarsta() + ",'" + u.getFunctie() + "');");
	        } catch (SQLException e) {
	            System.err.println(e.getMessage());
	        }
	    }
}

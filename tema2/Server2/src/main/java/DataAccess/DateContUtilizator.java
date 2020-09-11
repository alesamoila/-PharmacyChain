package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.ContUtilizator;




public class DateContUtilizator {
	
	Conectare dbC = new Conectare();

    //adaugareAngajat - admin
    public void adaugare(ContUtilizator c) throws ClassNotFoundException {
        try {
            Statement stmt = dbC.connect().createStatement();
            stmt.execute("INSERT INTO `contutilizator`(`functie`, `username`, `parola`) VALUES ('" + c.getFunctia()
                    + "','" + c.getUsername() + "','" + c.getParola() + "');");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    //vizualizareAngajat - admin
    public ArrayList<ContUtilizator> vizualizare() throws ClassNotFoundException {
        try {
            ArrayList<ContUtilizator> listaConturi = new ArrayList<ContUtilizator>();
            Statement stmt = dbC.connect().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from `contutilizator`;");
            while (rs.next()) {
                ContUtilizator c = new ContUtilizator((String) rs.getObject(1), (String) rs.getObject(2),
                        (String) rs.getObject(3));
                listaConturi.add(c);
            }
            return listaConturi;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    //stergeAngajat - admin
    public void stergere(String user) throws ClassNotFoundException {
        try {
            Statement stmt = dbC.connect().createStatement();
            stmt.execute("DELETE FROM `contutilizator` WHERE `username` LIKE '" + user + "';");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    //modificareParola - admin
    public void modificare(String user,String parola) throws ClassNotFoundException{
        try {
            Statement stmt = dbC.connect().createStatement();
            stmt.execute("UPDATE `contutilizator` SET `parola` = '"+parola+"' WHERE `username` LIKE '"+user+ "';");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}

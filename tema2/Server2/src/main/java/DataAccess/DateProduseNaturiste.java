package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Medicament;
import Model.ProdusNaturist;

public class DateProduseNaturiste {
	
	Conectare dbC = new Conectare();
	 
    //adaugareProdusNaturist - angajat
 
    public void adaugare(ProdusNaturist p) throws ClassNotFoundException {
        try {
            Statement stmt = dbC.connect().createStatement();
            stmt.execute("INSERT INTO `produsnaturist`(`nume`, `pret`, `disponibilitate`, `valabilitate`, `producator`) VALUES ('" + p.getNume() + "'," + p.getPret()
                    + "," + p.getDisponibilitate() + ",'" + p.getValabilitate() + "','" + p.getProducator() + "');");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
  //vizualizareProdusNaturist - angajat 
    public ArrayList<ProdusNaturist> vizualizare() throws ClassNotFoundException {
        try {
            ArrayList<ProdusNaturist> listaMedicamente = new ArrayList<ProdusNaturist>();
            Statement stmt = dbC.connect().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from produsnaturist;");
            while (rs.next()) {
            	String rs3 =  (String)rs.getObject(2).toString();
            	String rs4 = (String)rs.getObject(3).toString();
                ProdusNaturist p = new ProdusNaturist((String) rs.getObject(1), Double.parseDouble(rs3), Integer.parseInt(rs4), (String) rs.getObject(4),
                        (String) rs.getObject(5));
                listaMedicamente.add(p);
                System.out.println(rs.getObject(2));
            }
            return listaMedicamente;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
  //stergeProdusNaturist - angajat
    public void sterge(String denumire) throws ClassNotFoundException {
        try {
            Statement stmt = dbC.connect().createStatement();
            stmt.execute("DELETE FROM produsnaturist WHERE nume LIKE '" + denumire+ "';");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    //modificareCantitate - angajat
    public void modificare(String nume,String cantitate) throws ClassNotFoundException{
        try {
            Statement stmt = dbC.connect().createStatement();
            stmt.execute("UPDATE produsnaturist SET disponibilitate = "+cantitate+" WHERE nume LIKE '"+nume+ "';");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    //filtrareProduseNaturiste-angajat
    
	  //fDisponibilitate, fValabilitate, fProducator, fPret
    public ArrayList<ProdusNaturist> fDisponibilitate(String criteriu) throws ClassNotFoundException{
        ArrayList<ProdusNaturist> filtrat= new ArrayList<>();
        ArrayList<ProdusNaturist> listaMedicamente=vizualizare();
        for(ProdusNaturist i: listaMedicamente){
            if(i.getDisponibilitate() == Integer.parseInt(criteriu) )
                filtrat.add(i);
        	
        		
        }
        return filtrat;
    }
    
    public ArrayList<ProdusNaturist> fValabilitate(String criteriu) throws ClassNotFoundException{
        ArrayList<ProdusNaturist> filtrat= new ArrayList<>();
        ArrayList<ProdusNaturist> listaMedicamente=vizualizare();
        for(ProdusNaturist i: listaMedicamente){
            if(i.getValabilitate().equals(criteriu) )
                filtrat.add(i);
        }
        return filtrat;
    }
    
    public ArrayList<ProdusNaturist> fProducator(String criteriu) throws ClassNotFoundException{
        ArrayList<ProdusNaturist> filtrat= new ArrayList<>();
        ArrayList<ProdusNaturist> listaMedicamente=vizualizare();
        for(ProdusNaturist i: listaMedicamente){
            if(i.getProducator().equals(criteriu) )
                filtrat.add(i);
        }
        return filtrat;
    }
    
    public ArrayList<ProdusNaturist> fPret(String criteriu) throws ClassNotFoundException{
        ArrayList<ProdusNaturist> filtrat= new ArrayList<>();
        ArrayList<ProdusNaturist> listaMedicamente=vizualizare();
        for(ProdusNaturist i: listaMedicamente){
            if(i.getPret() == Double.parseDouble(criteriu) )
                filtrat.add(i);
        }
        return filtrat;
    }




}

package DataAccess;

import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

import Model.Medicament;






public class DateMedicamente {

	 Conectare dbC = new Conectare();
	 
	    //adaugareMedicament - angajat
	 
	    public void adaugare(Medicament m) throws ClassNotFoundException {
	        try {
	            Statement stmt = dbC.connect().createStatement();
	            stmt.execute("INSERT INTO `medicament`(`nume`, `pret`, `disponibilitate`, `valabilitate`, `producator`) VALUES ('" + m.getNume() + "'," + m.getPret()
	                    + "," + m.getDisponibilitate() + ",'" + m.getValabilitate() + "','" + m.getProducator() + "');");
	        } catch (SQLException e) {
	            System.err.println(e.getMessage());
	        }
	    }
	    
	  //vizualizareMedicament - angajat 
	    public ArrayList<Medicament> vizualizare() throws ClassNotFoundException {
	        try {
	            ArrayList<Medicament> listaMedicamente = new ArrayList<Medicament>();
	            Statement stmt = dbC.connect().createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * from medicament;");
	            // rs.next();
	            //System.out.println("ajunge aici" + rs.getObject(1));
	            while (rs.next()) {
	            	String rs3 =  (String)rs.getObject(2).toString();
	            	String rs4 = (String)rs.getObject(3).toString();
	                Medicament p = new Medicament((String) rs.getObject(1), Double.parseDouble(rs3),Integer.parseInt(rs4) , (String) rs.getObject(4),
	                        (String) rs.getObject(5));
	                listaMedicamente.add(p);
	               // System.out.println(rs.getObject(2));
	            }
	            return listaMedicamente;
	        } catch (SQLException e) {
	            System.err.println(e.getMessage());
	        }
	        return null;
	    }
	    
	  //stergeMedicament - angajat
	    public void sterge(String denumire) throws ClassNotFoundException {
	        try {
	            Statement stmt = dbC.connect().createStatement();
	            stmt.execute("DELETE FROM medicament WHERE nume LIKE '" + denumire+ "';");
	        } catch (SQLException e) {
	            System.err.println(e.getMessage());
	        }
	    }
	    
	    //modificareCantitate - angajat
	    public void modificare(String nume,String cantitate) throws ClassNotFoundException{
	        try {
	            Statement stmt = dbC.connect().createStatement();
	            stmt.execute("UPDATE medicament SET disponibilitate = "+cantitate+" WHERE nume LIKE '"+nume+ "';");
	        } catch (SQLException e) {
	            System.err.println(e.getMessage());
	        }
	    }
	    
	    //filtrareMedicamente-angajat
	    
		  //fDisponibilitate, fValabilitate, fProducator, fPret
		    
		    public ArrayList<Medicament> fDisponibilitate(String criteriu) throws ClassNotFoundException{
		        ArrayList<Medicament> filtrat= new ArrayList<>();
		        ArrayList<Medicament> listaMedicamente=vizualizare();
		        for(Medicament i: listaMedicamente){
		            if(i.getDisponibilitate() == Integer.parseInt(criteriu) )
		                filtrat.add(i);
		        	
		        		
		        }
		        return filtrat;
		    }
		    
		    public ArrayList<Medicament> fValabilitate(String criteriu) throws ClassNotFoundException{
		        ArrayList<Medicament> filtrat= new ArrayList<>();
		        ArrayList<Medicament> listaMedicamente=vizualizare();
		        for(Medicament i: listaMedicamente){
		            if(i.getValabilitate().equals(criteriu) )
		                filtrat.add(i);
		        }
		        return filtrat;
		    }
		    
		    public ArrayList<Medicament> fProducator(String criteriu) throws ClassNotFoundException{
		        ArrayList<Medicament> filtrat= new ArrayList<>();
		        ArrayList<Medicament> listaMedicamente=vizualizare();
		        for(Medicament i: listaMedicamente){
		            if(i.getProducator().equals(criteriu) )
		                filtrat.add(i);
		        }
		        return filtrat;
		    }
		    
		    public ArrayList<Medicament> fPret(String criteriu) throws ClassNotFoundException{
		        ArrayList<Medicament> filtrat= new ArrayList<>();
		        ArrayList<Medicament> listaMedicamente=vizualizare();
		        for(Medicament i: listaMedicamente){
		            if(i.getPret() == Double.parseDouble(criteriu) )
		                filtrat.add(i);
		        }
		        return filtrat;
		    }

	    
		    public void salvareRapoarteCsv() throws ClassNotFoundException  {
		        ArrayList<Medicament> listaMedicamente=vizualizare();
		        try{
		            String csv = "raport.csv";
		            CSVWriter writer = new CSVWriter(new FileWriter(csv));
		            ArrayList<String[]> data = new ArrayList<>();
		            for(Medicament i:listaMedicamente){
		                data.add(new String[]{i.getNume(),i.getProducator(), i.getValabilitate()});
		            }
		            writer.writeAll(data);
		            writer.close();
		        }catch(Exception e) {
		            e.getMessage();
		        }
		    }
	 }
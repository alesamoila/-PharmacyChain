package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectare {
	
	   private Connection con;
	    public Connection connect() throws ClassNotFoundException {
	        try {
	           Class.forName("com.mysql.cj.jdbc.Driver");
	          //  String driver = "com.mysql.jdbc.Driver";
	          //  String host = "jdbc:mysql://127.0.0.1:3306/farmacie";
	          //  String user = "root";
	         //   String pass = "";
	           // System.setProperty(driver,"");
	            
	            
	            
	            con = DriverManager.getConnection("jdbc:mysql://localhost/farmacie","root","root");
	            System.out.println("Connected database successfully...");
	          
	        } catch (SQLException err) {
	            System.out.println(err.getMessage());
	        }
	        return con;
	    }
}


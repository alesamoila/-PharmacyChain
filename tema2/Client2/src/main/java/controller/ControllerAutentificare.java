package controller;

import java.util.Arrays;
import java.util.List;

import client.Client;



public class ControllerAutentificare {

	private String username;
	private String password;

	public ControllerAutentificare(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	 public List<String> transform(String init){
	        String interm = init.replace("[",",");
	        String fin= interm.replace("]",",");
	        fin=fin.replaceAll("\\s+","");
	        String str[] = fin.split(",");
	        List<String> al =  Arrays.asList(str);
	        return al;
	    }
	 public String cautareDupaUserSiParola( List<String> listaConturi,String user,String parola){
	        for(int i=1;i<listaConturi.size()-2;i+=3){
	            if(listaConturi.get(i).equals(user) && listaConturi.get(i+1).equals(parola))
	                return listaConturi.get(i+2);
	           // System.out.println(listaConturi.get(i) + " " + listaConturi.get(i+1) + " " + listaConturi.get(i+2));
	        }
	        return null;
	 }
	 
	 public String control(Client client){
	        String init=client.demand("4","\n");
	         List<String> listaConturi=transform(init);
	         String functie=cautareDupaUserSiParola(listaConturi,username,password);
	        try {
	            if (username.contentEquals("admin")) {
	                return "Conectat ca si admin";
	            }
	            else 
	            	if (username.startsWith("f"))
	            	//if(functie == "AngajatFarmacie")
	            		return "Conectat ca si angajat farmacie";
	            
	            else return "Conectat ca si angajat plafar";
	            }
	        catch(NullPointerException e){
	            return "Esec";
	        }
	    }
}

	
	



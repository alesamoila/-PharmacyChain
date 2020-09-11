package controller;


import java.io.FileWriter;

import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

import model.Medicament;
import client.Client;



public class ControllerAngajatFarmacie {
	
	 public List<String> control1(Client client) {
	        String init=client.demand("1","\n");
	        return client.transform(init);
	    }
	 
	 public List<String> vizualizare(Client client) {
	        String init=client.demand("4","\n");
	        return client.transform(init);

	    }
	
	  public void adaugare(List<String> lista, Client client){
	        String crit="";
	        for(String s:lista){
	            crit+=s+" ";
	        }
	        client.demand("7",crit);
	    }
	  
	  public void stergere(String denumire,Client client){
	        client.demand("8",denumire);
	    }
	  
	    public void modificare(String denumire,int disponibilitate,Client client){
	        String crit="";
	        crit=crit+denumire+" "+disponibilitate;
	        client.demand("9",crit);
	    }
	    
	    public List<String> fD(Client client, String criteriu) {
	        String init=client.demand("f",criteriu);
	        return client.transform(init);
	    }
	    
	    public List<String> fV(Client client, String criteriu) {
	        String init=client.demand("g",criteriu);
	        return client.transform(init);
	    }
	    
	    public List<String> fPret(Client client, String criteriu) {
	        String init=client.demand("h",criteriu);
	        return client.transform(init);
	    }
	    
	    public List<String> fProd(Client client, String criteriu) {
	        String init=client.demand("i",criteriu);
	        return client.transform(init);
	    }
	
	    public void salvareRapoarteCsv(Client client)  {

	        List<String> listaMedicamente = new ArrayList<String>();
            listaMedicamente = new ControllerAngajatFarmacie().control1(client);
	        try{
	            String csv = "raport.csv";
	            CSVWriter writer = new CSVWriter(new FileWriter(csv));
	            ArrayList<String[]> data = new ArrayList<String[]>();
	            for (int i = 1; i < listaMedicamente.size() - 1; i = i + 3)
	                data.add(new String[]{listaMedicamente.get(i),listaMedicamente.get(i+1),listaMedicamente.get(i+2)});
	            writer.writeAll(data);
	            writer.close();
	        }catch(Exception e) {
	            e.getMessage();
	        }


	    }

}

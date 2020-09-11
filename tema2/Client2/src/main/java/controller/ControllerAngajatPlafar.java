package controller;


import java.util.List;

import client.Client;


public class ControllerAngajatPlafar {
	
	 public List<String> control1(Client client) {
	        String init=client.demand("d","\n");
	        return client.transform(init);
	    }
	
	 public List<String> vizualizare(Client client) {
	        String init=client.demand("e","\n");
	        return client.transform(init);

	    }
	 
	public void adaugare(List<String> lista, Client client){
        String crit="";
        for(String s:lista){
            crit+=s+" ";
        }
        client.demand("a",crit);
    }
  
  public void stergere(String denumire,Client client){
        client.demand("b",denumire);
    }
    public void modificare(String denumire,int disponibilitate,Client client){
        String crit="";
        crit=crit+denumire+" "+disponibilitate;
        client.demand("c",crit);
    }
    
    public List<String> fD(Client client, String criteriu) {
        String init=client.demand("j",criteriu);
        return client.transform(init);
    }
    
    public List<String> fV(Client client, String criteriu) {
        String init=client.demand("k",criteriu);
        return client.transform(init);
    }
    
    public List<String> fPret(Client client, String criteriu) {
        String init=client.demand("l",criteriu);
        return client.transform(init);
    }
    
    public List<String> fProd(Client client, String criteriu) {
        String init=client.demand("m",criteriu);
        return client.transform(init);
    }

	
	
}

package controller;

import java.util.List;

import client.Client;


public class ControllerAdministrator {

	
	public List<String> vizualizare(Client client) {
        String init=client.demand("3","\n");
        return client.transform(init);

    }

    public void adaugare(List<String> lista,Client client){
        String crit="";
        for(String s:lista){
            crit+=s+" ";
        }
        client.demand("5",crit);
    }

    public void stergere(String user,Client client){
        client.demand("6",user);
    }

    public void modificare(String user,String parola,Client client){
        String crit="";
        crit=crit+user+" "+parola;
        client.demand("z",crit);
    }

}

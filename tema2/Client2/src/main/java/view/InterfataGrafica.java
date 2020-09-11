package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.Client;
import client.Config;
import controller.ControllerAutentificare;

public class InterfataGrafica {

	 public static void main(String args[]) {
		    Config c=new Config();
	        final Client client=new Client();
	        String port=c.config("config.properties",1);
	        String ip=c.config("config.properties",2);
	        client.connect(ip,Integer.parseInt(port));

	        final JFrame frame = new JFrame("LANT DE FARMACII");
	        frame.setVisible(false);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1366, 768);
	        final JPanel panel = new JPanel( new FlowLayout(FlowLayout.CENTER, 0, 0) );
	        final JPanel panelVizualizare = new JPanel();
	        final JPanel panelDate = new JPanel();
	        final JPanel panelLog = new JPanel();
	        panelLog.setBounds(0,0,550,260);
	        panelVizualizare.setBounds(550,0,750,600);
	        panelDate.setBounds(70,290,700,500);
	        panel.setLayout(null);
	        panelVizualizare.setLayout(null);
	        panelDate.setLayout(null);
	        panelLog.setLayout(null);
	        
	       
	        
	        
	        JLabel l1 = new JLabel("Username:");
	        JLabel l2 = new JLabel("Password:");
	        final JTextField t1 = new JTextField("");
	        final JTextField t2 = new JTextField("");
	        JButton b1 = new JButton("Login");
	        JButton b2 = new JButton("Logout");
	        l1.setBounds(255,70,100,20);
	        l2.setBounds(255,90,100,20);
	        t1.setBounds(355,70,100,20);
	        t2.setBounds(355,90,100,20);
	        b1.setBounds(300,120,100,20);
	        b2.setBounds(300,140,100,20);
	       
	        ImageIcon background = new ImageIcon("logo.png");
	        JLabel label = new JLabel();
	        label.setBounds(0, -50, 512, 300);
	        label.setIcon(background);
	        panelLog.add(label);
	        panelLog.add(l1);
	        panelLog.add(l2);
	        panelLog.add(t1);
	        panelLog.add(t2);
	        panelLog.add(b1);
	        panelLog.add(b2);
	        
	        b1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                ControllerAutentificare c=new ControllerAutentificare(t1.getText(),t2.getText());
	                String rez=c.control(client);
	                if(rez.equalsIgnoreCase("Conectat ca si angajat plafar")) {
	                    panelDate.removeAll();
	                    panelDate.updateUI();
	                    JLabel l10=new JLabel("ANGAJAT PLAFAR");
	                    JLabel l1=new JLabel("Adaugare medicament:");
	                    JLabel l2=new JLabel("Nume:");
	                    JLabel l3=new JLabel("Pret:");
	                    JLabel l4=new JLabel("Disponibilitate:");
	                    JLabel lProducator = new JLabel("Producator:");
	                    JLabel lValabilitate = new JLabel("Valabilitate:");
	                    JLabel l5=new JLabel("Salvare rapoarte:");
	                    JLabel l6=new JLabel("Stergere medicament:");
	                    JLabel l12=new JLabel("Nume:");
	                    JLabel l7=new JLabel("Modificare disponibilitate:");
	                    JLabel l8=new JLabel("Nume:");
	                    JLabel l9=new JLabel("Disponibilitate :");
	                    JTextField t5=new JTextField();
	                    JTextField t6=new JTextField();
	                    //JButton b2=new JButton(".csv");
	                    //JButton b3=new JButton(".txt");
	                    JTextField t1=new JTextField();
	                    JTextField t2=new JTextField();
	                    JTextField t3=new JTextField();
	                    JTextField t4=new JTextField();
	                    JTextField tProd = new JTextField();
	                    JTextField tVal = new JTextField();
	                    JButton b1=new JButton("Adauga");
	                    JButton b4=new JButton("Sterge");
	                    JButton b6=new JButton("Modifica");
	                    JButton afis2 = new JButton("Afiseaza produsele naturiste");
	                    JButton filtru = new JButton("Disponibilitate");
	                    JButton fValabilitate = new JButton ("Valabilitate");
	                    JButton fPret = new JButton("Pret");
	                    JButton fProducator = new JButton("Producator");
	                    JTextField f = new JTextField();
	                    JLabel filtrareDupa = new JLabel("Filtreaza dupa: ");
	                    l10.setBounds(225,0,200,20);
	                    l1.setBounds(0,50,200,20);
	                    b1.setBounds(150,50,100,20);
	                    l2.setBounds(50,80,200,20);
	                    l3.setBounds(50,100,200,20);
	                    l4.setBounds(50,120,200,20);
	                    lValabilitate.setBounds(50, 140, 200, 20);
	                    lProducator.setBounds(50, 160, 200, 20);
	                    b4.setBounds(150,210,100,20);
	                    t1.setBounds(150,80,100,20);
	                    t2.setBounds(150,100,100,20);
	                    t3.setBounds(150,120,100,20);
	                    tVal.setBounds(150, 140, 100, 20);
	                    tProd.setBounds(150, 160, 100, 20);
	                    l5.setBounds(0,80,200,20);
	                    //b2.setBounds(100,80,100,20);
	                    l6.setBounds(0,210,200,20);
	                    t4.setBounds(150,230,100,20);
	                    l7.setBounds(0,260,160,20);
	                    l8.setBounds(50,280,100,20);
	                    l9.setBounds(50,300,100,20);
	                    t5.setBounds(150,280,100,20);
	                    t6.setBounds(150,300,100,20); 
	                    b6.setBounds(150,330,100,20);
	                    afis2.setBounds(10, 20, 200, 20);
	                    filtrareDupa.setBounds(100, 160, 100, 20);
	                    filtru.setBounds(100, 180, 100, 20);
	                    fValabilitate.setBounds(100, 200, 100, 20);
	                    fPret.setBounds(100, 220, 100, 20);
	                    fProducator.setBounds(100, 240, 100, 20);
	                    f.setBounds(0, 160, 90, 20);
	                    panelDate.add(l1);panelDate.add(l2);panelDate.add(l3);panelDate.add(l4);
	                    panelDate.add(t1);panelDate.add(t2);panelDate.add(t3);
	                    panelVizualizare.add(l5);panelDate.add(b1);//panelVizualizare.add(b2);//panelDate.add(b3);
	                    panelDate.add(l6);panelDate.add(t4);panelDate.add(b4);panelDate.add(t5);
	                    panelDate.add(l7);panelDate.add(l8);panelDate.add(l9);panelDate.add(t6);panelDate.add(b6);
	                    panelVizualizare.add(l10);panelDate.add(lValabilitate);panelDate.add(lProducator);panelDate.add(tVal);panelDate.add(tProd);
	                    panelDate.add(afis2);panelDate.add(l12);
	                    panelVizualizare.add(filtrareDupa);
	                    panelVizualizare.add(f);
	                    panelVizualizare.add(filtru);
	                    panelVizualizare.add(fPret);
	                    panelVizualizare.add(fProducator);
	                    panelVizualizare.add(fValabilitate);
	                    b1.addActionListener(new InterfataPlafar(frame,panelDate,1,t1,t2,t3,tVal,tProd,client));
	                    filtru.addActionListener(new InterfataPlafar(frame,panelVizualizare,2,f,client));
	                    fValabilitate.addActionListener(new InterfataPlafar(frame,panelVizualizare,3,f, client));
	                    fPret.addActionListener(new InterfataPlafar(frame,panelVizualizare,7,f, client));
	                    fProducator.addActionListener(new InterfataPlafar(frame,panelVizualizare,8,f,client));
	                   // b3.addActionListener(new InterfataAngajat(frame,panelDate,3));
	                    b4.addActionListener(new InterfataPlafar(frame,panelDate,4,t4, client));
	                    b6.addActionListener(new InterfataPlafar(frame,panelDate,5,t5,t6, f, client));
	                    afis2.addActionListener(new InterfataPlafar(frame,panelVizualizare,6,t1,t2,t3,tVal,tProd, client));
	                    panel.add(panelDate);
	                    frame.setContentPane(panel);

	                }
	                else if(rez.equalsIgnoreCase("Conectat ca si angajat farmacie"))
	                {
	                	  panelDate.removeAll();
		                    panelDate.updateUI();
		                    JLabel lTitluF=new JLabel("ANGAJAT FARMACIE");
		                    JLabel l1=new JLabel("Adaugare medicament:");
		                    JLabel l2=new JLabel("Nume:");
		                    JLabel l3=new JLabel("Pret:");
		                    JLabel l4=new JLabel("Disponibilitate:");
		                    JLabel lProducator = new JLabel("Producator:");
		                    JLabel lValabilitate = new JLabel("Valabilitate:");
		                    JLabel l5=new JLabel("Salvare rapoarte:");
		                    JLabel l6=new JLabel("Stergere medicament:");
		                    JLabel l12=new JLabel("Nume:");
		                    JLabel l7=new JLabel("Modificare disponibilitate:");
		                    JLabel l8=new JLabel("Nume:");
		                    JLabel l9=new JLabel("Disponibilitate :");
		                    JTextField t5=new JTextField();
		                    JTextField t6=new JTextField();
		                    //JButton b2=new JButton(".csv");
		                    //JButton b3=new JButton(".txt");
		                    JTextField t1=new JTextField();
		                    JTextField t2=new JTextField();
		                    JTextField t3=new JTextField();
		                    JTextField t4=new JTextField();
		                    JTextField tProd = new JTextField();
		                    JTextField tVal = new JTextField();
		                    JButton b1=new JButton("Adauga");
		                    JButton b4=new JButton("Sterge");
		                    JButton b6=new JButton("Modifica");
		                    JButton afis1 = new JButton("Afiseaza medicamentele");
		                    JButton filtru = new JButton("Disponibilitate");
		                    JButton fValabilitate = new JButton ("Valabilitate");
		                    JButton fPret = new JButton("Pret");
		                    JButton fProducator = new JButton("Producator");
		                    JTextField f = new JTextField();
		                    JLabel filtrareDupa = new JLabel("Filtreaza dupa: ");
		                    lTitluF.setBounds(225,0,200,20);
		                    l1.setBounds(0,50,200,20);
		                    b1.setBounds(150,50,100,20);
		                    l2.setBounds(50,80,200,20);
		                    l3.setBounds(50,100,200,20);
		                    l4.setBounds(50,120,200,20);
		                    lValabilitate.setBounds(50, 140, 200, 20);
		                    lProducator.setBounds(50, 160, 200, 20);
		                    b4.setBounds(150,210,100,20);
		                    t1.setBounds(150,80,100,20);
		                    t2.setBounds(150,100,100,20);
		                    t3.setBounds(150,120,100,20);
		                    tVal.setBounds(150, 140, 100, 20);
		                    tProd.setBounds(150, 160, 100, 20);
		                    l5.setBounds(0,80,200,20);
		                    //b2.setBounds(100,80,100,20);
		                    l6.setBounds(0,210,200,20);
		                    t4.setBounds(150,230,100,20);
		                    l7.setBounds(0,260,160,20);
		                    l8.setBounds(50,280,100,20);
		                    l9.setBounds(50,300,100,20);
		                    t5.setBounds(150,280,100,20);
		                    t6.setBounds(150,300,100,20); 
		                    b6.setBounds(150,330,100,20);
		                    l12.setBounds(50,230,100,20);
		                    filtrareDupa.setBounds(100, 160, 100, 20);
		                    filtru.setBounds(100, 180, 100, 20);
		                    fValabilitate.setBounds(100, 200, 100, 20);
		                    fPret.setBounds(100, 220, 100, 20);
		                    fProducator.setBounds(100, 240, 100, 20);
		                    f.setBounds(0, 160, 90, 20);
		                    afis1.setBounds(10, 20, 200, 20);
		                    panelDate.add(l1);panelDate.add(l2);panelDate.add(l3);panelDate.add(l4);
		                    panelDate.add(t1);panelDate.add(t2);panelDate.add(t3);
		                    panelVizualizare.add(l5);panelDate.add(b1);//panelVizualizare.add(b2);
		                    panelDate.add(l6);panelDate.add(t4);panelDate.add(b4);panelDate.add(t5);
		                    panelDate.add(l7);panelDate.add(l8);panelDate.add(l9);panelDate.add(t6);panelDate.add(b6);
		                    panelVizualizare.add(lTitluF);panelDate.add(lValabilitate);panelDate.add(lProducator);panelDate.add(tVal);panelDate.add(tProd);
		                    panelDate.add(afis1);panelDate.add(l12);
		                    panelVizualizare.add(filtru);
		                    panelVizualizare.add(f);
		                    panelVizualizare.add(filtrareDupa);
		                    //panelVizualizare.add(f);
		                   // panelVizualizare.add(filtru);
		                    panelVizualizare.add(fPret);
		                    panelVizualizare.add(fProducator);
		                    panelVizualizare.add(fValabilitate);
		                    b1.addActionListener(new InterfataFarmacie(frame,panelDate,1,t1,t2,t3,tVal,tProd,client));
		                    filtru.addActionListener(new InterfataFarmacie(frame,panelVizualizare,2,f,client));
		                    fValabilitate.addActionListener(new InterfataFarmacie(frame,panelVizualizare,3,f,client));
		                    fPret.addActionListener(new InterfataFarmacie(frame,panelVizualizare,7,f,client));
		                    fProducator.addActionListener(new InterfataFarmacie(frame,panelVizualizare,8,f,client));
		                    b4.addActionListener(new InterfataFarmacie(frame,panelDate,4,t4,client));
		                    b6.addActionListener(new InterfataFarmacie(frame,panelDate,5,t5,t6,client));
		                    afis1.addActionListener(new InterfataFarmacie(frame,panelVizualizare,6,t1,t2,t3,tVal,tProd,client));
		                    panel.add(panelDate);
		                    frame.setContentPane(panel);
	                }
	                else if(rez.equalsIgnoreCase("Conectat ca si admin")){
	                    panelDate.removeAll();
	                    panelDate.updateUI();
	                    panelVizualizare.removeAll();
	                    panelVizualizare.updateUI();
	                    JLabel lTitlu=new JLabel("ADMINISTRATOR");
	                    JLabel lAdaugaAngajat=new JLabel("Adauga angajat:");
	                    JLabel lNume=new JLabel("Nume:");
	                    JLabel lPrenume=new JLabel("Prenume");
	                    JLabel lVarsta=new JLabel("Varsta:");
	                    JLabel lFunctie=new JLabel("Functie:");
	                    JLabel lUser=new JLabel("Username:");
	                    JLabel lParola=new JLabel("Parola:");
	                    JLabel lStergereA=new JLabel("Sterge angajat:");
	                    JLabel lNume2=new JLabel("Username:");
	                    JLabel lModifP=new JLabel("Modificare parola angajat:");
	                    JLabel lNume3=new JLabel("Username:");
	                    JLabel lParola2=new JLabel("Parola noua:");
	                    JButton stergeB=new JButton("Sterge");
	                    JButton modificaB= new JButton("Modifica");
	                    JTextField t7=new JTextField();
	                    JTextField t8=new JTextField();
	                    JTextField t9=new JTextField();
	                    JTextField t1=new JTextField();
	                    JTextField t2=new JTextField();
	                    JTextField t3=new JTextField();
	                    JTextField t4=new JTextField();
	                    JTextField t5=new JTextField();
	                    JTextField t6=new JTextField();
	                    JButton adaugaB=new JButton("Adauga");
	                    JButton vizualizareB= new JButton("Vizualizare angajati");
	                    lTitlu.setBounds(200,0,200,20);
	                    lAdaugaAngajat.setBounds(10,50,200,20);
	                    adaugaB.setBounds(120,50,100,20);
	                    lNume.setBounds(20,70,200,20);
	                    lPrenume.setBounds(20,90,200,20);
	                    lVarsta.setBounds(20,110,200,20);
	                    lFunctie.setBounds(20,130,200,20);
	                    lUser.setBounds(20,150,200,20); 
	                    lParola.setBounds(20,170,200,20);
	                    t1.setBounds(120,70,100,20); //nume
	                    t2.setBounds(120,90,100,20); //prenume
	                    t3.setBounds(120,110,100,20); //varsta
	                    t4.setBounds(120,130,100,20); // functia
	                    t5.setBounds(120,150,100,20); // user
	                    t6.setBounds(120,170,100,20); //parola
	                    vizualizareB.setBounds(10,20,150,20);
	                    lStergereA.setBounds(10,210,100,20); 
	                    lNume2.setBounds(20,230,100,20);
	                    lModifP.setBounds(10,260,200,20); 
	                    lNume3.setBounds(20,280,100,20);
	                    lParola2.setBounds(20,300,100,20);
	                    t7.setBounds(120,230,100,20);
	                    t8.setBounds(120,280,100,20);
	                    stergeB.setBounds(120,210,100,20);
	                    modificaB.setBounds(120,330,100,20);
	                    t9.setBounds(120,300,100,20);
	                    panelDate.add(lAdaugaAngajat);
	                    panelDate.add(lNume);
	                    panelDate.add(lPrenume);
	                    panelDate.add(lVarsta);
	                    panelDate.add(lFunctie);
	                    panelDate.add(lUser);
	                    panelDate.add(lParola);
	                    panelDate.add(t1);
	                    panelDate.add(t2);
	                    panelDate.add(t3);
	                    panelDate.add(t4);
	                    panelDate.add(t5);
	                    panelDate.add(t6);
	                    panelDate.add(adaugaB);
	                    panelDate.add(vizualizareB);
	                    panelDate.add(lStergereA);panelDate.add(lNume2);panelDate.add(lModifP);panelDate.add(lNume3);panelDate.add(lParola2);panelDate.add(t7);
	                    panelDate.add(t8);panelDate.add(stergeB);panelDate.add(modificaB);panelDate.add(t9);panelVizualizare.add(lTitlu);
	                    System.out.println(t1.getText());System.out.println(t3.getText());
	                    System.out.println(t2.getText());System.out.println(t4.getText());

	                    adaugaB.addActionListener(new InterfataAdministrator(frame,panelDate,1,t1,t2,t3,t4,t5,t6,client));
	                    vizualizareB.addActionListener(new InterfataAdministrator(frame,panelVizualizare,2,client));
	                    stergeB.addActionListener(new InterfataAdministrator(frame,panelDate,3,t7,client));
	                    modificaB.addActionListener(new InterfataAdministrator(frame,panelDate,4,t8,t9,client));
	                    panel.add(panelDate);
	                    frame.setContentPane(panel);
	                }
	                else {
	                	panelDate.removeAll();
	                    JLabel l1=new JLabel("Nume sau parola incorecta! Reincercati!");
	                    l1.setBounds(10,20,300,20);
	                    panelDate.add(l1);
	                    panel.add(panelDate);
	                    frame.setContentPane(panel);
	                }
	            }
	        });
	        b2.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                panelDate.removeAll();
	                panelDate.updateUI();
	                panelVizualizare.removeAll();
	                panelVizualizare.updateUI();
	                //panelLog.remove(afis1);
	                //panelLog.remove(afis2);
	
	            }
	        });
	        
	        
	        panel.add(panelLog);
	        panel.add(panelVizualizare);
	        panel.add(panelDate);
	        frame.add( panel );
	        frame.setContentPane(panel);
	        frame.setVisible(true);
}
}

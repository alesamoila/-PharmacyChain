package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import client.Client;
import controller.ControllerAdministrator;

public class InterfataAdministrator implements ActionListener{

	JFrame frame;
    JPanel panel;
    Integer nr;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;
    JTextField t6;
    Client client;

    public InterfataAdministrator(JFrame frame, JPanel panel, Integer nr, Client client) {
        this.frame = frame;
        this.panel = panel;
        this.nr = nr;
        this.client = client;
    }
    public InterfataAdministrator(JFrame frame, JPanel panel, Integer nr, JTextField t1,JTextField t2,JTextField t3,JTextField t4,JTextField t5,JTextField t6, Client client) {
        this.frame = frame;
        this.panel = panel;
        this.nr = nr;
        this.t1=t1;this.t2=t2;this.t3=t3;this.t4=t4;this.t5=t5;this.t6=t6;
        this.client = client;
    }
    public InterfataAdministrator(JFrame frame, JPanel panel, Integer nr,JTextField t1, Client client) {
        this.frame = frame;
        this.panel = panel;
        this.nr = nr;
        this.t1=t1;
        this.client = client;
    }
    public InterfataAdministrator(JFrame frame, JPanel panel, Integer nr,JTextField t1,JTextField t2, Client client) {
        this.frame = frame;
        this.panel = panel;
        this.nr = nr;
        this.t1=t1;
        this.t2=t2;
        this.client = client;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ControllerAdministrator control = new ControllerAdministrator();
        if (nr == 2) {
            List<String> listaConturi= control.vizualizare(client);
            Object[][] data2 = new Object[15][15];
            for (int i = 0; i < listaConturi.size()-2; i=i+3) {
                data2[i / 3][0] = listaConturi.get(i);
                data2[i / 3][1] = listaConturi.get(i+2);
                data2[i / 3][2] = listaConturi.get(i+1);
                
            }
            DefaultTableModel model = new DefaultTableModel(data2, new Object[]{"USER", "PAROLA", "FUNCTIE"});
            model.fireTableDataChanged();
            JTable table = new JTable(model);
            table.validate();
            JScrollPane scroll = new JScrollPane(table);
            scroll.validate();
            scroll.setBounds(260, 80, 350, 220);
            panel.add(scroll);
            panel.setLayout(null);
        }
        else {
            if(nr==1){
           //nume, prenume, varsta, functie, username, parola
           // Utilizator u=new Utilizator(t1.getText(),t2.getText(),Integer.parseInt(t3.getText()),t4.getText());
           //ContUtilizator c1 =new ContUtilizator(u,t5.getText(),t6.getText());
           //control.adaugareContUtilizator(c1);
            List<String> lista=new ArrayList<String>();
            lista.add(t1.getText());
            lista.add(t2.getText());
            lista.add(t3.getText());
            lista.add(t4.getText());
            lista.add(t5.getText());
            lista.add(t6.getText());
               // for(String s:lista)
               //     System.out.println(s);
            control.adaugare(lista,client);
            }
            else{
                if(nr==3){
                    control.stergere(t1.getText(),client);
                }
                else{
                    control.modificare(t1.getText(),t2.getText(),client);
                }
            }

        }

    }

}

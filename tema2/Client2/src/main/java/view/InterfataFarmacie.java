package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import client.Client;
import controller.ControllerAngajatFarmacie;
import model.Medicament;

public class InterfataFarmacie implements ActionListener {
	JPanel panel;
	JFrame frame;
	Integer nr;
	JTextField t1;
	JTextField t2;
	JTextField t3;
	JTextField t4;
	JTextField t5;
	Client client;

	ArrayList<Medicament> med = new ArrayList<Medicament>();

	public InterfataFarmacie(JFrame frame, JPanel panel, Integer nr, Client client) {
		this.frame = frame;
		this.panel = panel;
		this.nr = nr;
		this.client = client;
	}

	public InterfataFarmacie(JFrame frame, JPanel panel, Integer nr, JTextField t1, JTextField t2, JTextField t3,
			Client client) {
		this.frame = frame;
		this.panel = panel;
		this.nr = nr;
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.client = client;
	}

	public InterfataFarmacie(JFrame frame, JPanel panel, Integer nr, JTextField t1, Client client) {
		this.frame = frame;
		this.panel = panel;
		this.nr = nr;
		this.t1 = t1;
		this.client = client;
	}

	public InterfataFarmacie(JFrame frame, JPanel panel, Integer nr, JTextField t1, JTextField t2, Client client) {
		this.frame = frame;
		this.panel = panel;
		this.nr = nr;
		this.t1 = t1;
		this.t2 = t2;
		this.client = client;
	}

	public InterfataFarmacie(JFrame frame, JPanel panel, Integer nr, JTextField t1, JTextField t2, JTextField t3,
			JTextField t4, JTextField t5, Client client) {
		this.frame = frame;
		this.panel = panel;
		this.nr = nr;
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
		this.t5 = t5;
		this.client = client;
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		ControllerAngajatFarmacie control = new ControllerAngajatFarmacie();
		Object[][] data = new Object[15][15];
		List<String> listaMedicamente = new ArrayList<String>();
		List<String> lF = new ArrayList<String>();
		JLabel j = new JLabel();
		if (nr == 1) {
			// nume, pret, disponibilitate, valabilitate, producator

			// Medicament med = new Medicament(t1.getText(), Float.parseFloat(t2.getText()),
			// Integer.parseInt(t3.getText()), t4.getText(), t5.getText());
			// control.adaugare(med);
			// System.out.println("medicament adaugat "+ t1.getText() + t5.getText());
			// List<String> lista=new ArrayList<String>();
			listaMedicamente.add(t1.getText());
			listaMedicamente.add(t2.getText());
			listaMedicamente.add(t3.getText());
			listaMedicamente.add(t4.getText());
			listaMedicamente.add(t5.getText());
			System.out.println(t1.getText());
			control.adaugare(listaMedicamente, client);
		}

		/*
		 * if (nr == 6) { ArrayList<Medicament> medicamente = control.vizualizare();
		 * Object[][] data2 = new Object[15][15]; for (int i = 0; i <
		 * medicamente.size(); i++) { data2[i][0] = medicamente.get(i).getNume();
		 * data2[i][1] = medicamente.get(i).getPret(); data2[i][2] =
		 * medicamente.get(i).getDisponibilitate(); data2[i][3] =
		 * medicamente.get(i).getProducator(); data2[i][4] =
		 * medicamente.get(i).getValabilitate(); // System.out.println(data2[i][0]); }
		 * DefaultTableModel model = new DefaultTableModel(data2, new Object[] { "NUME",
		 * "PRET", "DISP.", "PRODUCATOR", "VALAB." }); model.fireTableDataChanged();
		 * JTable table = new JTable(model); table.validate(); JScrollPane scroll = new
		 * JScrollPane(table); scroll.validate(); scroll.setBounds(260, 80, 350, 220);
		 * panel.add(scroll); panel.setLayout(null); }
		 */
		if (nr == 4)
			control.stergere(t1.getText(), client);
		if (nr == 5) {
			control.modificare(t1.getText(), Integer.parseInt(t2.getText()), client);

		}
		if (nr == 6) {
			List<String> listaMed = control.vizualizare(client);
			for (int i = 1; i < listaMed.size() - 1; i = i + 5) {
				data[i / 5][0] = listaMed.get(i);
				// System.out.println(listaMedicamente.get(i));
				data[i / 5][1] = listaMed.get(i + 1);
				data[i / 5][2] = listaMed.get(i + 2);
				data[i / 5][3] = listaMed.get(i + 3);
				data[i / 5][4] = listaMed.get(i + 4);
			}
			DefaultTableModel model = new DefaultTableModel(data,
					new Object[] { "Nume", "Pret", "Disp.", "Valab.", "Producator" });

			model.fireTableDataChanged();
			JTable table = new JTable(model);
			table.validate();
			JScrollPane scroll = new JScrollPane(table);
			scroll.validate();
			scroll.setBounds(260, 80, 350, 220);
			panel.add(scroll);
			panel.setLayout(null);

		}

		if (nr == 2) {
			lF = control.fD(client,t1.getText());
		}
		if (nr == 3)
			lF = control.fV(client,t1.getText());
		if (nr == 7)
			lF = control.fPret(client, t1.getText());
		if (nr == 8)
			lF = control.fProd(client,t1.getText());

		if (nr == 2 || nr == 3 || nr == 7 || nr == 8) {
            
			Object[][] data2 = new Object[15][15];
			for (int i = 1; i < lF.size() - 1; i = i + 5) {
				data2[i / 5][0] = lF.get(i);
				// System.out.println(listaMedicamente.get(i));
				data2[i / 5][1] = lF.get(i + 1);
				data2[i / 5][2] = lF.get(i + 2);
				data2[i / 5][3] = lF.get(i + 3);
				data2[i / 5][4] = lF.get(i + 4);
			}
			DefaultTableModel model2 = new DefaultTableModel(data2,
					new Object[] { "Nume", "Pret", "Disp.", "Valab.", "Producator" });

			model2.fireTableDataChanged();
			JTable table = new JTable(model2);
			table.validate();
			JScrollPane scroll = new JScrollPane(table);
			scroll.validate();
			scroll.setBounds(260, 80, 350, 220);
			panel.add(scroll);
			panel.setLayout(null);

		}

	}

}

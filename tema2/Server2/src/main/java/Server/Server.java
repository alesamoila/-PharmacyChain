package Server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import DataAccess.DateContUtilizator;
import DataAccess.DateMedicamente;
import DataAccess.DateProduseNaturiste;
import DataAccess.DateUtilizator;
import Model.ContUtilizator;
import Model.Medicament;
import Model.ProdusNaturist;
import Model.Utilizator;



public class Server {

	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream in = null;
	private DataOutputStream out = null;

	public Server(int port) {
		try {
			server = new ServerSocket(port);
			System.out.println("Server started");
			System.out.println("Waiting for a client ...");
			socket = server.accept();
			System.out.println("Client accepted");
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			System.out.println(in);
			out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			String line = "";
			while (!line.equals("0")) {
				try {
					line = in.readUTF();
					if (line.charAt(0) == '4') {
						// System.out.println("Vizualizare-Medicamente");
						ArrayList<String> lista = new ArrayList<String>();
						DateMedicamente m = new DateMedicamente();
						ArrayList<Medicament> listaMedicamente = m.vizualizare();
						for (Medicament i : listaMedicamente) {
							lista.add(i.getNume());
						    lista.add(String.valueOf(i.getPret()));
							//lista.add("");
							lista.add(String.valueOf(i.getDisponibilitate()));
							lista.add(i.getValabilitate());
							lista.add(i.getProducator());
							// System.out.println(i.getNume());
						}
						OutputStream output = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(output, true);
						writer.println(lista);
					}

					if (line.charAt(0) == 'e') {
						// System.out.println("Vizualizare produse naturiste");
						ArrayList<String> lista = new ArrayList<String>();
						DateProduseNaturiste m = new DateProduseNaturiste();
						ArrayList<ProdusNaturist> listaMedicamente = m.vizualizare();
						for (ProdusNaturist i : listaMedicamente) {
							lista.add(i.getNume());
							 lista.add(String.valueOf(i.getPret()));
							//lista.add("");
							lista.add(String.valueOf(i.getDisponibilitate()));
							lista.add(i.getValabilitate());
							lista.add(i.getProducator());
							// System.out.println(i.getNume());
						}
						OutputStream output = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(output, true);
						writer.println(lista);
					}


					else if (line.charAt(0) == '3') {
						//System.out.println("Vizualizare-Angajati");
						ArrayList<String> lista = new ArrayList<String>();
						DateContUtilizator c = new DateContUtilizator();
						ArrayList<ContUtilizator> listaConturi = c.vizualizare();
						for (ContUtilizator i : listaConturi) {
							lista.add(i.getFunctia());
							lista.add(i.getUsername());
							lista.add(i.getParola());
							//System.out.println(i.getFunctia() + " " + i.getUsername() + " " + i.getParola());
							
						}
						OutputStream output = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(output, true);
						writer.println(lista);

					} 
					
					else if (line.charAt(0) == '5') {
						System.out.println("Adaugare-Angajati");
						DateContUtilizator c = new DateContUtilizator();
						DateUtilizator u = new DateUtilizator();
						String[] arr = line.split(" ");
						List<String> al = Arrays.asList(arr);
						//System.out.println(al.get(1) + " " + al.get(2) + " " + al.get(3) + " " + 
						//al.get(4) + " " + al.get(5) + "  " + al.get(6));
						c.adaugare(new ContUtilizator(al.get(4), al.get(5), al.get(6)));
						u.adaugareUtilizator(
								new Utilizator(al.get(1), al.get(2), Integer.parseInt(al.get(3)), al.get(4)));

						OutputStream output = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(output, true);
						writer.println("done");
				
					} else if (line.charAt(0) == '6') {
						System.out.println("Stergere-Angajati");
						DateContUtilizator c = new DateContUtilizator();
						String user = line.substring(2);
						c.stergere(user);

						OutputStream output = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(output, true);
						writer.println("done");
					
					} else if (line.charAt(0) == 'z') {
						System.out.println("Modificare-Angajati");
						DateContUtilizator c = new DateContUtilizator();
						String[] arr = line.split(" ");
						List<String> al = Arrays.asList(arr);
						c.modificare(al.get(1), al.get(2));
						OutputStream output = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(output, true);
						writer.println("done");
					}

					else if (line.charAt(0) == '7') {
						// System.out.println("Adaugare medicament");
						DateMedicamente p = new DateMedicamente();
						String[] arr = line.split(" ");
						List<String> al = Arrays.asList(arr);
						p.adaugare(new Medicament(al.get(1), Double.parseDouble(al.get(2)), Integer.parseInt(al.get(3)),
								al.get(4), al.get(5)));
						OutputStream output = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(output, true);
						writer.println("done");
					}

					else if (line.charAt(0) == '8') {
						// System.out.println("Stergere medicament");
						DateMedicamente p = new DateMedicamente();
						String denumire = line.substring(2);
						p.sterge(denumire);
						OutputStream output = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(output, true);
						writer.println("done");
					
					} else if (line.charAt(0) == '9') {
						// System.out.println("Modificare cantitate");
						DateMedicamente p = new DateMedicamente();
						String[] arr = line.split(" ");
						List<String> al = Arrays.asList(arr);
						p.modificare(al.get(1), al.get(2));
						OutputStream output = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(output, true);
						writer.println("done");
					}

					else if (line.charAt(0) == 'a') {

						DateProduseNaturiste p = new DateProduseNaturiste();
						String[] arr = line.split(" ");
						List<String> al = Arrays.asList(arr);
						p.adaugare(new ProdusNaturist(al.get(1), Double.parseDouble(al.get(2)),
								Integer.parseInt(al.get(3)), al.get(4), al.get(5)));
						OutputStream output = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(output, true);
						writer.println("done");
					}

					else if (line.charAt(0) == 'b') {
						// System.out.println("Stergere produs naturist");
						DateProduseNaturiste p = new DateProduseNaturiste();
						String denumire = line.substring(2);
						p.sterge(denumire);
						OutputStream output = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(output, true);
						writer.println("done");
					
					
					} else if (line.charAt(0) == 'c') {
						// System.out.println("Modificare cantitate");
						DateProduseNaturiste p = new DateProduseNaturiste();
						String[] arr = line.split(" ");
						List<String> al = Arrays.asList(arr);
						p.modificare(al.get(1), al.get(2));
						OutputStream output = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(output, true);
						writer.println("done");
					}
					
					else  if(line.charAt(0)=='f') {
                        System.out.println("Filtrare");
                        ArrayList<String> lista=new ArrayList<String>();
                        DateMedicamente p=new DateMedicamente();
                        String criteriu=line.substring(2);
                        System.out.println(criteriu);
                        ArrayList<Medicament> listaMedicamente=p.fDisponibilitate(criteriu);
                        for (Medicament i : listaMedicamente) {
							lista.add(i.getNume());
							 lista.add(String.valueOf(i.getPret()));
							//lista.add("");
							lista.add(String.valueOf(i.getDisponibilitate()));
							lista.add(i.getValabilitate());
							lista.add(i.getProducator());
                        }
                        OutputStream output = socket.getOutputStream();
                        PrintWriter writer = new PrintWriter(output, true);
                        writer.println(lista);
                    }
					
					else  if(line.charAt(0)=='g') {
                        System.out.println("Filtrare");
                        ArrayList<String> lista=new ArrayList<String>();
                        DateMedicamente p=new DateMedicamente();
                        String criteriu=line.substring(2);
                        ArrayList<Medicament> listaMedicamente=p.fValabilitate(criteriu);
                        for (Medicament i : listaMedicamente) {
							lista.add(i.getNume());
							 lista.add(String.valueOf(i.getPret()));
							//lista.add("");
							lista.add(String.valueOf(i.getDisponibilitate()));
							lista.add(i.getValabilitate());
							lista.add(i.getProducator());
                        }
                        OutputStream output = socket.getOutputStream();
                        PrintWriter writer = new PrintWriter(output, true);
                        writer.println(lista);
                    }
					
					else  if(line.charAt(0)=='h') {
                        System.out.println("Filtrare");
                        ArrayList<String> lista=new ArrayList<String>();
                        DateMedicamente p=new DateMedicamente();
                        String criteriu=line.substring(2);
                        ArrayList<Medicament> listaMedicamente=p.fPret(criteriu);
                        for (Medicament i : listaMedicamente) {
							lista.add(i.getNume());
							 lista.add(String.valueOf(i.getPret()));
							//lista.add("");
							lista.add(String.valueOf(i.getDisponibilitate()));
							lista.add(i.getValabilitate());
							lista.add(i.getProducator());
                        }
                        OutputStream output = socket.getOutputStream();
                        PrintWriter writer = new PrintWriter(output, true);
                        writer.println(lista);
                    }
					
					else  if(line.charAt(0)=='i') {
                        System.out.println("Filtrare");
                        ArrayList<String> lista=new ArrayList<String>();
                        DateMedicamente p=new DateMedicamente();
                        String criteriu=line.substring(2);
                        ArrayList<Medicament> listaMedicamente=p.fProducator(criteriu);
                        for (Medicament i : listaMedicamente) {
							lista.add(i.getNume());
							 lista.add(String.valueOf(i.getPret()));
							//lista.add("");
							lista.add(String.valueOf(i.getDisponibilitate()));
							lista.add(i.getValabilitate());
							lista.add(i.getProducator());
                        }
                        OutputStream output = socket.getOutputStream();
                        PrintWriter writer = new PrintWriter(output, true);
                        writer.println(lista);
                    }

					
					else  if(line.charAt(0)=='j') {
                        System.out.println("Filtrare");
                        ArrayList<String> lista=new ArrayList<String>();
                        DateProduseNaturiste p=new DateProduseNaturiste();
                        String criteriu=line.substring(2);
                        System.out.println(criteriu);
                        ArrayList<ProdusNaturist> listaMedicamente=p.fDisponibilitate(criteriu);
                        for (ProdusNaturist i : listaMedicamente) {
							lista.add(i.getNume());
							 lista.add(String.valueOf(i.getPret()));
							//lista.add("");
							lista.add(String.valueOf(i.getDisponibilitate()));
							lista.add(i.getValabilitate());
							lista.add(i.getProducator());
                        }
                        OutputStream output = socket.getOutputStream();
                        PrintWriter writer = new PrintWriter(output, true);
                        writer.println(lista);
                    }
					
					else  if(line.charAt(0)=='k') {
                        System.out.println("Filtrare");
                        ArrayList<String> lista=new ArrayList<String>();
                        DateProduseNaturiste p=new DateProduseNaturiste();
                        String criteriu=line.substring(2);
                        ArrayList<ProdusNaturist> listaMedicamente=p.fValabilitate(criteriu);
                        for (ProdusNaturist i : listaMedicamente) {
							lista.add(i.getNume());
							 lista.add(String.valueOf(i.getPret()));
							//lista.add("");
							lista.add(String.valueOf(i.getDisponibilitate()));
							lista.add(i.getValabilitate());
							lista.add(i.getProducator());
                        }
                        OutputStream output = socket.getOutputStream();
                        PrintWriter writer = new PrintWriter(output, true);
                        writer.println(lista);
                    }
					
					else  if(line.charAt(0)=='l') {
                        System.out.println("Filtrare");
                        ArrayList<String> lista=new ArrayList<String>();
                        DateProduseNaturiste p=new DateProduseNaturiste();
                        String criteriu=line.substring(2);
                        ArrayList<ProdusNaturist> listaMedicamente=p.fPret(criteriu);
                        for (ProdusNaturist i : listaMedicamente) {
							lista.add(i.getNume());
							 lista.add(String.valueOf(i.getPret()));
							//lista.add("");
							lista.add(String.valueOf(i.getDisponibilitate()));
							lista.add(i.getValabilitate());
							lista.add(i.getProducator());
                        }
                        OutputStream output = socket.getOutputStream();
                        PrintWriter writer = new PrintWriter(output, true);
                        writer.println(lista);
                    }
					
					else  if(line.charAt(0)=='m') {
                        System.out.println("Filtrare");
                        ArrayList<String> lista=new ArrayList<String>();
                        DateProduseNaturiste p=new DateProduseNaturiste();
                        String criteriu=line.substring(2);
                        ArrayList<ProdusNaturist> listaMedicamente=p.fProducator(criteriu);
                        for (ProdusNaturist i : listaMedicamente) {
							lista.add(i.getNume());
							 lista.add(String.valueOf(i.getPret()));
							//lista.add("");
							lista.add(String.valueOf(i.getDisponibilitate()));
							lista.add(i.getValabilitate());
							lista.add(i.getProducator());
                        }
                        OutputStream output = socket.getOutputStream();
                        PrintWriter writer = new PrintWriter(output, true);
                        writer.println(lista);
                    }

				} catch (Exception i) {
					System.out.println(i);
				}
			}
			System.out.println("Closing connection");
			socket.close();
			in.close();
		} catch (IOException i) {
			System.out.println(i);
		}
	}

	public static String config(String path) {
		File configFile = new File(path);
		String port = "";
		try {
			FileReader reader = new FileReader(configFile);
			Properties props = new Properties();
			props.load(reader);
			port = props.getProperty("port");
			reader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("file does not exist");
		} catch (IOException ex) {
			System.out.println("I/O error");
		}
		return port;
	}

	public static void main(String args[]) {
		String port = config("config.properties");
		Server server = new Server(Integer.parseInt(port));
	}
}
package client;
import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Client
{

    private Socket socket            = null;
    private DataInputStream  input   = null;
    private DataOutputStream out     = null;

    public void connect(String address, int port) {
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");

            input  = new DataInputStream(System.in);

            out    = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

    }
    public void close(){
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    public List<String> transform(String init){
        String interm = init.replace("[",",");
        String fin= interm.replace("]",",");
        fin=fin.replaceAll("\\s+","");
        String str[] = fin.split(",");
        List<String> al =  Arrays.asList(str);
        return al;
    } 
    public String demand(String line,String s){
        String rez = "";
        try
        {
            if(!line.equals("0")) {
                if(s.equals("\n")) {
                    out.writeUTF(line);
                }
                else{
                    out.writeUTF(line+" "+s);
                }
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                rez = reader.readLine();
            }
            else{
                out.writeUTF(line);
                System.out.println("Closing connection");
            }
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
        return rez;
    }

}
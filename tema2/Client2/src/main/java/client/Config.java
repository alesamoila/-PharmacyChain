package client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public String config(String path, int n){
        File configFile = new File(path);
        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
            if(n==1){
                String port = props.getProperty("port");
                reader.close();
                return port;
            }
            else{
                String ip = props.getProperty("ip");
                reader.close();
                return ip;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file does not exist");
        } catch (IOException ex) {
            System.out.println("I/O error");
        }
        return "";
    }
}

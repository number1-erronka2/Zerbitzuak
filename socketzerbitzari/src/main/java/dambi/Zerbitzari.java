package dambi;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Zerbitzari {
    private static InputStream inputStream = null;
    private static ObjectInputStream objectInputStream = null;
    public static void main(String[] args) throws IOException {
        
        ServerSocket zerbitzaria = new ServerSocket(6006);
        System.out.println("Zerbitzaria martxan dago 6006 portuan entzuten");
        System.out.println("----------------------------------------------");
        while (true) {
            Socket erabiltzailea = zerbitzaria.accept(); //Zerbitzaria erabiltzaileari itxaroten
            System.out.println(erabiltzailea + " konektatua.");
    
            // input-a hartu socket-etik
            try{
                inputStream = erabiltzailea.getInputStream();
                objectInputStream = new ObjectInputStream(inputStream);
    
                HariaServer haria = new HariaServer(erabiltzailea, objectInputStream);
                haria.start();
            } catch(Exception e){
                System.out.println(e);
            }
            
        }
    }
}

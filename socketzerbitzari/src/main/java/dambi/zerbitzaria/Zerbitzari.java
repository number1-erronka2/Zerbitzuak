<<<<<<< HEAD:socketzerbitzari/src/main/java/dambi/Zerbitzari.java
package dambi;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
=======
package zerbitzaria;
import java.io.*;
>>>>>>> ed4792831fc3caf047a1e83e46ea16079e8f17be:socketzerbitzari/src/main/java/dambi/zerbitzaria/Zerbitzari.java
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
<<<<<<< HEAD:socketzerbitzari/src/main/java/dambi/Zerbitzari.java
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
   
=======
	    try{
            inputStream = erabiltzailea.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);

            HariaServer haria = new HariaServer(erabiltzailea, objectInputStream);
            haria.start();
		}
		catch(Exception e){
			System.out.println(e);
        }
        }
    }
>>>>>>> ed4792831fc3caf047a1e83e46ea16079e8f17be:socketzerbitzari/src/main/java/dambi/zerbitzaria/Zerbitzari.java
}


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;

    public static void main(String[] args) throws IOException, Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Zerbitzaria martxan dago 5000 portuan entzuten");
        System.out.println("----------------------------------------------");
        while (true) {
            Socket bezeroa = serverSocket.accept();
            System.out.println(bezeroa + " konektatua.");

            dataInputStream = new DataInputStream(bezeroa.getInputStream());
            dataOutputStream = new DataOutputStream(bezeroa.getOutputStream());

            ThreadServer haria = new ThreadServer(bezeroa, dataInputStream, dataOutputStream);            //Haria sortu
            haria.start(); 
        }
    } 
}
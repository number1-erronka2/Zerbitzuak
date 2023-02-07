
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Erabiltzailea {

    private static List<Partida> partidak;
    private static SQLiteConnection connection;
    private static OutputStream outputStream;
    private static ObjectOutputStream objectOutputStream;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try ( Socket socket = new Socket("192.168.65.123", 6006)) {
            // Partiden lista sortu
            partidak = new ArrayList<>();
            connection = new SQLiteConnection();
            partidak = connection.getPartidak();

            // Zerbitzariari lista bidaltzeko output-a
            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);

            //Bidali zerbitzariari list-a
            objectOutputStream.writeObject(partidak);
            System.out.println("Bidalita");

            outputStream.close();
            objectOutputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HariaServer extends Thread {

    private static ObjectInputStream fSarrera;
    private static Socket socket = null;
    private static PostgresConnection postgresConnection;

    public HariaServer(Socket s, ObjectInputStream ois) throws IOException {
        this.socket = s;
        this.fSarrera = ois;
    }

    public void run() {
        try {
            insertData();
        } catch (Exception ex) {
            Logger.getLogger("Error inserting data to Postgresql");
        }
    }

    private static void insertData() {
        String langilea;
        Float puntuazioa;
        Date data;
        try {
            postgresConnection = new PostgresConnection();
            List<Partida> partidaZerrenda = (List<Partida>) fSarrera.readObject();

            for (Partida partida : partidaZerrenda) {
                langilea = partida.getLangilea();
                puntuazioa = partida.getPuntuazioa();
                data = partida.getData();
                postgresConnection.insertPartida(langilea, puntuazioa, data);
            }

            //closes
            System.out.println("\t" + socket + " bukatu du.");
            fSarrera.close();
            socket.close();
        } catch (Exception ex) {
            Logger.getLogger(HariaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

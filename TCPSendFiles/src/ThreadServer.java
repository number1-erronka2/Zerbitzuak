
/**
 *
 * @author Markel
 */
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadServer extends Thread {

    private static DataInputStream fSarrera;
    private static DataOutputStream fIrteera;
    private static Socket socket = null;

    public ThreadServer(Socket s, DataInputStream dis, DataOutputStream dos) throws IOException {
        this.socket = s;
        this.fIrteera = dos;
        this.fSarrera = dis;
    }

    public void run() {
        try {
            receiveFile("C:\\Users\\lomana.markel\\Desktop\\ReceivedFile.pdf");
            fIrteera.close();
            fSarrera.close();
            socket.close();
            System.out.println(socket + " -aren deskonekxioa.");
        } catch (Exception ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void receiveFile(String fileName) throws Exception {
        int bytes = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        long size = fSarrera.readLong();     // read file size
        byte[] buffer = new byte[4 * 1024];
        while (size > 0 && (bytes = fSarrera.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
            fileOutputStream.write(buffer, 0, bytes);
            size -= bytes;      // read upto file size
        }
        System.out.println("\t" + socket + " bidali du fitxategia.");
        fileOutputStream.close();
    }
}

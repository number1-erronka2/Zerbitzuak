package dambi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteConnection {
    public List<Partida> partidak = new ArrayList<>();

    private Connection connect() throws ClassNotFoundException  {
        String url = "jdbc:sqlite:C:/Users/lomana.markel/Documents/ERRONKA2/Multimedia/JokoaTaldeErronka/Db/jolasaDB.db";
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            //DriverManager.registerDriver(new org.sqlite.JDBC());
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public List<Partida> getPartidak() throws ClassNotFoundException  {
        String sql = "SELECT * FROM Partida;";
        try{  
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Partida newPartida = new Partida();
                newPartida.setLangilea(rs.getString(2));
                newPartida.setPuntuazioa(rs.getFloat(3));
                newPartida.setData(rs.getTimestamp(4));
                partidak.add(newPartida);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return partidak;
    }
}

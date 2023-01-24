
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class PostgresConnection {

    private final String host = "192.168.65.123";
    private final String port = "5432";
    private final String database = "erronka2";
    private final String user = "admin";
    private final String password = "admin";

    private Connection connect() throws ClassNotFoundException {

        String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (java.sql.SQLException ex) {
            System.out.println("Errorea PostgreSQLko datu basearekin konektatzean: " + ex);
        }
        return connection;
    }

    public void insertPartida(String langilea, Float puntuazioa, Date data) throws ClassNotFoundException {
        
        String sql = "INSERT INTO partida (puntuazioa, erabiltzailea, data) select ?,?,? where not exists (SELECT erabiltzailea  FROM partida WHERE data=?);";
        //String sql = "INSERT INTO partida (puntuazioa, erabiltzailea, data) VALUES (?,?,?)";
        java.sql.Timestamp timestamp = new java.sql.Timestamp(data.getTime());
        try {
            Connection conn = this.connect();
            if (conn == null) {
                System.out.println("Ez dago konexiorik datu basearekin.");
            } else {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setFloat(1, puntuazioa);
                pstmt.setString(2, langilea);
                pstmt.setTimestamp(3, timestamp);
                pstmt.setTimestamp(4, timestamp);
                pstmt.executeQuery();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

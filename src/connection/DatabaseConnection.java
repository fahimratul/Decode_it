package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static DatabaseConnection instance;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection con;
    public Statement st;
    public void Connuser(){
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/decodeit_userinfo","root","LongLive@1");
            st=con.createStatement();
        }
        catch (Exception e){

        }
    }

    public void close(AutoCloseable... close) throws SQLException {
        try {
            for (AutoCloseable c : close) {
                if (c != null) {
                    c.close();
                }
            }
        } catch (Exception e) {
            throw new SQLException("Error on closing");
        }
    }
}
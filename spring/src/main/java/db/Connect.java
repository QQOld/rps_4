package db;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static java.sql.Connection getConn() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/volorg?user=qq2";
        return DriverManager.getConnection(url);
    }

    public static void initConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch(Exception ex){
            System.out.println("Connection failed...");
        }

    }
}

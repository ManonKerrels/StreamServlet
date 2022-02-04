package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/produitdb";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException { //on récupère la connection
        Class.forName("com.mysql.cj.jdbc.Driver"); //étape pas nécessaire, juste prévention
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        getConnection();
    }


}

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todoApp?characterEncoding=utf8";
    public static final String USER = "root";
    public static final String PASS = "nao esqueça o where";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);         
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
 
    }

    public static void closeConnection(Connection connection) {
        try {

            if (connection != null) {
                connection.close();
            }

        } catch (Exception exception) {
            throw new RuntimeException("Erro ao fechar a conexão: " + exception);
        }

    }

    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {

            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }

        } catch (Exception exception) {
            throw new RuntimeException("Erro ao fechar a conexão: " + exception);
        }

    }
    
     public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {

            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }
            
             if (resultSet != null) {
                resultSet.close();
            }

        } catch (Exception exception) {
            throw new RuntimeException("Erro ao fechar a conexão: " + exception);
        }
    }
}

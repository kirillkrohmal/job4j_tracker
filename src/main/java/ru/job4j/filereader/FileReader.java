package ru.job4j.filereader;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FileReader {
    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = getConnection()) {
            System.out.println("Connection to Postgres SQL succesfull!");
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

    private static Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();
        try (InputStream in = FileReader.class.getClassLoader().getResourceAsStream("app.properties")) {
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
}









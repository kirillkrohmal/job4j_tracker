package ru.job4j.retrievesdata;

import java.sql.*;

public class RetrievesData {
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/java_a_from_z";
    static final String USER = "postgres";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT id, key, name, creat, description FROM trackersql";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                String key = rs.getString("key");
                String name = rs.getString("name");
                Long creat = rs.getLong("creat");
                String description = rs.getString("description");

                System.out.print("ID: " + id);
                System.out.print(", Key: " + key);
                System.out.print(", Name: " + name);
                System.out.println(", Creat: " + creat);
                System.out.println(", Description: " + description);
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}

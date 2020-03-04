package ru.job4j.filtersql;


import java.sql.*;

/**
 * Created by Comp on 31.10.2017.
 */
public class FilterSql {
    //private static final Logger log = LoggerFactory.getLogger(FilterSql.class);

    public static void main(String[] args) throws SQLException,
            ClassNotFoundException {
        String dbUrl = "jdbc:postgresql://127.0.0.1:5432/java_a_from_z";
        String user = "postgres";
        String password = "root";
        DriverManager.registerDriver(new org.postgresql.Driver());
        // Загружаем драйвер (регистрирует себя)
        Connection c = null;

        try {
            c = DriverManager.getConnection(dbUrl, user, password);
            PreparedStatement ps = c.prepareStatement("SELECT * FROM items AS i WHERE i.description LIKE '%DIT%'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("%s %s %s %s", rs.getString("login"), rs.getString("password"), rs.getTimestamp("create_date")));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
            }
        }
    }
}

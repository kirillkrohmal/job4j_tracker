package ru.job4j.integrationsql;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Comp on 12.06.2017.
 */
public class IntegrationSQL implements ITracker, AutoCloseable {
    private int size = 0;
    private Connection connection;


    public IntegrationSQL(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Item add(Item item) {
        String s1 = "INSERT INTO trackersql(name, description) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(s1)) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void replace(String id, Item item) {
        String s1 = "INSERT INTO trackersql(id, name, description) VALUES (?, ?, ?) WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(s1)) {
            if (id != null) {

                statement.setString(1, item.getId());
                statement.setString(2, item.getName());
                statement.setString(3, item.getDescription());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String s = "DELETE FROM trackersql WHERE trackersql.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(s)) {
            statement.setInt(1, Integer.valueOf(id));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Item newItem) {
        Long nextId = null;
        String s = "UPDATE trackersql SET id = ?, name = ?, description = ?)";

        try (PreparedStatement statement = connection.prepareStatement(s)) {
            if (nextId != null) {

                statement.setLong(1, nextId);
                statement.setString(2, newItem.getName());
                statement.setString(3, newItem.getDescription());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Item[] findByName(String name) throws SQLException {
        List<Item> items = new ArrayList<>();
        ResultSet resultSet;
        String s = "SELECT * FROM trackersql WHERE trackersql.name = ?";

        try (PreparedStatement statement = connection.prepareStatement(s)) {
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Item item = new Item();

                item.setId(resultSet.getString("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                items.add(item);
            }
        }
        return items.toArray(new Item[0]);
    }

    @Override
    public Item findById(String id) {
        Item item = new Item();
        String s = "SELECT * FROM trackersql WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(s)) {
            statement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                item.setId(resultSet.getString("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public Item[] findAll() {
        List<Item> items = new ArrayList<>();

        String s = "SELECT * FROM trackersql";

        try (PreparedStatement statement = connection.prepareStatement(s)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getString("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                items.add(item);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return items.toArray(new Item[0]);
    }

    public Connection init() throws SQLException {
        Properties config = new Properties();

        try (InputStream in = IntegrationSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(in);
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

        String url = config.getProperty("url");
        String username = config.getProperty("username");
        String password = config.getProperty("password");

        this.connection = DriverManager.getConnection(url, username, password);

        return connection;
    }

    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}

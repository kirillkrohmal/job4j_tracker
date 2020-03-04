package ru.job4j.trackersql2;

import java.io.InputStream;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.DataFormatException;

/**
 * Created by Comp on 12.06.2017.
 */
public class TrackerSQL implements ITracker, AutoCloseable {
    private int size = 0;
    private static Connection connection;


    public void replace(String id, Item item) {
        try (Connection connection = init()) {
            if (id != null) {
                String s1 = "INSERT INTO trackersql(id, key, name, creat, description) VALUES (?, ?, ?, ?, ?) WHERE id=?";
                PreparedStatement statement = connection.prepareStatement(s1);

                statement.setString(1, id);
                statement.setString(2, item.getKey());
                statement.setString(3, item.getName());
                statement.setLong(4, item.getCreated());
                statement.setString(5, item.getDescription());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(String id) {
        try (Connection connection = init()) {
            String s = "DELETE FROM trackersql WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(s);
            statement.setInt(1, Integer.valueOf(id));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void update(Item newItem) {
        Long nextId = null;

        try (Connection connection = init()) {
            if (nextId != null) {
                String s = "UPDATE trackersql SET id = ?, key = ?, name = ?, creat = ?, description = ?) WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(s);
                statement.setLong(1, nextId);
                statement.setString(2, newItem.getKey());
                statement.setString(3, newItem.getName());
                statement.setLong(4, newItem.getCreat());
                statement.setString(5, newItem.getDescription());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Item[] findByName(String name) throws SQLException {
        Item[] result = null;


        try (Connection connection = init()) {
            String s = "SELECT id=?, key=?, name=?, creat=?, description=? FROM trackersql WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(s);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Item item = new Item();

                item.setId(resultSet.getString("id"));
                item.setKey(resultSet.getString("key"));
                item.setName(resultSet.getString("name"));
                item.setCreat(resultSet.getLong("creat"));
                item.setDescription(resultSet.getString("description"));

                for (int i = 0; i < size; i++) {
                    result[i] = item;
                }
            }
        }
        return result;
    }


    public Item findById(String id) {
        Item result = null;

        String s = "SELECT id, key, name, creat, description FROM trackersql WHERE id = '" + id + "'";

        try (PreparedStatement statement = connection.prepareStatement(s)) {

            statement.setString(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    public Item[] findAll() {
        Item[] items = new Item[size];

        try (Connection connection = init()) {
            String s = "SELECT id, key, name, creat, description FROM trackersql";
            PreparedStatement statement = connection.prepareStatement(s);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getString("id"));
                item.setKey(resultSet.getString("key"));
                item.setName(resultSet.getString("name"));
                item.setCreat(resultSet.getLong("creat"));
                item.setDescription(resultSet.getString("description"));

                for (int i = 0; i < size; i++) {
                    items[i] = item;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return items;
    }

    public Connection init() throws SQLException {
        Properties config = new Properties();

        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
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

    public static void main(String[] args) throws SQLException, DataFormatException {

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TrackerSQL trackerSQL = new TrackerSQL();
        Item item1 = new Item("1", "1", "test1", 1, "test1");
        Item item2 = new Item("2", "2", "test2", 2, "test2");
        Item item3 = new Item("3", "3", "test3", 3, "test3");
        trackerSQL.init();
        String name = "test1";

        //trackerSQL.add(item1);
        //trackerSQL.update(item2);
        //trackerSQL.replace(item1.getId(), item3);
        //trackerSQL.delete(item1.getId());
        System.out.println(trackerSQL.findById(item1.getId()));
        //System.out.println(Arrays.toString(trackerSQL.findByName(name)));
        //System.out.println(trackerSQL.findAll());
    }

    public Item add(Item item) {

        String s1 = "INSERT INTO trackersql(key, name, creat, description) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(s1)) {
            statement.setString(1, item.getKey());
            statement.setString(2, item.getName());
            statement.setLong(3, item.getCreated());
            statement.setString(4, item.getDescription());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }


    public void close() throws Exception {
        connection.close();
    }
}

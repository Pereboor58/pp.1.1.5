package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.codehaus.plexus.component.annotations.Component;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl extends Util implements UserDao {
//    Connection connection = getConnection();
//    Statement statement = connection.createStatement();


    public UserDaoJDBCImpl() throws SQLException {

    }

    public void createUsersTable() throws SQLException {
//        statement.executeUpdate("CREATE TABLE IF NOT EXISTS users " +
//                "(id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
//                "name VARCHAR(25) NOT NULL," +
//                "lastname VARCHAR(25) NOT NULL," +
//                "age TINYINT NOT NULL);");

    }

    public void dropUsersTable() {
//        try {
//            statement.executeUpdate("drop table if exists users");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void saveUser(String name, String lastName, byte age) {
//        String sql = "INSERT INTO users(name, lastname, age) VALUES (?,?,?)";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void removeUserById(long id) {
//        try (PreparedStatement pstm = connection.prepareStatement("DELETE FROM users WHERE id = ?")) {
//            pstm.setLong(1, id);
//            pstm.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<>();
//        try (ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM users")) {
//            while (resultSet.next()) {
//                User user = new User(resultSet.getString("name"),
//                        resultSet.getString("lastname"), resultSet.getByte("age"));
//                user.setId(resultSet.getLong("id"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        return null;
    }

    public void cleanUsersTable() {
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate("TRUNCATE TABLE users");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}

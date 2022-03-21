package dao;

import beans.User;
import db.Connect;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component
public class UserDAO {
    public static User getUser(int id) {
        User user = new User();
        try (Connection conn = Connect.getConn()) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Users WHERE Id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("Id"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                user.setAge(resultSet.getInt("Age"));
                user.setSex(resultSet.getString("Sex"));
                user.setPhone(resultSet.getString("Phone"));
                user.setRegdate(resultSet.getString("RegDate"));
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public static ArrayList<User> getAllUsers() {
        ArrayList<User> Users = new ArrayList<User>();
        try (Connection conn = Connect.getConn()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("Id"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                user.setAge(resultSet.getInt("Age"));
                user.setSex(resultSet.getString("Sex"));
                user.setPhone(resultSet.getString("Phone"));
                user.setRegdate(resultSet.getString("RegDate"));
                Users.add(user);
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Users;
    }

    public static void update(User user) {
        try (Connection conn = Connect.getConn()) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE Users SET FirstName = ?, LastName = ?, Age = ?, Sex = ?, Phone = ? WHERE id = ?");
            preparedStatement.setInt(6, user.getId());
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getSex());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void delete(User user) {
        try (Connection conn = Connect.getConn()) {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Users WHERE id = ?");
            preparedStatement.setInt(1, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void insert(User user) {
        try (Connection conn = Connect.getConn()) {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Users (Age, Sex, FirstName, LastName, Phone) Values (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, user.getAge());
            preparedStatement.setString(2, user.getSex());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getPhone());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

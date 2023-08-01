package service;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    Connection connection = ConnectionToMySQL.getConnection();

    public UserService() {
    }

    public void addUser(User user) {
        String sql = "insert into user(userId, name, password, role) value (?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkUser(String username, String password) {
        String sql = "select * from user where name = ? and password = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username );
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public int getIdUser(String username, String password) {
//        for (User user : users) {
//            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
//                return user.getUserId();
//            }
//        }
        return -1;
    }

//    public User findUserById() {
//
//    }
}

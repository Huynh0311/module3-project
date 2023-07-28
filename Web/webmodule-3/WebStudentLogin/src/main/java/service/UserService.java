package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(1, "Linh", "1", "user"));
        users.add(new User(2, "Nguyen", "2", "user"));
    }
}

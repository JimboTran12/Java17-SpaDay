package org.launchcode.data;

import org.launchcode.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    static List<User> users = new ArrayList<User>();

    public static void add(User user) {
        users.add(user);
    }

    public static List<User> getAll() {
        return users;
    }

    public User getByID (int ID) {
        for(User user : users) {
            if (user.getID() == ID) {
                return user;
            }
        }
        return null;
    }
}

package com.varkovich.lesson_25.storage;

import com.varkovich.lesson_25.model.User;

import java.util.HashMap;
import java.util.Map;

public class MockStorage {

    private static Map<User, String> dataBase;

    static {
        dataBase = new HashMap<>();
        dataBase.put(new User("admin", "admin"), "ADMIN");
        dataBase.put(new User("user", "user"), "USER");
    }

    public static boolean doesUserExist(String password, String login) {
        if (dataBase != null && dataBase.containsKey(new User(login, password))) {
            return true;
        } else {
            return false;
        }
    }

    public static String getRole(String password, String login) {
        if (dataBase != null && dataBase.containsKey(new User(login, password))) {
            return dataBase.get(new User(login, password));
        } else {
            return null;
        }
    }

}

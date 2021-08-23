package ru.sbt.app.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private String name;
    private static volatile List<User> users = Collections.synchronizedList(new ArrayList<User>());


    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void addUser(User user){
        users.add(user);
    }
    public static List<User> getUsers (){
        return users;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

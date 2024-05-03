package com.example.gym;

public class data {
   private static String username="default";

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        data.username = username;
    }
}

package com.example.gym;

public class data {
   private static String username="default";
   private static boolean IamAdmin=false;

    public static String getUsername() {
        return username;
    }
    public static void setUsername(String username) {
        data.username = username;
    }
    public static void setIamAdmin(boolean a) {
        data.IamAdmin = a;
    }
    public static boolean getIamAdmin() {
        return IamAdmin;
    }
}

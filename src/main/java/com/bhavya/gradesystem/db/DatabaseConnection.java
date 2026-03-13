package com.bhavya.gradesystem.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static final String url = "jdbc:sqlite:grades.db";

    public static Connection connect(){
        try{
            return DriverManager.getConnection(url);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

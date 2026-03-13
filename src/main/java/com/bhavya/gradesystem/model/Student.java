package com.bhavya.gradesystem.model;

public class Student {
    private int id;
    private String name;
    private String email;
    private String major;

    public Student() {};

    public Student(String name, String email, String major){
        this.name = name;
        this.email = email;
        this.major = major;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getMajor(){
        return major;
    }
}

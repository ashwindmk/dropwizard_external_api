package com.ashwin.java.domain.model;

public class User {
    String firstname;
    String lastname;
    int age;
    int extra;

    public User() { }

    public User(String firstname, String lastname, int age, int extra) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.extra = extra;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}

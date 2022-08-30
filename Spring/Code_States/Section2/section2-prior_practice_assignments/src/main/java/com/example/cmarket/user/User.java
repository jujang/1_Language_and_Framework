package com.example.cmarket.user;

public class User {
    private Long id;
    private String name;
    private UserGrade userGrade;

    //생성자
    public User(Long id, String name, UserGrade userGrade) {
        this.id = id;
        this.name = name;
        this.userGrade = userGrade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserGrade getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(UserGrade userGrade) {
        this.userGrade = userGrade;
    }
}

package com.dio.springweb.restapi.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private Integer id;
    private String login;
    private String password;

    public User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}

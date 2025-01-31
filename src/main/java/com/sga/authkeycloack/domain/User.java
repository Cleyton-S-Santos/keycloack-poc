package com.sga.authkeycloack.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
}

package com.usm.usmobile.model;

@Data
@Document(collection = "users")
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

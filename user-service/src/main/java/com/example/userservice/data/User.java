package com.example.userservice.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  // represents this class is entity class
@Data //using lombok dependancy for getter setters
@NoArgsConstructor // empty arguments constructor
@Table(name = "user") // specifying table name
public class User {

    @Id //setting up primary key in auto increment method
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; //setting up fields .. username
    private String email;
    private String password;

    // constructor for quick use of entity class
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

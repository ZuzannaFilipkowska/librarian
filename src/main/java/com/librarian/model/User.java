package com.librarian.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator ="UUID")
    private UUID userId;
    private String name;
    private String passwordHash;

    public User( String zuza, String s) {
        this.name = zuza;
        this.passwordHash = s;
    }
}

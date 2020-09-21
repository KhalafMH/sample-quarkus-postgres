package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@Entity(name = "users")
public class User extends PanacheEntity {
    public String name;
    public String email;

    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static Optional<User> findByEmail(String email) {
        return find("email", email).singleResultOptional();
    }
}

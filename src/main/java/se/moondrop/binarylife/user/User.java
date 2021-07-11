package se.moondrop.binarylife.user;

import org.springframework.stereotype.Component;

/**
 * Represent a authorized user
 * 
 * @since 0.1 - pre-alpha
 * @version 0.1 - pre-alpha
 */
@Component
public class User {

    private String id;
    private String username;
    private String password;

    public User(String generatedId) {
        id = generatedId;
    }

    public User() {

    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

}

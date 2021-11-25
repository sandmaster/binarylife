package se.moondrop.binarylife.user;

import org.springframework.stereotype.Component;

import se.moondrop.binarylife.player.Player;

/**
 * Represent an authorized user
 * 
 * @since 0.1 - pre-alpha
 * @version 0.1 - pre-alpha
 */
@Component
public class User {

    private int id;
    private String username;
    private String password;
    private Player player;

    public User(int generatedId) {
        id = generatedId;
        initializePlayerForUser();
    }

    public User() {
        initializePlayerForUser();
    }

    public int getId() {
        return id;
    }

    private void initializePlayerForUser() {
        player = new Player();
        player.init();
    }

    public Player getPlayer() {
        return player;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

}

package se.moondrop.binarylife.repository;

import org.springframework.stereotype.Repository;
import se.moondrop.binarylife.manager.DatabaseManager;
import se.moondrop.binarylife.user.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for handing storing and retrieval of Users from the database
 */
@Repository
public class UserRepository {

    private DatabaseManager databaseManager;
    private Connection connection;

    public UserRepository(){
        try {
            init();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void init() throws SQLException {
        databaseManager = new DatabaseManager();
        connection = databaseManager.getConnection();
        Statement statement = connection.createStatement();
        // How do we handle password ? Would like it to be scrambled and secure.
        statement.execute("CREATE TABLE IF NOT EXISTS user (id INTEGER PRIMARY KEY, username TEXT NOT NULL UNIQUE, password TEXT NOT NULL");
        statement.close();
        connection.close();
    }

    /**
     * Method to retrieve a user from the database, validate whether the incoming credentials is correct
     * @param username the username to retrieve
     * @param password the password to be authenticated
     * @return a new User object, or a User object holding the result from the query
     */
    public User retrieveUser(String username, String password) {

        User user = new User();
        try {
            connection = databaseManager.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("SELECT * FROM user WHERE username = '" + username + "'");
            ResultSet result = statement.getResultSet();

            if (result == null) {
                System.out.println("The resulting query failed...");
            } else {
                while (result.next()) {
                    String retrievedUsername = result.getString("username");
                    String retrievedPassword = result.getString("password");
                    int retrievedId = result.getInt("id");

                    // Validate user
                    if(password.equals(retrievedPassword)){
                        user.setUsername(retrievedUsername);
                        user.setPassword(retrievedPassword);
                        user.setId(retrievedId);
                    }
                 }
            }

            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * Method to store a new user in the database
     * @param id // Should be auto-incremented ?
     * @param username the users username
     * @param password the users password
     * @return boolean whether the storing was successful or not
     * @throws SQLException if the database access sends an error, or this method is called on a closed connection
     */
    public boolean storeUser(String id, String username, String password) throws SQLException {

        if(username.isBlank() || password.isBlank() || id.isBlank()){
            return false;
        }

        connection = databaseManager.getConnection();
        Statement statement = connection.createStatement();
        boolean result = statement.execute("INSERT INTO user (id, username, password) VALUES ("+id + ", " + username + ", " + password);
        statement.close();
        connection.close();

        return result;
    }

}

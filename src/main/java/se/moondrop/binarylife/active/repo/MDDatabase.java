package se.moondrop.binarylife.active.repo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MDDatabase {

    private Connection connection;
    private static final Logger log = LogManager.getLogger(MDDatabase.class.getName());

    public MDDatabase() {
        init();
    }

    /**
     * Initialize the connection to the database, and then check so everything went
     * fine with the connection.
     */
    public void init() {

        log.info("DatabaseManager is initializing");
        connection = retrieveConnectionToDB();

        if (connection == null) {
            log.info("Connection failed to be opened");
        } else {
            log.info("Connection established");
        }

    }

    private Connection retrieveConnectionToDB() {
        Connection conn;
        String url = "jdbc:sqlite:D:\\Development\\test.db";
        try {
            conn = DriverManager.getConnection(url);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection getConnection() {
        if(connection == null){
            retrieveConnectionToDB();
        }
        return connection;
    }
}

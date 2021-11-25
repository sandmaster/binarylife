package se.moondrop.binarylife.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Simple class to handle the connection to the database, used by other repository classes for retrieving a connection to the database.
 */
@Component
public class DatabaseManager {

	private Connection connection;
	private static final Logger log = LogManager.getLogger(DatabaseManager.class.getName());

	public DatabaseManager() {
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

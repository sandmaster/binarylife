package se.moondrop.binarylife.repository;

import org.springframework.stereotype.Repository;
import se.moondrop.binarylife.manager.DatabaseManager;
import se.moondrop.binarylife.training.Activity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for handing storing and retrieval of activities from the database
 */
@Repository
public class ExerciseRepository {

	DatabaseManager databaseManager;
	Connection connection;

	public ExerciseRepository() {

		try {
			init();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the tables being used for this service; exercise
	 * @throws SQLException if the database access sends an error, or this method is called on a closed connection
	 */
	public void init() throws SQLException {
		databaseManager = new DatabaseManager();
		connection = databaseManager.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("CREATE TABLE IF NOT EXISTS exercise (id INTEGER PRIMARY KEY, user TEXT NOT NULL, activity TEXT NOT NULL, calories INTEGER NOT NULL, description TEXT");
		statement.close();
		connection.close();
	}

	/**
	 * Method to store an activity into the database, by sending the values as arguments
	 * @param activity the activity name
	 * @param description the description of the exercise
	 * @param userId the userId of the user
	 * @param timeInMinutes the amount of minutes the activity has taken
	 * @throws SQLException if the database access sends an error, or this method is called on a closed connection
	 */
	public void storeExercise(String activity, String description, int userId, int timeInMinutes) throws SQLException {

		if(description.isBlank()){
			description = "No description for this exercise has been put";
		}

		connection = databaseManager.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("INSERT INTO exercise IF NOT EXISTS (activity, description, userId, time) VALUES ("+activity+", " + description + ", " + userId + ", " + timeInMinutes);
		statement.close();
		connection.close();
	}

	/**
	 * Method for retrieving a row (activity) from the database
	 * @param name the name of the activity to be retrieved
	 * @return the result from the query being made
	 * @throws SQLException if the database access sends an error, or this method is called on a closed connection
	 */
	public Activity retrieveActivity(String name) throws SQLException {
		Activity activity = new Activity();

		connection = databaseManager.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("SELECT * FROM activity WHERE name = '" + name + "'");
		ResultSet result = statement.getResultSet();

		if (result == null) {
			System.out.println("The resulting query failed...");
			return null;
		} else {
			try {
				while (result.next()) {
					activity.setName(result.getString("name"));
					activity.setDescription(result.getString("description"));
					activity.setRemValue(result.getDouble("remValue"));

					// Assume it will only find 1 specific activity
					result.close();
					statement.close();
					connection.close();

					return activity;				}

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

}

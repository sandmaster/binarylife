package se.moondrop.binarylife.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import se.moondrop.binarylife.player.Player;

@Controller
public class PlayerController {

	@Autowired
//	private TestObject object;

	@GetMapping(value = "/player")
	public ResponseEntity<String> getMethodName() {

		/**
		 * This endpoint should fetch the current users player and desplay its values
		 */
		Player temp = new Player("Robin", 152);
		temp.init();

		String result = temp.toString();
		System.out.println(result);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping(value = "/test")
	public ResponseEntity<String> test() {
//		object.executeTest();
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}

	@GetMapping(value = "/db")
	public ResponseEntity<String> testDB() {

		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\Development\\test.db");
				Statement statement = conn.createStatement()) {

			statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");

		} catch (SQLException e) {
			System.out.println("Something went wrong: " + e.getMessage());
		}

		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

}

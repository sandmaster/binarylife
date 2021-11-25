package se.moondrop.binarylife.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import se.moondrop.binarylife.training.Activity;
import se.moondrop.binarylife.training.Exercise;

import java.sql.SQLException;

class PlayerTest {

	Player mockPlayer;

	@BeforeEach
	void setup() {
		mockPlayer = new Player("Robin", 150);
		mockPlayer.init();
	}

	@Test
	void testIncreaseLevel() {

		mockPlayer.getPlayerLevel().increaseExperience(220);

		assertEquals(2, mockPlayer.getPlayerLevel().getLevel());
		assertEquals(10, mockPlayer.getCurrentExperience());
	}

	@Test
	void testIncreaseExperience() {
		mockPlayer.getPlayerLevel().increaseExperience(90);
		assertEquals(90, mockPlayer.getCurrentExperience());
	}

	@Test
	@Description("testAddingNewExerciseToPlayer")
	void testAddNewExerciseToPlayer() throws SQLException {
		// Mock objects
		Activity mockActivity = new Activity("Running", 3.14);
		Exercise mockExercise = new Exercise(mockActivity, 20);
		double mockPlayerExperienceFromActivity = 20 * (3.14 * 3.5 * mockPlayer.getWeight()) / 200;
		long rounded = Math.round(mockPlayerExperienceFromActivity);
		long amountToCheck = rounded - 100;

		// Method calls
		mockPlayer.addExercise(mockExercise);

		// Assertions
		assertEquals(amountToCheck, mockPlayer.getCurrentExperience());
		assertEquals(1, mockPlayer.getPlayerLevel().getLevel());
	}

	@Test
	@Description("testAddingExistingActivityToPlayer")
	void testAddExistingActivityToPlayer() {
/*
		String activityName = "Running";
		double remValue = 3.14;
		int amountTime = 20;

		Activity activity = new Activity(activityName, "Moderate speed", remValue, amountTime);

		mockPlayer.addActivity(activity);

		double mockPlayerExperienceFromActivity = amountTime * (remValue * 3.5 * mockPlayer.getWeight()) / 200;
		long rounded = Math.round(mockPlayerExperienceFromActivity);
		long amountToCheck = rounded - 100;

		assertEquals(amountToCheck, mockPlayer.getCurrentExperience());
		assertEquals(1, mockPlayer.getPlayerLevel().getLevel());
		*/
	}

}

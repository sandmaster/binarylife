package se.moondrop.binarylife.player;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import se.moondrop.binarylife.repository.ExerciseRepository;
import se.moondrop.binarylife.training.Activity;
import se.moondrop.binarylife.training.Exercise;
import se.moondrop.binarylife.user.User;
import se.moondrop.binarylife.util.Utilities;

/**
 * Represents a user authorized for the service.
 * <p>
 * Will hold specific details about the <b>Player</b> status, level and name.
 * 
 * @author robin
 * @version 0.1 - pre-alpha
 * @since 0.1 - pre-alpha
 *
 */
@Component
public class Player {

	private String name;
	private int weight;
	private Level level;
	private Status status;
	private ExerciseRepository exerciseRepository;
	private User attachedUser;
	private boolean hasBeenInitialized = false;

	public Player(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public Player() {
	}

	/**
	 * Method called the first time a player is created
	 */
	public void init() {

		status = new Status();
		level = new Level();

		level.init();
		status.init();

		exerciseRepository = new ExerciseRepository();

		System.out.println("Player " + name + " has been initialized");

		hasBeenInitialized = true;
	}

	/**
	 * Adds an exercise to the player; increase the player experience
	 * @param exercise the exercise to be added.
	 */
	public void addExercise(Exercise exercise) throws SQLException {

		Utilities util = new Utilities();
		double d = util.calculateCalories(exercise, this);
		// Make sure the player has been initialized before continuing
		if(!hasBeenInitialized){
			init();
		}

		exerciseRepository.storeExercise(exercise.getActivity().getName(), exercise.getDescription(), attachedUser.getId(), exercise.getTime());
		this.level.increaseExperience(Math.round(d));

	}

	public boolean isHasBeenInitialized() {
		return hasBeenInitialized;
	}

	public void setAttachedUser(User user){
		this.attachedUser = user;
	}

	public User getAttachedUser(){
		return attachedUser;
	}

	public int getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}

	public Level getPlayerLevel() {
		return level;
	}

	public long getCurrentExperience() {
		return level.getCurrentExperience();
	}

	public long getExperienceForLevelUp() {
		return level.getExperienceToNextLevel();
	}

	public List<StatusType> getStatus() {
		return status.getStatus();
	}

	@Override
	public String toString() {

		return "Name: " + name + "\nWeight: " + weight + "\nLevel: " + getPlayerLevel() + "\nExperience: "
				+ getCurrentExperience() + "/" + getExperienceForLevelUp() + "\n" + status.toString();
	}
}

package se.moondrop.binarylife.player;

import java.util.List;

import org.springframework.stereotype.Component;

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
	private int age;
	private int weight;
	private Level level;
	private Status status;

	public Player(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	/**
	 * Method called the first time a player is created
	 */
	public void init() {

		status = new Status();
		level = new Level();

		level.init();
		status.init();

		System.out.println("Player " + name + " has been initialized");

	}

	public int getAge() {
		return age;
	}

	public int getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}

	public int getPlayerLevel() {
		return level.getLevel();
	}

	public long getCurrentExperience(){
		return level.getCurrentExperience();
	}

	public long getExperienceForLevelUp(){
		return level.getExperienceToNextLevel();
	}

	public List<StatusType> getStatus() {
		return status.getStatus();
	}

	@Override
	public String toString() {
		
		return "Name: " + name + "\nAge: " + age + "\nWeight: " + weight + "\nLevel: " + getPlayerLevel()
				+ "\nExperience: " + getCurrentExperience() +"/"+getExperienceForLevelUp()+"\n"+status.toString();
	}
}

package se.moondrop.binarylife.player;

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
	private Level level;
	private Status status;

	/**
	 * Method called the first time a player is created
	 */
	public void init() {

	}
}

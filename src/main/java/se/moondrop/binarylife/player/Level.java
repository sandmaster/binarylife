package se.moondrop.binarylife.player;

import org.springframework.stereotype.Component;

/**
 * Represents a Level object, which handles everything to do with experience
 * recieved, automatically levels up hen required
 * 
 * @since 0.1 - pre-alpha
 * @version 0.1 - pre-alpha
 */
@Component
public class Level {

    private int currentLevel;
    private long experienceCurrentLevel;
    private long experienceToNextLevel;

    private static final double LEVEL_UP_MULTIPLICATION = 1.1;

    /**
     * Init initializes the Level object and sets its default values.
     */
    public void init() {
        currentLevel = 0;
        experienceCurrentLevel = 0l;
        experienceToNextLevel = 100l;
    }

    /**
     * Method purely used in the background of the level class
     * <p>
     * Used when there is an overflow of experience
     * 
     * @param overflow number of experience over the cap before the next level
     */
    private void levelUp(long overflow) {

        currentLevel++;
        System.out.println("Congratulations, you have leveled up. Level " + currentLevel);
        experienceCurrentLevel = overflow;
        experienceToNextLevel *= LEVEL_UP_MULTIPLICATION;

        while (overflow >= experienceToNextLevel) {
            currentLevel++;
            System.out.println("Congratulations, you have leveled up. Level " + currentLevel);

            overflow -= experienceToNextLevel;
            experienceCurrentLevel = overflow;

            experienceToNextLevel *= LEVEL_UP_MULTIPLICATION;

        }

    }

    /**
     * Method purely used in the background of the level class
     * <p>
     * Used when no overflow is happening.
     * 
     * @param overflow number of experience over the cap before the next level
     */
    private void levelUp() {
        currentLevel++;
        experienceCurrentLevel = 0l;
        experienceToNextLevel *= LEVEL_UP_MULTIPLICATION;
    }

    /**
     * Method to increase the levels experience
     * <p>
     * Checks if there is any possibility to level up, and calls the respective
     * method in that case.
     * 
     * @param amount the amount of experience being added
     */
    public void increaseExperience(long amount) {

        if (amount <= 0) {
            amount = 0l;
        }

        long totalAmountOfExperience = experienceCurrentLevel + amount;

        boolean amountIsOverflow = totalAmountOfExperience > experienceToNextLevel;
        boolean amountIsEqualToLevelUp = totalAmountOfExperience == experienceToNextLevel;

        if (amountIsOverflow) {
            // Subtract overflow from the required experience for level up.
            long overflow = totalAmountOfExperience - experienceToNextLevel;
            levelUp(overflow);
        } else if (amountIsEqualToLevelUp) {
            levelUp();
        } else {
            experienceCurrentLevel = totalAmountOfExperience;
        }
    }

    public int getLevel() {
        return this.currentLevel;
    }

    public long getCurrentExperience() {
        return experienceCurrentLevel;
    }

    public long getExperienceToNextLevel() {
        return experienceToNextLevel;
    }

}

package se.moondrop.binarylife.v1.process;

import se.moondrop.binarylife.v1.character.Character;

public class CharacterProcess {



    /**
     * Method to increase the experience for the character being sent in as a parameter
     * @param amount the amount of experience the character will receive
     * @param character the character object which should be edited.
     */
    public static void increaseExperienceForCharacter(int amount, Character character) {

        if(amount <= 0){
            return;
        }

        if(character == null){
            return;
        }

        long amountOfExperienceToLevelUp = character.getStatusScreen().getLevel().getCharacterExperienceLevelUp();
        long amountOfCurrentExperience = character.getStatusScreen().getLevel().getCharacterExperience();
        int currentLevelOfCharacter = character.getStatusScreen().getLevel().getCharacterLevel();

        // Calculate the amount of experience the character will have after the amount has
        // been added.
        long amountOfExperience = amountOfCurrentExperience + amount;

        // Amount is not enough for level up to occur- simply add the experience
        if(amountOfExperience < amountOfExperienceToLevelUp) {
            character.getStatusScreen().getLevel().setCharacterExperience(amountOfExperience);
        } else if (amountOfExperience == amountOfExperienceToLevelUp){
            // Amount is just enough for a level up
            character.getStatusScreen().getLevel().setCharacterLevel(++currentLevelOfCharacter);
            character.getStatusScreen().getLevel().setCharacterExperience(0);
            character.getStatusScreen().getLevel().update();
        } else {
            // Loop through gained experience until its 0
//            System.out.println("Before while loop: " + amountOfExperience);
//            System.out.println("Experience to next level: " + amountOfExperienceToLevelUp);

            while(amountOfExperience >= amountOfExperienceToLevelUp) {
                // Level up
                character.getStatusScreen().getLevel().setCharacterLevel(++currentLevelOfCharacter);
//                System.out.println("Leveled up, new value: " + character.getStatusScreen().getLevel().getCharacterLevel());
                // Decrease experience for level up
                amountOfExperience -= amountOfExperienceToLevelUp;
//                System.out.println("Decreasing experience, new value: " + amountOfExperience);
                // Update level
                character.getStatusScreen().getLevel().update();
//                System.out.println("Update for Level object called, new details: " + character.getStatusScreen().getLevel().toString());

                amountOfExperienceToLevelUp = character.getStatusScreen().getLevel().getCharacterExperienceLevelUp();

            }
            // Set the leftover experience to current experience
            character.getStatusScreen().getLevel().setCharacterExperience(amountOfExperience);
//            System.out.println("Loop exited, set value " + amountOfExperience + " to the characters current experience...");
//            System.out.println("Character current experience: " + character.getStatusScreen().getLevel().getCharacterExperience());
        }

    }

}

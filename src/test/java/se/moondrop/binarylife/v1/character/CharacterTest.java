package se.moondrop.binarylife.v1.character;


import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {

    @Test
    @Description("test whether the correct values are set when creating a new character object")
    void createNewCharacterTest(){
        Character character = new Character("{123456789}", "mockCharacter", 100);
        // Main character information
        assertEquals("{123456789}", character.getCharacterUserId(), "Make sure the value is set correctly when creating a new object of Character");
        assertEquals(null, character.getCharacterId(), "Currently not being set in the constructor - must be set manually after creation of object");
        // Check Status Screen content of Character
        assertEquals("mockCharacter", character.getStatusScreen().getName(), "Make sure the name is sent and initialized in the StatusScreen constructor");
        assertEquals(100, character.getStatusScreen().getWeight(), "Make sure the incoming parameter is sent and initialized in the StatusScreen constructor");
        assertEquals(0, character.getStatusScreen().getLevel().getCharacterLevel(), "Level should be set as default to value 0");
        assertEquals(0, character.getStatusScreen().getLevel().getCharacterExperience(), "Character experience should always start at 0");
        assertEquals(100, character.getStatusScreen().getLevel().getCharacterExperienceLevelUp(), "The initialized value for the first level-up is 100");

        // Manually set the characterId
        character.setCharacterId("00001");
        assertEquals("00001", character.getCharacterId(), "After manually set the value, check if its correctly set");

    }

}

package se.moondrop.binarylife.v1.process;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;
import se.moondrop.binarylife.v1.character.Character;

public class CharacterProcessTest {

    @Test
    @Description("Testing increasing the current experience for a character")
    void testIncreaseExperienceToValidCharacter(){
        Character character = new Character("{1234567890}", "mockCharacter", 100);

        Assertions.assertEquals(0, character.getStatusScreen().getLevel().getCharacterExperience());
        Assertions.assertEquals(0, character.getStatusScreen().getLevel().getCharacterLevel());
        Assertions.assertEquals(100, character.getStatusScreen().getLevel().getCharacterExperienceLevelUp());

        CharacterProcess.increaseExperienceForCharacter(100, character);

        Assertions.assertEquals(1, character.getStatusScreen().getLevel().getCharacterLevel());
        Assertions.assertEquals(0, character.getStatusScreen().getLevel().getCharacterExperience());
        Assertions.assertEquals(155, character.getStatusScreen().getLevel().getCharacterExperienceLevelUp());

    }

    @Test
    @Description("Testing increasing the current experience for a null character")
    void testIncreaseExperienceToNullCharacter(){

        Character character = new Character("{1234567890}", "mockCharacter", 100);

        Assertions.assertEquals(0, character.getStatusScreen().getLevel().getCharacterExperience());
        Assertions.assertEquals(0, character.getStatusScreen().getLevel().getCharacterLevel());
        Assertions.assertEquals(100, character.getStatusScreen().getLevel().getCharacterExperienceLevelUp());

        CharacterProcess.increaseExperienceForCharacter(100, null);

        Assertions.assertEquals(0, character.getStatusScreen().getLevel().getCharacterLevel());
        Assertions.assertEquals(0, character.getStatusScreen().getLevel().getCharacterExperience());
        Assertions.assertEquals(100, character.getStatusScreen().getLevel().getCharacterExperienceLevelUp());

    }

    @Test
    @Description("Testing increasing the current experience for a character by a negative amount")
    void testIncreaseExperienceToCharacterWithNegativeAmount(){

        Character character = new Character("{1234567890}", "mockCharacter", 100);

        Assertions.assertEquals(0, character.getStatusScreen().getLevel().getCharacterExperience());
        Assertions.assertEquals(0, character.getStatusScreen().getLevel().getCharacterLevel());
        Assertions.assertEquals(100, character.getStatusScreen().getLevel().getCharacterExperienceLevelUp());

        CharacterProcess.increaseExperienceForCharacter(-10, character);

        Assertions.assertEquals(0, character.getStatusScreen().getLevel().getCharacterLevel());
        Assertions.assertEquals(0, character.getStatusScreen().getLevel().getCharacterExperience());
        Assertions.assertEquals(100, character.getStatusScreen().getLevel().getCharacterExperienceLevelUp());

    }

    @Test
    @Description("Testing increasing the current experience for a character by a large amount")
    void testIncreaseExperienceToValidCharacterByLargeAmount(){
        Character character = new Character("{1234567890}", "mockCharacter", 100);

        Assertions.assertEquals(0, character.getStatusScreen().getLevel().getCharacterExperience());
        Assertions.assertEquals(0, character.getStatusScreen().getLevel().getCharacterLevel());
        Assertions.assertEquals(100, character.getStatusScreen().getLevel().getCharacterExperienceLevelUp());

        CharacterProcess.increaseExperienceForCharacter(10000, character);

        Assertions.assertEquals(14, character.getStatusScreen().getLevel().getCharacterLevel());
        Assertions.assertEquals(960, character.getStatusScreen().getLevel().getCharacterExperience());
        Assertions.assertEquals(1629, character.getStatusScreen().getLevel().getCharacterExperienceLevelUp());

    }

}

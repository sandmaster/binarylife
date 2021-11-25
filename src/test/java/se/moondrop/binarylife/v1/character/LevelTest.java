package se.moondrop.binarylife.v1.character;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class LevelTest {

    @Test
    @Description("Tests whether the default values are set correctly when creating a new Level object")
    void testDefaultValuesWhenCreatingNewLevel(){
        Level level = new Level();

        Assertions.assertEquals(0, level.getCharacterLevel());
        Assertions.assertEquals(0, level.getCharacterExperience());
        Assertions.assertEquals(100, level.getCharacterExperienceLevelUp());
    }

    @Test
    @Description("Tests adding positive number of experience to the level")
    void testIncreaseOfPositiveExperience(){
        Level level = new Level();

        Assertions.assertEquals(0,level.getCharacterExperience());
        Assertions.assertEquals(100, level.getCharacterExperienceLevelUp());

        level.setCharacterExperience(50);
        Assertions.assertEquals(50, level.getCharacterExperience());
        Assertions.assertEquals(100, level.getCharacterExperienceLevelUp());
    }

    @Test
    @Description("Tests adding negative number of experience to the level")
    void testIncreaseOfNegativeExperience(){
        Level level = new Level();

        Assertions.assertEquals(0,level.getCharacterExperience());
        Assertions.assertEquals(100, level.getCharacterExperienceLevelUp());

        level.setCharacterExperience(-50);
        Assertions.assertEquals(0, level.getCharacterExperience());
        Assertions.assertEquals(100, level.getCharacterExperienceLevelUp());
    }

    @Test
    @Description("Tests adding positive number of experience to the level up variable")
    void testIncreaseOfPositiveExperienceForLevelUp(){
        Level level = new Level();

        Assertions.assertEquals(0,level.getCharacterExperience());
        Assertions.assertEquals(100, level.getCharacterExperienceLevelUp());

        level.setCharacterExperienceLevelUp(1000);
        Assertions.assertEquals(0, level.getCharacterExperience());
        Assertions.assertEquals(1000, level.getCharacterExperienceLevelUp());
    }

    @Test
    @Description("Tests adding negative number of experience to the level up variable")
    void testIncreaseOfNegativeExperienceForLevelUp(){
        Level level = new Level();

        Assertions.assertEquals(0,level.getCharacterExperience());
        Assertions.assertEquals(100, level.getCharacterExperienceLevelUp());

        level.setCharacterExperienceLevelUp(-10);
        Assertions.assertEquals(0, level.getCharacterExperience());
        Assertions.assertEquals(100, level.getCharacterExperienceLevelUp());
    }

    @Test
    @Description("Tests adding positive number to characterLevel")
    void testIncreaseOfPositiveValueToCharacterLevel(){
        Level level = new Level();

        Assertions.assertEquals(0, level.getCharacterLevel());
        Assertions.assertEquals(0,level.getCharacterExperience());
        Assertions.assertEquals(100, level.getCharacterExperienceLevelUp());

        level.setCharacterLevel(10);
        Assertions.assertEquals(10, level.getCharacterLevel());
        Assertions.assertEquals(0, level.getCharacterExperience());
        Assertions.assertEquals(100, level.getCharacterExperienceLevelUp());
    }

    @Test
    @Description("Tests adding negative number to characterLevel")
    void testIncreaseOfNegativeValueToCharacterLevel(){
        Level level = new Level();

        Assertions.assertEquals(0, level.getCharacterLevel());
        Assertions.assertEquals(0,level.getCharacterExperience());
        Assertions.assertEquals(100, level.getCharacterExperienceLevelUp());

        level.setCharacterLevel(-10);
        Assertions.assertEquals(0, level.getCharacterLevel());
        Assertions.assertEquals(0, level.getCharacterExperience());
        Assertions.assertEquals(100, level.getCharacterExperienceLevelUp());
    }

}

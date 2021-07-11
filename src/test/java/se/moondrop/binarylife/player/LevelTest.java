package se.moondrop.binarylife.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class LevelTest {

    @Autowired
    private Level level;

    @Test
    @Description("Test that init() method sets the correct values")
    void testLevelInit() {
        level.init();

        assertEquals(0, level.getLevel(), "Newly initialized level should be 0");
        assertEquals(0, level.getCurrentExperience(), "Newly initialized level starting experience should be 0");
        assertEquals(100, level.getExperienceToNextLevel(),
                "Newly initialized level experience to next level (1) should be 100");
    }

    @Test
    @Description("Test levelUp with no overflow")
    void testLevelUp() {
        level.init();

        level.increaseExperience(100);

        assertEquals(1, level.getLevel());
        assertEquals(0, level.getCurrentExperience());
        assertEquals(110, level.getExperienceToNextLevel());
    }

    @Test
    @Description("Test levelUp with overflow")
    void testLevelUpThroughOverflow() {
        level.init();

        level.increaseExperience(150);

        assertEquals(1, level.getLevel());
        assertEquals(50, level.getCurrentExperience());
        assertEquals(110, level.getExperienceToNextLevel());

    }

    @Test
    @Description("Test levelUp with large overflow")
    void testLevelUpThroughLargeOverflow() {
        level.init();

        level.increaseExperience(1650);

        assertEquals(10, level.getLevel());
        assertEquals(66, level.getCurrentExperience());
        assertEquals(256, level.getExperienceToNextLevel());

    }

}

package se.moondrop.binarylife.v1.character;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusScreenTest {

    @Test
    @Description("Tests that the correct values are sat, when creating a new StatusScreen object")
    void testNewStatusScreen(){
        StatusScreen statusScreen = new StatusScreen("mockCharacter", 100);

        assertEquals(0, statusScreen.getLevel().getCharacterLevel());
        assertEquals(100, statusScreen.getWeight());
        assertEquals("mockCharacter", statusScreen.getName());
    }

}

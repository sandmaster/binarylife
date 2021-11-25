package se.moondrop.binarylife.v1.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;
import se.moondrop.binarylife.v1.character.Character;

public class TrainingSessionTest {

    @Test
    @Description("Tests creation of TrainingSession object with valid parameters")
    void createTrainingSessionValidParameters(){
        TrainingActivity activity = new TrainingActivity("mockActivity", 2.0);
        Character character = new Character("{}", "mockCharacter", 100);
        TrainingSession session = new TrainingSession(character, activity, 20);

        System.out.println("\nTrainingSession toString: \n\n" + session.toString());
        // Assert session attribute
        Assertions.assertEquals(20, session.getTime());
        // Assert session.character attributes
        Assertions.assertEquals("mockCharacter", session.getCharacter().getStatusScreen().getName());
        Assertions.assertEquals(100, session.getCharacter().getStatusScreen().getWeight());
        Assertions.assertEquals("{}", session.getCharacter().getCharacterUserId());
        // Assert session.activity attributes
        Assertions.assertEquals("mockActivity", session.getActivity().getActivityName());
        Assertions.assertEquals(2.0, session.getActivity().getRemValueForActivity());
    }

    @Test
    @Description("Tests creation of TrainingSession with invalid parameters")
    void createTrainingSessionInvalidParameters(){

        TrainingSession session = new TrainingSession(null, null, -10);

        Assertions.assertEquals(null, session.getActivity());
        Assertions.assertEquals(null, session.getCharacter());
        Assertions.assertEquals(0, session.getTime());
    }

    @Test
    @Description("Tests all methods except toString() in the TrainingSession object, including objects within'")
    void testTrainingSessionCompleteMethods(){

        TrainingSession session = new TrainingSession(null, null, 0);
        // Assert
        Assertions.assertEquals(null, session.getActivity());
        Assertions.assertEquals(null, session.getCharacter());
        Assertions.assertEquals(0, session.getTime());

        // Make changes
        TrainingActivity activity = new TrainingActivity();
        activity.setActivityName("mockActivity");
        activity.setRemValueForActivity(2.0);
        session.setActivity(activity);
        // Assert changes
        Assertions.assertEquals("mockActivity", session.getActivity().getActivityName());
        Assertions.assertEquals(2.0, session.getActivity().getRemValueForActivity());
        // Make changes
        Character character = new Character("{123456789}", null, 0);
        session.setCharacter(character);
        // Assert changes
        Assertions.assertEquals("{123456789}", session.getCharacter().getCharacterUserId());
        Assertions.assertEquals(null, session.getCharacter().getCharacterId());
        Assertions.assertEquals(null, session.getCharacter().getStatusScreen().getName());
        Assertions.assertEquals(0, session.getCharacter().getStatusScreen().getWeight());
        // Make changes
        character.setCharacterId("123456789");
        character.getStatusScreen().setWeight(110);
        // Assert changes
        Assertions.assertEquals("123456789", session.getCharacter().getCharacterId());
        Assertions.assertEquals(110, session.getCharacter().getStatusScreen().getWeight());
    }
}

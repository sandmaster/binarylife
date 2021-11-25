package se.moondrop.binarylife.v1.process;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;
import se.moondrop.binarylife.v1.character.Character;
import se.moondrop.binarylife.v1.training.TrainingActivity;
import se.moondrop.binarylife.v1.training.TrainingSession;

import java.time.temporal.Temporal;

public class TrainingSessionProcessTest {

    @Test
    @Description("Tests adding a new TrainingSession to the repository after adding information to the character")
    void testAddingNewTrainingProcessAndValidateCharacterStatus(){
        TrainingSessionProcess sessionProcess = new TrainingSessionProcess();

        Character character = new Character("{}", "mockCharacter", 100);
        TrainingActivity activity = new TrainingActivity("mockActivity", 2.0);

        TrainingSession session = new TrainingSession(character, activity, 30);

        sessionProcess.createTrainingExperienceForCharacter(session);

        System.out.println(session.toString());

        // Assert that character experience has been updated correctly
        Assertions.assertEquals(1, character.getStatusScreen().getLevel().getCharacterLevel());
        Assertions.assertEquals(5, character.getStatusScreen().getLevel().getCharacterExperience());
        Assertions.assertEquals(155, character.getStatusScreen().getLevel().getCharacterExperienceLevelUp());
    }

    @Test
    @Description("Tests the equation for calculating amount of calories for a specific activity")
    void testEquationForTotalCalories(){
        TrainingSessionProcess sessionProcess = new TrainingSessionProcess();
        TrainingActivity activity = new TrainingActivity("mockActivity", 2.0);

        int caloriesTest01 = sessionProcess.calculateExperienceFromActivity(activity, 30, 100);
        int caloriesTest02 = sessionProcess.calculateExperienceFromActivity(activity, 10, 70);
        int caloriesTest03 = sessionProcess.calculateExperienceFromActivity(activity, 40, 130);
        int caloriesTest04 = sessionProcess.calculateExperienceFromActivity(activity, 78, 80);

        Assertions.assertEquals(105, caloriesTest01);
        Assertions.assertEquals(25, caloriesTest02);
        Assertions.assertEquals(182, caloriesTest03);
        Assertions.assertEquals(218, caloriesTest04);

    }

    @Test
    @Description("Test all values for validation on a TrainingSession object")
    void testValidationOfTrainingSession(){
        TrainingSessionProcess sessionProcess = new TrainingSessionProcess();

        TrainingSession trainingSession = new TrainingSession(null, null, 10);
        Assertions.assertEquals(false, sessionProcess.validateTrainingSession(trainingSession), "null value for character and activity, valid time");

        trainingSession = new TrainingSession(new Character("{}", null, 10), new TrainingActivity("mockActivity", 1.0), 10);
        Assertions.assertEquals(false, sessionProcess.validateTrainingSession(trainingSession), "null character name, rest valid");

        trainingSession = new TrainingSession(new Character("{}", "mockCharacter", 0), new TrainingActivity("mockActivity", 1.0), 10);
        Assertions.assertEquals(false, sessionProcess.validateTrainingSession(trainingSession), "invalid weight, rest valid");

        trainingSession = new TrainingSession(new Character("{}", "mockCharacter", 10), new TrainingActivity(null, 1.0), 10);
        Assertions.assertEquals(false, sessionProcess.validateTrainingSession(trainingSession), "Activity name is null, rest valid");

        trainingSession = new TrainingSession(new Character("{}", "mockCharacter", 10), new TrainingActivity("mockActivity", 0.0), 10);
        Assertions.assertEquals(false, sessionProcess.validateTrainingSession(trainingSession), "0.0 invalid number for remValue in Activity, rest valid");

        trainingSession = new TrainingSession(new Character("{}", "mockCharacter", 10), new TrainingActivity("mockActivity", 1.0), 0);
        Assertions.assertEquals(false, sessionProcess.validateTrainingSession(trainingSession), "Invalid time value, rest valid values");

        trainingSession = new TrainingSession(new Character("{}", "mockCharacter", 10), new TrainingActivity("mockActivity", 1.0), 10);
        Assertions.assertEquals(true, sessionProcess.validateTrainingSession(trainingSession), "valid values");

    }

}

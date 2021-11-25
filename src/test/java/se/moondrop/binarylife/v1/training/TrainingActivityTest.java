package se.moondrop.binarylife.v1.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class TrainingActivityTest {

    @Test
    @Description("Tests creation of a new TrainingActivity Object with valid parameters")
    void testCreateNewTrainingActivityObjectValidParameters(){
        TrainingActivity activity = new TrainingActivity("mockActivity", 2.0);

        Assertions.assertEquals("mockActivity", activity.getActivityName());
        Assertions.assertEquals(2.0, activity.getRemValueForActivity());
    }

    @Test
    @Description("Tests creation of a new empty TrainingActivity object")
    void testCreateNewEmptyTrainingActivity(){
        TrainingActivity activity = new TrainingActivity();

        Assertions.assertEquals(null, activity.getActivityName());
        Assertions.assertEquals(0.0, activity.getRemValueForActivity());
    }

    @Test
    @Description("Tests setters in the object")
    void testSetters(){
        TrainingActivity activity = new TrainingActivity();
        // Execute changes valid
        activity.setActivityName("Spinning");
        activity.setRemValueForActivity(2.3);
        // Assert
        Assertions.assertEquals("Spinning", activity.getActivityName());
        Assertions.assertEquals(2.3, activity.getRemValueForActivity());
        // Execute changes 1 invalid
        activity.setActivityName("Negative");
        activity.setRemValueForActivity(-2.3);
        // Assert
        Assertions.assertEquals("Negative", activity.getActivityName());
        Assertions.assertEquals(2.3, activity.getRemValueForActivity());
        // Execute changes null
        activity.setActivityName(null);
        activity.setRemValueForActivity(0.0);
        // Assert
        Assertions.assertEquals(null, activity.getActivityName());
        Assertions.assertEquals(0.0, activity.getRemValueForActivity());
    }
}

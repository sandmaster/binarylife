package se.moondrop.binarylife.v1.process;

import org.springframework.lang.NonNull;
import se.moondrop.binarylife.v1.character.Character;
import se.moondrop.binarylife.v1.training.TrainingActivity;
import se.moondrop.binarylife.v1.training.TrainingSession;

/**
 * Class having static methods for handling processes within' the training package
 */
public class TrainingSessionProcess {

/**
 * What should this process do ?
 *
 * Process TrainingSession through functions
 */

    public void createTrainingExperienceForCharacter(TrainingSession training){

        if(validateTrainingSession(training)){
            // Calculate amount of experience for the training
            int w = training.getCharacter().getStatusScreen().getWeight();
            int t = training.getTime();

            int amountOfExp = calculateExperienceFromActivity(training.getActivity(), t, w);
            CharacterProcess.increaseExperienceForCharacter(amountOfExp, training.getCharacter());

            // Still need to add to repository!!!
        }
    }

    public int calculateExperienceFromActivity(@NonNull TrainingActivity activity, int time, int weight){

        /**
         * Execute the following equation:
         *  -> cal = t * (m * 3.5 * w) / 200
         *  Where t = time in minutes, m = activity MET value and w = weight of person in kilograms
         */
        double totalCalories = time * (activity.getRemValueForActivity() * 3.5 * weight) / 200;
//        System.out.println((int)Math.round(totalCalories));
        return (int)Math.round(totalCalories);
    }

    public boolean validateTrainingSession(@NonNull TrainingSession trainingSession){

//        System.out.println(trainingSession.toString());

        Character sessionCharacter = trainingSession.getCharacter();
        TrainingActivity sessionActivity = trainingSession.getActivity();

        // Validate trainingSession fields
        if(sessionCharacter == null || sessionActivity == null || trainingSession.getTime() <= 0){
            return false;
        }

        // Validate character
        if(sessionCharacter.getStatusScreen().getName() == null || sessionCharacter.getStatusScreen().getWeight() <= 0 ){
            return false;
        }

        // Validate activity fields
        if(sessionActivity.getActivityName() == null || sessionActivity.getRemValueForActivity() <= 0.0 ){
            return false;
        }

        return true;
    }
}

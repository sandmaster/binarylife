package se.moondrop.binarylife.training;

import org.springframework.stereotype.Component;

@Component
public class Exercise {

    private Activity activity;
    private int timeInMinutes;
    private String description = "No description added";

    public Exercise(){}

    public Exercise(Activity _activity, int time){
        activity = _activity;
        timeInMinutes = time;
    }

    public int getTime(){
        return timeInMinutes;
    }

    public Activity getActivity(){
        return activity;
    }

    public String getDescription(){
        return description;
    }

    public String toString(){
        // Retrieve activity object and print details
        return "Exercise: " + activity.getName() + " (" + activity.getDescription() + ") - time taken: " + timeInMinutes;
    }
}

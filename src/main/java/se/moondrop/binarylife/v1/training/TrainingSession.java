package se.moondrop.binarylife.v1.training;

import se.moondrop.binarylife.v1.character.Character;

public class TrainingSession {
    /**
     * What should this class be about ?
     *
     * A Training object should be of a specific training session for a user/character.
     * It will hold the training activity, amount of time of session, and which character who did the session.
     */
    // Time taken in minutes
    private int time;
    // Activity done during training session
    private TrainingActivity activity;
    // The User doing the activity
    private Character character; // Should be replaced by User ?

    public TrainingSession(Character character, TrainingActivity activity, int time){
        this.activity = activity;
        this.character = character;
        // Handle negative numbers for time
        if(time < 0){
            this.time = 0;
        } else {
            this.time = time;
        }
    }

    /**
     * This constructor needs to be edited; can't have the current character object.
     * Either try and make them valid default objects, or just an empty constructor
     */
    public TrainingSession() {
        time = 0;
        activity = new TrainingActivity();
        character = new Character("tempChar", "tempName", 0);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public TrainingActivity getActivity() {
        return activity;
    }

    public void setActivity(TrainingActivity activity) {
        this.activity = activity;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return "TrainingSession{" +
                "time=" + time +
                ", activity=" + activity +
                ", character=" + character +
                '}';
    }
}

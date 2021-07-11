package se.moondrop.binarylife.handler;

import se.moondrop.binarylife.training.Activity;
import se.moondrop.binarylife.user.User;

public interface temp {

    public void calculateExperience(Activity training, int time);

    public void addExperienceToPlayer(long experience);

    public User retrieveUser(String id);

    public void storeUser(String id, String username, String password);

    public void updatePlayerStatus(String statusFieldName, int amount);

    /**
     * How should the service work ?
     * 
     * -> Each endpoint requires some sort of authentication to know which user its
     * about.
     * <p>
     * -> The backend fetches the user from the database by <?>
     * <p>
     * -> Authorized user can access their profile - player screen
     * <p>
     * -> The user can add an activity from a list, set amount of time in minutes.
     * -> Backend will calculate the amount of experience the task is given
     * <p>
     * -> Backend will update the experience total of the player of the authorized
     * user.
     * 
     */

}

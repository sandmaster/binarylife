package se.moondrop.binarylife.player;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Represent a status window for the Player.
 * 
 * @since 0.1 - pre-alpha
 * @version 0.1 - pre-alpha
 */
@Component
public class Status {

    private List<StatusType> fields;

    /**
     * Method to initialize the default status fields.
     */
    public void init() {

        fields = new ArrayList<>();

        fields.add(new StatusType("Vitality"));
        fields.add(new StatusType("Endurance"));
        fields.add(new StatusType("Agility"));
        fields.add(new StatusType("Strength"));
        fields.add(new StatusType("Intelligence"));
    }

    /**
     * Add a status field to the current player array of fields.
     * 
     * @param name the name of the new status field
     * @return true if it was successfully added, false otherwise.
     */
    public boolean addStatusField(String name) {

        for (StatusType field : fields) {
            if (field.getName().equals(name)) {
                return false;
            }
        }

        fields.add(new StatusType(name));
        return true;
    }

    /**
     * Add a status field to the current player array of fields.
     * 
     * @param name        the name of the new status field
     * @param startAmount the amount to set the default value of the specified
     *                    status field.
     * @return true if it was successfully added, false otherwise.
     */
    public boolean addStatusField(String name, int startAmount) {
        for (StatusType field : fields) {
            if (field.getName().equals(name)) {
                return false;
            }
        }
        StatusType toBeAdded = new StatusType(name);
        toBeAdded.increaseAmount(startAmount);

        fields.add(toBeAdded);
        return true;
    }

    /**
     * Simple method to increase a specific status type
     * 
     * @param field  the statusType to be added within'.
     * @param amount the amount to be added
     */
    public void increaseStatus(StatusType field, int amount) {

        field.increaseAmount(amount);
    }

    /**
     * Simple method to decrease a specific status type
     * 
     * @param field  the statusType to be subtracted within'.
     * @param amount the amount to be subtracted
     */
    public void decreaseStatus(StatusType field, int amount) {
        field.decreaseAmount(amount);
    }

    public List<StatusType> getStatus() {

        return fields;
    }

    @Override
    public String toString() {
        StringBuilder tableBuilder = new StringBuilder();

        for (StatusType type : fields) {
            tableBuilder.append(type.toString() + "\n");
        }

        return tableBuilder.toString();
    }

}

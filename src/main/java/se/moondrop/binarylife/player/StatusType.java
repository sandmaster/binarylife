package se.moondrop.binarylife.player;

import org.springframework.stereotype.Component;

/**
 * An object used by the Status class to handle its respective status of the
 * player.
 * <p>
 * 
 * 
 * @since 0.1 - pre-alpha
 * @version 0.1 - pre-alpha
 */
@Component
public class StatusType {

    private String name;
    private int amount;

    public StatusType(String name) {
        this.name = name;
        this.amount = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getAmount() {
        return this.amount;
    }

    public void increaseAmount(int amountToIncrease) {

        if (amountToIncrease > 0) {

            this.amount += amountToIncrease;
        }

    }

    public void decreaseAmount(int amountToDecrease) {

        if (amountToDecrease > 0) {
            if (amount - amountToDecrease < 0) {
                amount = 0;
            } else {
                this.amount -= amountToDecrease;
            }
        }

    }

    @Override
    public String toString() {
        return name + ": " + amount;
    }

}

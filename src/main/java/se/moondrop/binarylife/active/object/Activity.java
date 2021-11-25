package se.moondrop.binarylife.active.object;

import org.springframework.stereotype.Component;

@Component
public class Activity extends RepoObj {

    private String description = "No description entered for this activity";
    private double remValue;

    public Activity(String name, String desc, double rem){
        super(name);
        description = desc;
        remValue = rem;
    }

    public double getRemValue() {
        return remValue;
    }

    public void setRemValue(double remValue) {
        this.remValue = remValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.getName() + " (" + description + ") : " + remValue;
    }
}

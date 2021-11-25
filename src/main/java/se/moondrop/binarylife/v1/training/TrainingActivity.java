package se.moondrop.binarylife.v1.training;

public class TrainingActivity {

    private String activityName;
    private double remValueForActivity;

    public TrainingActivity(String activityName, double remValueForActivity) {
        this.activityName = activityName;
        this.remValueForActivity = remValueForActivity;
    }

    public TrainingActivity(){

    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public double getRemValueForActivity() {
        return remValueForActivity;
    }

    public void setRemValueForActivity(double remValueForActivity) {
        if(remValueForActivity < 0){
            return;
        }

        this.remValueForActivity = remValueForActivity;
    }

    @Override
    public String toString() {
        return "TrainingActivity{" +
                "activityName='" + activityName + '\'' +
                ", remValueForActivity=" + remValueForActivity +
                '}';
    }
}

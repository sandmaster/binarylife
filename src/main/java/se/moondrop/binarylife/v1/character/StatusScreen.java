package se.moondrop.binarylife.v1.character;

public class StatusScreen {

    /**
     * A characters' status screen, shows the characters current status
     */

    private String name;
    private int weight;
    private Level level;

    public StatusScreen(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.level = new Level();
    }

    public String getName() {
        return name;
    }
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "StatusScreen{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", level=" + level +
                '}';
    }
}


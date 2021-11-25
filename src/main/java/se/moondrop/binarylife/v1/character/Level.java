package se.moondrop.binarylife.v1.character;

public class Level {

    private int characterLevel = 0;
    private long characterExperience = 0;
    private long characterExperienceLevelUp;

    public Level() {
        characterExperienceLevelUp = 100;
    }

    public int getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(int characterLevel) {
        if(characterLevel < 0){
            return;
        }
        this.characterLevel = characterLevel;
    }

    public long getCharacterExperience() {
        return characterExperience;
    }

    public void setCharacterExperience(long characterExperience) {
        if(characterExperience <= 0){
            return;
        }
        this.characterExperience = characterExperience;
    }

    public long getCharacterExperienceLevelUp() {
        return characterExperienceLevelUp;
    }

    public void setCharacterExperienceLevelUp(long characterExperienceLevelUp) {
        if(characterExperienceLevelUp <= 0){
            return;
        }
        this.characterExperienceLevelUp = characterExperienceLevelUp;
    }

    public void update(){
        // Calculate updated experience...
        characterExperienceLevelUp *= 1.10;
        characterExperienceLevelUp += 45;

    }

    @Override
    public String toString() {
        return "Level{" +
                "characterLevel=" + characterLevel +
                ", characterExperience=" + characterExperience +
                ", characterExperienceLevelUp=" + characterExperienceLevelUp +
                '}';
    }
}

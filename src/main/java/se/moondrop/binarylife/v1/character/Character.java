package se.moondrop.binarylife.v1.character;

import org.springframework.stereotype.Component;

@Component
public class Character {

    /**
     * Represents a character in this application
     *
     * A character is bound to a user object
     * Each character will have a status screen
     */

    private String characterUserId;
    private String characterId;
    private StatusScreen statusScreen;

    public Character(String characterUserId, String name, int weight) {
        this.characterUserId = characterUserId;
        this.statusScreen = new StatusScreen(name, weight);
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }

    public String getCharacterUserId() {
        return characterUserId;
    }

    public String getCharacterId() {
        return characterId;
    }

    public StatusScreen getStatusScreen() {
        return statusScreen;
    }

    @Override
    public String toString() {
        return "Character{" +
                "characterUserId='" + characterUserId + '\'' +
                ", characterId='" + characterId + '\'' +
                ", statusScreen=" + statusScreen +
                '}';
    }
}

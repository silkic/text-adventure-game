import java.util.Scanner;

// TextAdventure.java
public class textAdventure {
    public static void main(String[] args) {
        AdventureModel model = new AdventureModel();
        Adventurer adventurer = new Adventurer(model.getStartRoom());
        model.startGame(adventurer);
    }
}

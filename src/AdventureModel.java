
// AdventureModel.java
import java.util.HashMap;
import java.util.Scanner;

public class AdventureModel {
    private HashMap<String, Room> rooms;
    private Room startRoom;

    public AdventureModel() {
        rooms = new HashMap<>();
        initializeRooms();
    }

    private void initializeRooms() {
        // Create rooms
        Room foyer = new Room("You are in the foyer. There is a door to the north.");
        Room library = new Room("You are in the library. There is a door to the south.");

        // Set exits
        foyer.setExit("north", library);
        library.setExit("south", foyer);

        // Add items
        foyer.addItem("key");
        library.addItem("book");

        // Add rooms to the hashmap
        rooms.put("foyer", foyer);
        rooms.put("library", library);

        // Set the starting room
        startRoom = foyer;
    }

    public Room getStartRoom() {
        return startRoom;
    }

    public void startGame(Adventurer adventurer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println(adventurer.getCurrentRoom().getDescription());

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            String[] command = input.split(" ");

            switch (command[0]) {
                case "go":
                    if (command.length > 1) {
                        adventurer.move(command[1]);
                    } else {
                        System.out.println("Go where?");
                    }
                    break;
                case "look":
                    adventurer.look();
                    break;
                case "take":
                    if (command.length > 1) {
                        adventurer.take(command[1]);
                    } else {
                        System.out.println("Take what?");
                    }
                    break;
                case "drop":
                    if (command.length > 1) {
                        adventurer.drop(command[1]);
                    } else {
                        System.out.println("Drop what?");
                    }
                    break;
                case "use":
                    if (command.length > 1) {
                        adventurer.use(command[1]);
                    } else {
                        System.out.println("Use what?");
                    }
                    break;
                case "exit":
                    System.out.println("Thank you for playing. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }
}
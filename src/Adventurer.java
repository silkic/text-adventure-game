import java.util.ArrayList;

public class Adventurer {
        private Room currentRoom;
        private ArrayList<String> inventory;

        public Adventurer(Room startRoom) {
                currentRoom = startRoom;
                inventory = new ArrayList<>();
        }

        public Room getCurrentRoom() {
                return currentRoom;
        }

        public void move(String direction) {
                Room nextRoom = currentRoom.getExit(direction);
                if (nextRoom != null) {
                        currentRoom = nextRoom;
                        System.out.println("You move " + direction + ".");
                        System.out.println(currentRoom.getDescription());
                } else {
                        System.out.println("You can't go that way.");
                }
        }

        public void look() {
                System.out.println(currentRoom.getDescription());
                if (!currentRoom.getItems().isEmpty()) {
                        System.out.println("You see the following items: " + String.join(", ", currentRoom.getItems()));
                }
        }

        public void take(String item) {
                if (currentRoom.getItems().contains(item)) {
                        currentRoom.removeItem(item);
                        inventory.add(item);
                        System.out.println("You take the " + item + ".");
                } else {
                        System.out.println("There is no " + item + " here.");
                }
        }

        public void drop(String item) {
                if (inventory.contains(item)) {
                        inventory.remove(item);
                        currentRoom.addItem(item);
                        System.out.println("You drop the " + item + ".");
                } else {
                        System.out.println("You don't have a " + item + ".");
                }
        }

        public void use(String item) {
                if (inventory.contains(item)) {
                        System.out.println("You use the " + item + ".");
                        // Implement specific use cases for items
                } else {
                        System.out.println("You don't have a " + item + ".");
                }
        }
}

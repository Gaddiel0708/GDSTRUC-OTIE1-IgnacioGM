package Quiz2;

public class Main {
    public static void main(String[] args) {
        Player kris = new Player(1, "Kris", 100);
        Player susie = new Player(2, "Susie", 150);
        Player ralsei = new Player(3, "Ralsei", 80);

        System.out.println("=== Testing Singly Linked List ===");
        LinkList playerList = new LinkList();

        playerList.add(kris);
        playerList.add(susie);
        playerList.add(ralsei);

        playerList.printList();
        System.out.println("Current Size: " + playerList.size());

        System.out.println("Contains Susie? " + playerList.contains(new Player(2, "Susie", 150)));
        System.out.println("Index of Kris: " + playerList.indexOf(kris));

        Player removed = playerList.removeFirst();
        System.out.println("Removed Quiz2.Player: " + removed);
        playerList.printList();
        System.out.println("New Size: " + playerList.size());

        System.out.println("\n=== Testing Doubly Linked List ===");
        Doublelinkedlist doublyList = new Doublelinkedlist();

        doublyList.add(kris);
        doublyList.add(susie);
        doublyList.add(ralsei);

        doublyList.printList();
        System.out.println("Doubly List Size: " + doublyList.size());

        Player doublyRemoved = doublyList.removeFirst();
        System.out.println("Removed from Doubly List: " + doublyRemoved);
        doublyList.printList();
        System.out.println("New Doubly List Size: " + doublyList.size());
    }
}
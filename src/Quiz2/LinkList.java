package Quiz2;

public class LinkList {
    private PlayerNode head;
    private int size = 0; // In-place counter


    public void add(Player player) {
        PlayerNode node = new PlayerNode(player);
        node.setNextPlayer(head);
        head = node;
        size++;
    }


    public Player removeFirst() {
        if (head == null) {
            return null;
        }

        Player removedPlayer = head.getPlayer();
        head = head.getNextPlayer();
        size--;

        return removedPlayer;
    }


    public int size() {
        return size;
    }


    public int indexOf(Player player) {
        PlayerNode current = head;
        int index = 0;

        while (current != null) {
            if (current.getPlayer().equals(player)) {
                return index;
            }
            current = current.getNextPlayer();
            index++;
        }

        return -1;
    }


    public boolean contains(Player player) {
        return indexOf(player) != -1;
    }


    public void printList() {
        PlayerNode currentNode = head;
        System.out.print("HEAD -> ");

        while (currentNode != null) {
            System.out.print(currentNode.getPlayer() + " -> ");
            currentNode = currentNode.getNextPlayer();
        }

        System.out.println("null");
    }
}
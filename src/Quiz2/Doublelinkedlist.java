package Quiz2;

public class Doublelinkedlist {
    private PlayerNode head;
    private PlayerNode tail;
    private int size = 0;

    public void add(Player player) {
        PlayerNode node = new PlayerNode(player);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNextPlayer(head);
            head.setPrevPlayer(node);
            head = node;
        }
        size++;
    }


    public Player removeFirst() {
        if (head == null) {
            return null;
        }

        Player removedPlayer = head.getPlayer();

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNextPlayer();
            head.setPrevPlayer(null);
        }

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
        System.out.print("HEAD <-> ");

        while (currentNode != null) {
            System.out.print(currentNode.getPlayer() + " <-> ");
            currentNode = currentNode.getNextPlayer();
        }

        System.out.println("null");
    }
}
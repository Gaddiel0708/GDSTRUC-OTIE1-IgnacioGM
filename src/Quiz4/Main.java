package Quiz4;

public class Main {
    public static void main(String[] args) {
        Player alcremie = new Player(869, "Alcremie", 10);
        Player rotom = new Player(479, "Rotom", 10);
        Player oshawott = new Player(501, "Oshawott", 10);
        Player pawmi = new Player(921, "Pawmi", 10);
        Player piplup = new Player(393, "Piplup", 10);
        Player rowlet = new Player(722, "Rowlet", 10);

        Hashtable hashtable = new Hashtable();
        hashtable.put(alcremie.getUserName(), alcremie);
        hashtable.put(rotom.getUserName(), rotom);
        hashtable.put(oshawott.getUserName(), oshawott);
        hashtable.put(pawmi.getUserName(), pawmi);
        hashtable.put(piplup.getUserName(), piplup);
        hashtable.put(rowlet.getUserName(), rowlet);

        System.out.println("\n");

        hashtable.printHashtable();
    }
}
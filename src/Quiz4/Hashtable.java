package Quiz4;

public class Hashtable {
    private SavedPlayer[] hashtable;

    public Hashtable() {
        hashtable = new SavedPlayer[10];
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public boolean isOccupied(int hashedKey) {
        return hashtable[hashedKey] != null;
    }

    public void put(String key, Player player) {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey)) {
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (hashedKey != stoppingIndex && isOccupied(hashedKey)) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey)) {
            System.out.println("Value already exists at bucket " + hashedKey);
            return;
        }

        hashtable[hashedKey] = new SavedPlayer(key, player);
    }

    public int findKey(String key) {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key))
            return hashedKey;

        int stoppingIndex = hashedKey;

        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stoppingIndex &&
                isOccupied(hashedKey) &&
                !hashtable[hashedKey].getKey().equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key))
            return hashedKey;

        return -1;
    }

    public Player get(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
            return null;

        return hashtable[hashedKey].getPlayer();
    }

    public void remove(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            System.out.println("Key not found: " + key);
            return;
        }

        hashtable[hashedKey] = null;

        int nextIndex = (hashedKey + 1) % hashtable.length;
        while (isOccupied(nextIndex)) {
            SavedPlayer savedPlayer = hashtable[nextIndex];
            hashtable[nextIndex] = null;
            put(savedPlayer.getKey(), savedPlayer.getPlayer());
            nextIndex = (nextIndex + 1) % hashtable.length;
        }
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            Player player = null;

            if (isOccupied(i)) {
                player = hashtable[i].getPlayer();
            }

            System.out.println("Value at bucket " + i + " - " + player);
        }
    }
}

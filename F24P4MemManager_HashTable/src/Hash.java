// On my honor:
// - I have not used source code obtained from another current or
// former student, or any other unauthorized source, either
// modified or unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.
/**
 * Hash table class
 *
 * @author Andres Zaidan
 * @version 2, Sept 2024
 */

public class Hash {

    // Fields
    private Record[] allRecords;
    private int numOfRecords;
    private Record tombstone;

    // Constructor
    /**
     * Constructor for the Hash table class.
     * Initializes the hash table with a given size.
     * 
     * @param size
     *            The initial size of the hash table.
     */
    public Hash(int size) {
        this.allRecords = new Record[size];
        this.numOfRecords = 0;
        this.tombstone = new Record("TOMBSTONE", null);

    }


    // methods
    /**
     * Returns the number of records currently in the hash table.
     * 
     * @return The number of records in the hash table.
     */
    public int getNumOfRecords() {
        return this.numOfRecords;
    }


    /**
     * Returns the array of all records in the hash table.
     * 
     * @return An array of all records.
     */
    public Record[] getAllRecords() {
        return this.allRecords;
    }


    /**
     * Returns the Tombstone record used for marking deleted entries.
     * 
     * @return The Tombstone record.
     */
    public Record getTombstone() {
        return this.tombstone;
    }


    /**
     * Inserts a new record into the hash table using quadratic probing if
     * necessary.
     * 
     * @param key
     *            The key (artist or song) to be inserted into the hash table.
     * @param node
     *            The node;
     */
    public void insert(String key, Node node) {
        if (numOfRecords >= allRecords.length / 2) {
            resize();
        }

        int home = h(key, allRecords.length);
        int i = 0;
        int pos = home;

        while (allRecords[pos] != null && allRecords[pos] != tombstone) {
            if (i < allRecords.length) {
                i++;
                pos = (home + (i * i));
                pos = pos % allRecords.length;
            }
        }

        allRecords[pos] = new Record(key, node);
        numOfRecords++;
    }


    /**
     * Removes a record from the hash table, marking its position with a
     * Tombstone.
     * 
     * @param key
     *            The key of the record to be removed.
     */
    public void remove(String key) {
        int home = h(key, allRecords.length);
        int i = 0;
        int pos = home;

        while (allRecords[pos] != null) {
            if (allRecords[pos].getKey().equals(key)
                && allRecords[pos] != tombstone) {
                allRecords[pos] = tombstone;
                numOfRecords--;
                return;
            }
            i++;
            pos = (home + i * i) % allRecords.length;
        }
    }


    /**
     * Searches for a record in the hash table.
     * 
     * @param key
     *            The key to search for.
     * @return True if the key is found, false otherwise.
     */
    public boolean find(String key) {
        int home = h(key, allRecords.length);
        int i = 0;
        int pos = home;

        while (allRecords[pos] != null && i < allRecords.length) {
            if (allRecords[pos].getKey().equals(key)
                && allRecords[pos] != tombstone) {
                return true;
            }
            i++;
            pos = (home + i * i) % allRecords.length;
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * gets the record from the hash table given the key
     * 
     * @param key
     *            the key
     * @return the record
     */
    public Record getRecord(String key) {
        int home = h(key, allRecords.length);
        int i = 0;
        int pos = home;

        while (allRecords[pos] != null && i < allRecords.length) {
            if (allRecords[pos].getKey().equals(key)
                && allRecords[pos] != tombstone) {
                return allRecords[pos];
            }
            i++;
            pos = (home + i * i) % allRecords.length;
        }
        return null;
    }


    /**
     * Prints all records in the hash table.
     */
    public void print() {

        for (int i = 0; i < allRecords.length; i++) {
            if (allRecords[i] != null && allRecords[i] != tombstone) {
                System.out.println("" + i + ": |" + allRecords[i].getKey()
                    + "|");

            }
            if (allRecords[i] == tombstone) {
                System.out.println("" + i + ": " + allRecords[i].getKey());
            }
        }

    }


    /**
     * Resizes the hash table when it becomes half full, rehashing all
     * non-tombstone records.
     */
    private void resize() {
        Record[] old = allRecords;
        Record[] newRecord = new Record[allRecords.length * 2];
        this.allRecords = newRecord;
        numOfRecords = 0;

        for (Record record : old) {
            if (record != tombstone && record != null) {
                insert(record.getKey(), record.getNode());
            }
        }

    }


    /**
     * Compute the hash function
     * 
     * @param s
     *            The string that we are hashing
     * @param length
     *            Length of the hash table (needed because this method is
     *            static)
     * @return
     *         The hash function value (the home slot in the table for this key)
     */
    public static int h(String s, int length) {
        int intLength = s.length() / 4;
        long sum = 0;
        for (int j = 0; j < intLength; j++) {
            char[] c = s.substring(j * 4, (j * 4) + 4).toCharArray();
            long mult = 1;
            for (int k = 0; k < c.length; k++) {
                sum += c[k] * mult;
                mult *= 256;
            }
        }

        char[] c = s.substring(intLength * 4).toCharArray();
        long mult = 1;
        for (int k = 0; k < c.length; k++) {
            sum += c[k] * mult;
            mult *= 256;
        }

        return (int)(Math.abs(sum) % length);
    }

}

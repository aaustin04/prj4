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

public class Hash<E extends Comparable<E>>
{

    // Fields
    private Record<E>[] allRecords;
    private int numOfRecords;
    private final Record<E> tombstone;

    // Constructor
    /**
     * Constructor for the Hash table class. Initializes the hash table with a
     * given size.
     * 
     * @param size
     *            The initial size of the hash table.
     */
    @SuppressWarnings("unchecked")
    public Hash(int size)
    {
        this.allRecords = (Record<E>[])new Record[size];
        this.numOfRecords = 0;
        this.tombstone = new Record<>(-1, null);

    }


    // methods
    /**
     * Returns the number of records currently in the hash table.
     * 
     * @return The number of records in the hash table.
     */
    public int getNumOfRecords()
    {
        return this.numOfRecords;
    }


    /**
     * Returns the array of all records in the hash table.
     * 
     * @return An array of all records.
     */
    public Record<E>[] getAllRecords()
    {
        return this.allRecords;
    }


    /**
     * Returns the Tombstone record used for marking deleted entries.
     * 
     * @return The Tombstone record.
     */
    public Record<E> getTombstone()
    {
        return this.tombstone;
    }


    /**
     * Inserts a new record into the hash table using quadratic probing if
     * necessary.
     * 
     * @param id
     *            The key (artist or song) to be inserted into the hash table.
     * @param sem
     *            The seminar;
     */
    public void insert(int id, E sem)
    {
        if (numOfRecords >= allRecords.length / 2)
        {
            resize();
        }

        int home = h(id, allRecords.length);
        int i = 0;
        int pos = home;

        while (allRecords[pos] != null && allRecords[pos] != tombstone)
        {
            if (i < allRecords.length)
            {
                i++;
                pos = ((home + (((i * i) + i) / 2)));
                pos = pos % allRecords.length;
            }
        }

        allRecords[pos] = new Record<>(id, sem);
        numOfRecords++;
    }


    /**
     * Removes a record from the hash table, marking its position with a
     * Tombstone.
     * 
     * @param id
     *            The key of the record to be removed.
     */
    public void remove(int id)
    {
        int home = h(id, allRecords.length);
        int i = 0;
        int pos = home;

        while (allRecords[pos] != null)
        {
            if (allRecords[pos].key() == id && allRecords[pos] != tombstone)
            {
                allRecords[pos] = tombstone;
                numOfRecords--;
                return;
            }
            i++;
            pos = ((home + (((i * i) + i) / 2))) % allRecords.length;
        }
    }


    /**
     * Searches for a record in the hash table.
     * 
     * @param id
     *            The key to search for.
     * @return True if the key is found, false otherwise.
     */
    public boolean find(int id)
    {
        int home = h(id, allRecords.length);
        int i = 0;
        int pos = home;

        while (allRecords[pos] != null && i < allRecords.length)
        {
            if (allRecords[pos].key() == id && allRecords[pos] != tombstone)
            {
                return true;
            }
            i++;
            pos = ((home + (((i * i) + i) / 2))) % allRecords.length;
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * gets the record from the hash table given the key
     * 
     * @param id
     *            the key
     * @return the record
     */
    public Record<E> getRecord(int id)
    {
        int home = h(id, allRecords.length);
        int i = 0;
        int pos = home;

        while (allRecords[pos] != null && i < allRecords.length)
        {
            if (allRecords[pos].key() == id && allRecords[pos] != tombstone)
            {
                return allRecords[pos];
            }
            i++;
            pos = ((home + (((i * i) + i) / 2))) % allRecords.length;
        }
        return null;
    }


    /**
     * Prints all records in the hash table.
     */
    public void print()
    {
        int count = 0;
        for (int i = 0; i < allRecords.length; i++)
        {
            if (allRecords[i] != null && allRecords[i] != tombstone)
            {
                System.out.println("" + i + ": " + allRecords[i].key());
                count++;

            }
            if (allRecords[i] == tombstone)
            {
                System.out.println("" + i + ": TOMBSTONE");
            }

        }
        System.out.println("total records: " + count);

    }


    /**
     * Resizes the hash table when it becomes half full, rehashing all
     * non-tombstone records.
     */
    @SuppressWarnings("unchecked")
    private void resize()
    {
        Record<E>[] old = allRecords;
        Record<E>[] newRecord = new Record[allRecords.length * 2];
        this.allRecords = newRecord;
        numOfRecords = 0;

        for (Record<E> record : old)
        {
            if (record != tombstone && record != null)
            {
                insert(record.key(), record.value());
            }
        }

    }


    /**
     * Compute the hash function
     * 
     * @param key
     *            The string that we are hashing
     * @param length
     *            Length of the hash table (needed because this method is
     *            static)
     * @return The hash function value (the home slot in the table for this key)
     */
    public static int h(int key, int length)
    {
        return key % length;
    }

}

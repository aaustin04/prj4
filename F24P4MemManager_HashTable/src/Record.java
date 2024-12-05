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
// -------------------------------------------------------------------------
/**
 * Record Class, that contains both a String key, and Node node. The Key
 * referring to the artist name, song title and the Node containing a reference
 * to the adjacency list graph. Contains both simple Getters and Setters.
 * 
 * @author Andres Zaidan
 * @version Sep 4, 2024
 * @param <E> generic typing for ease of use
 */
public class Record<E>
    implements Comparable<Record<E>>
{

    private int theKey;

    private E theVal;

    // ----------------------------------------------------------
    /**
     * Create a new KVPair object.
     * 
     * @param k
     *            the key
     * @param v
     *            the value
     */
    public Record(int k, E v)
    {
        theKey = k;
        theVal = v;
    }


//    /**
//     * Compares against a keyvalue pair.
//     * 
//     * @param it
//     *            the object to compare
//     * @return It bigger than 0 smaller, lower than 0 larger
//     */
//    public int compareTo1(Record<E> it)
//    {
//        return Integer.compare(this.theKey, it.theKey);
//    }


    // Compare against a key
    // ----------------------------------------------------------
//    /**
//     * Compares against a key
//     * 
//     * @param key
//     *            the key to compare
//     * @return Int bigger than 0 smaller, lower than 0 larger
//     */
//    public int compareTo(int key)
//    {
//        return Integer.compare(this.theKey, key);
//    }
//

    // ----------------------------------------------------------
    /**
     * returns the key
     * 
     * @return key
     */
    public int key()
    {
        return theKey;
    }


    // ----------------------------------------------------------
    /**
     * returns the value
     * 
     * @return val
     */
    public E value()
    {
        if (theVal != null)
        {
            return theVal;
        }
        return null;
    }


    @Override
    public int compareTo(Record<E> o)
    {
        return 0;
    }
}

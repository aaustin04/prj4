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
 */
public class Record {
    // ~ Fields ................................................................
    private String key; // could be artist/song
    private Node node; // links to the adjacency list.

    // ~ Constructors ..........................................................

    /**
     * Constructor for the Record class.
     * Initializes the Record with a key and node.
     * 
     * @param nKey
     *            The key (artist or song).
     * 
     * @param nNode
     *            The Node associated with the key.
     * 
     */
    public Record(String nKey, Node nNode) {
        this.key = nKey;
        this.node = nNode;
    }

    // ~Public Methods ........................................................


    /**
     * Returns the key associated with the record.
     * 
     * @return The key as a String (artist or song).
     */
    public String getKey() {
        return this.key;
    }


    /**
     * Returns the Node associated with the record.
     * 
     * @return The Node associated with the key.
     */
    public Node getNode() {
        return this.node;
    }


    /**
     * Sets a new key for the record.
     * 
     * @param newKey
     *            The new key to be set (artist or song).
     */
    public void setKey(String newKey) {
        this.key = newKey;
    }


    /**
     * Sets a new Node for the record.
     * 
     * @param newNode
     *            The new Node to be associated with the key.
     */
    public void setNode(Node newNode) {
        this.node = newNode;
    }
}

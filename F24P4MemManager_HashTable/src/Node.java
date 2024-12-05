// -------------------------------------------------------------------------
/**
 * Creates a simple node to be used in DLL with a next and previous pointer.
 * 
 * @author Austin Anderson 
 * @author Andres Zaidan
 * @version Sep 17, 2024
 * @param <T> generic for data such that we want to interchange
 */
public class Node<T> {

    private T data;
    private Node<T> next;
    private int index;
    private Node<T> prev;

    // ----------------------------------------------------------
    /**
     * Create a new Node object.
     * 
     * @param data
     * @param index
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;

    }


    // ----------------------------------------------------------
    /**
     * Returns the data in the node.
     * 
     * @return data
     *         the data within the node
     */
    public T getData() {

        return data;

    }


    // ----------------------------------------------------------
    /**
     * Sets the data to the desired value.
     * 
     * @param data
     *            the desired data for the node
     */
    public void setData(T data) {

        this.data = data;

    }


    // ----------------------------------------------------------
    /**
     * Returns the node that lies within the pointer to the next node.
     * 
     * @return next
     *         the next node in the list
     */
    public Node<T> getNext() {

        return next;

    }


    // ----------------------------------------------------------
    /**
     * Sets the next node in the list with the specified Node.
     * 
     * @param next
     *            the new next node in the list
     */
    public void setNext(Node<T> next) {

        this.next = next;

    }


    // ----------------------------------------------------------
    /**
     * Returns the previous node in the list.
     * 
     * @return prev
     *         the previous node in the list
     */
    public Node<T> getPrev() {

        return prev;

    }


    // ----------------------------------------------------------
    /**
     * Sets the previous node in the list to the new desired node.
     * 
     * @param prev
     *            the new previous node
     */
    public void setPrev(Node<T> prev) {

        this.prev = prev;

    }


    // ----------------------------------------------------------
    /**
     * Returns the index of the node.
     * 
     * @return index
     *         the index of the nodeF
     */
    public int getIndex() {
        return index;
    }


    // ----------------------------------------------------------
    /**
     * Sets the index of node
     * 
     * @param index
     *            takes in the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

}

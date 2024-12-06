// -------------------------------------------------------------------------
/**
 * This class creates the Doubly Linked List with a head and tail node.
 * 
 * @author Harini Ramaswamy and Austin Anderson Lifted from cs2114 course given
 *             code
 * @version Sep 20, 2024
 * @param <T>
 *            generic type
 */

public class DoubleLL<T>
{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // ----------------------------------------------------------
    /**
     * Create a new DoubleLL object by calling the init() method.
     */
    public DoubleLL()
    {
        init();
    }


    private void init()
    {
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * Checks if the list is empty. Returns true if the size is equal to 0, and
     * false is not.
     * 
     * @return boolean Returns if size is equal to 0.
     */
    public boolean isEmpty()
    {
        return size == 0;
    }


    // ----------------------------------------------------------
    /**
     * Returns the size of the doubly linked list.
     * 
     * @return size The current size of the doubly linked list.
     */
    public int size()
    {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * Clears the current doubly linked list by reinitializing all the fields in
     * the object.
     */
    public void clear()
    {
        init();
    }


    // ----------------------------------------------------------
    /**
     * Returns the head node of the doubly linked list that leads the rest of
     * the values.
     * 
     * @return Node<T> head the first node in the DLL
     */
    public Node<T> getHead()
    {
        return head;
    }


    // ----------------------------------------------------------
    /**
     * Returns the head node of the doubly linked list that leads the rest of
     * the values.
     * 
     * @return Node<T> head the first node in the DLL
     */
    public Node<T> getTail()
    {
        return tail;
    }


    // ----------------------------------------------------------
    /**
     * Checks if the DLL contains a certain object, made here to check for any
     * generic type of object.
     * 
     * @param obj
     *            the generic object to check if DLL contains
     * @return boolean Returns true if DLL contains specified object, false if
     *             not.
     */
    public boolean contains(T obj)
    {

        return lastIndexOf(obj) != -1;
    }


    // ----------------------------------------------------------
    /**
     * Gets the node at the specific index in the DLL.
     * 
     * @param index
     *            index to retrieve object
     * @return T object present at specified index
     */
    public T get(int index)
    {
        return getNodeAtIndex(index).getData();
    }


    // ----------------------------------------------------------
    /**
     * Adds a new entry into the DLL by calling the other add method in the
     * class. Takes in a generic object that wants to be added.
     * 
     * @param newEntry
     *            the generic object that needs to be added
     */
    public void add(T newEntry)
    {
        add(size(), newEntry);
    }


    // ----------------------------------------------------------
    /**
     * Adds the given generic object according to the index specified. Checks
     * through each node beginning from the head to count to the correct index.
     * 
     * @param index
     *            the specified index where the node should be added
     * @param obj
     *            the generic object that needs to be added
     */
    public void add(int index, T obj)
    {

        if (obj == null)
        {
            throw new IllegalArgumentException(
                "Cannot add null " + "objects to a list");
        }

        Node<T> nodeAfter;
        if (index == size)
        {
            nodeAfter = tail;
        }
        else
        {
            nodeAfter = getNodeAtIndex(index);
        }

        Node<T> addition = new Node<T>(obj);
        addition.setPrev(nodeAfter.getPrev());
        addition.setNext(nodeAfter);
        nodeAfter.getPrev().setNext(addition);
        nodeAfter.setPrev(addition);
        size++;
    }


    // ----------------------------------------------------------
    /**
     * Adds the node to the end of the DLL.
     * 
     * @param data
     *            the generic object that intends to be added
     */
    // Method to add a node to the end of the list
    public void addToEnd(T data)
    {
        Node<T> newNode = new Node<T>(data);
        Node<T> nullNode = new Node<T>(null);

        
            add(size, data);
        
    }


    private Node<T> getNodeAtIndex(int index)
    {
        if (index < 0 || size() <= index)
        {
            throw new IndexOutOfBoundsException(
                "No element exists at " + index);
        }
        Node<T> current = head.getNext();
        for (int i = 0; i < index; i++)
        {
            current = current.getNext();
        }
        return current;
    }


    // ----------------------------------------------------------
    /**
     * Returns the last index that an object was identified.
     * 
     * @param obj
     *            the generic object that is being searched for
     * @return index the last index where the object is present
     */
    public int lastIndexOf(T obj)
    {
        Node<T> current = tail.getPrev();
        for (int i = size() - 1; i >= 0; i--)
        {
            if (current.getData().equals(obj))
            {
                return i;
            }
            current = current.getPrev();
        }
        return -1; // if we do not find it
    }


    // ----------------------------------------------------------
    /**
     * Removes a node according to the specified index. Resets the previous and
     * next node to exhibit a seamless transition.
     * 
     * @param index
     *            the index at which the node is being removed
     * @return boolean true if object was removed, false if not
     */
    public boolean remove(int index)
    {
        Node<T> nodeToRemove = getNodeAtIndex(index);
        nodeToRemove.getPrev().setNext(nodeToRemove.getNext());
        nodeToRemove.getNext().setPrev(nodeToRemove.getPrev());
        size--;
        return true;
    }


    // ----------------------------------------------------------
    /**
     * Removes a node according to the specified data. Resets the previous and
     * next node to exhibit a seamless transition.
     * 
     * @param data
     *            the generic object that is being removed
     * @return boolean true if removed, false if not
     */
    public boolean remove(T data)
    {
        Node<T> curr = head.getNext();
        while (!curr.equals(tail))
        {
            if (curr.getData().equals(data))
            {
                curr.getPrev().setNext(curr.getNext());
            }
            curr.getNext().setPrev(curr.getPrev());
            size--;
            return true;
        }
        curr = curr.getNext();

        return false;
    }

    // ----------------------------------------------------------
    /**
     * Prints the entire DLL into a String representation.
     * 
     * @return String printed DLL
     */
// @Override
// public String toString() {
// StringBuilder builder = new StringBuilder("{");
// if (!isEmpty()) {
// Node<T> currNode = head.getNext();
// while (currNode != tail) {
// T element = currNode.getData();
// builder.append(element.toString());
// if (currNode.getNext() != tail) {
// builder.append(", ");
// }
// currNode = currNode.getNext();
// }
// }
// builder.append("}");
// return builder.toString();
// }
}

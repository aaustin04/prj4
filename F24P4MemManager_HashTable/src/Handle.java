// -------------------------------------------------------------------------
/**
 * The handle contains the starting position and the length of the record for
 * data in memory.
 * 
 * @author Austin
 * @version Nov 18, 2024
 */
public class Handle
{
    // ~ Fields ................................................................
    private int start;
    private int length;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new Handle object.
     * 
     * @param start
     *            start position of the record
     * @param length
     *            length of the record in memory pool
     */
    public Handle(int start, int length)
    {
        this.start = start;
        this.length = length;
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * gets the start position
     * 
     * @return start an integer position
     */
    public int getStart()
    {
        return start;
    }


    // ----------------------------------------------------------
    /**
     * Gets the length of the record
     * 
     * @return length the length in memory
     */
    public int getLength()
    {
        return length;
    }
}

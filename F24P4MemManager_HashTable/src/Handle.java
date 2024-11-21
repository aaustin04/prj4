// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author Austin
 *  @version Nov 18, 2024
 */
public class Handle
{
    //~ Fields ................................................................
    private int start;
    private int length;
    //~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new Handle object.
     * @param start
     * @param length
     */
    public Handle(int start, int length)
    {
        this.start = start;
        this.length = length;
    }
    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return
     */
    public int getStart()
    {
        return start;
    }
    
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return
     */
    public int getLength()
    {
        return length;
    }
}

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Austin
 * @version Nov 18, 2024
 */
public class MemManager
{
    private byte[] memoryPool;
    private DoubleLL<FreeBlock> freeBlockList;

    private class FreeBlock
    {
        int start; 
        int size;
        
        FreeBlock(int start, int size)
        {
            this.start = start;
            this.size = size;
        }
    }
    // ----------------------------------------------------------
    /**
     * Constructor. 
     * 
     * @param poolsize
     *            defines the size of the memory pool in bytes
     */
    MemManager(int poolsize)
    {
        memoryPool = new byte[poolsize];
        freeBlockList = new DoubleLL<>();
        freeBlockList.add(new FreeBlock(0, poolsize));
    }


    // ----------------------------------------------------------
    /**
     * Insert a record and return its position handle. space contains the record
     * to be inserted, of length size.
     * 
     * @param space
     * @param size
     * @return
     */
    Handle insert(byte[] space, int size)
    {
      //  for (FreeBlock block : freeBlockList)
        {
          //  if(block.size >= size)
            System.arraycopy(space,0,memoryPool,start,size);
            
        }
    }


    // ----------------------------------------------------------
    /**
     * Return the length of the record associated with theHandle
     * 
     * @param theHandle
     * @return
     */
    int length(Handle theHandle)
    {
        return 0;
    }


    // ----------------------------------------------------------
    /**
     * Free a block at the position specified by theHandle. Merge adjacent free
     * blocks.
     * 
     * @param theHandle
     */
    void remove(Handle theHandle)
    {
    }


    // ----------------------------------------------------------
    /**
     * Read the record with handle posHandle, up to size bytes, by copying it
     * into space. Return the number of bytes actually copied into space.
     * 
     * @param space
     * @param theHandle
     * @param size
     * @return
     */
    int get(byte[] space, Handle theHandle, int size)
    {
        return 0;
    }


    // ----------------------------------------------------------
    /**
     * Dump a printout of the freeblock list
     */
    void dump()
    {
    }
}

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
    private int blockSize;

    private class FreeBlock
    {
        int start; 
        int size;
      
        
        FreeBlock(int start, int size)
        {
            this.start = start;
            this.size = size;
            
        }
        
        void setStart(int nS) 
        {
            this.start = nS;
        }
        void setSize(int s) 
        {
           this.size = s; 
            
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
        blockSize = poolsize;
        freeBlockList = new DoubleLL<>();
        freeBlockList.add(new FreeBlock(0, poolsize));
    }


    // ----------------------------------------------------------
    /**
     * Insert a record and return its position handle. space contains the record
     * to be inserted, of length size.
     * 
     * @param sem
     * @param size
     * @return the handle where the seminar was added to the mem pool.
     */
    public Handle insert(byte[] sem, int semSize)
    {
        Handle handle = null;
  
        for(int i = 0; i < freeBlockList.size(); i++) 
        {
           
        
            FreeBlock block = freeBlockList.get(i);
            
            if (block.size >= semSize) {
                // Insert the seminar into the storage
                System.arraycopy(sem, 0, memoryPool, block.start, semSize);
                handle = new Handle(block.start, semSize);
                // Update the free block list
                if (block.size == semSize) {
                    // Exact fit, remove the block
                    freeBlockList.remove(i);
                    
                } else {
                    // Partial fit, reduce the size of the block
                    block.setStart(block.start+semSize);
                    block.setSize(block.size - semSize);
                }
                
                return handle;
        }
        }
        if(handle == null) //no space for this seminar expand memory pool.
        {
            expand();
            insert(sem, semSize);
        }
        return handle;
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
    
    
    void merge() 
    {
        
    }
    
    void expand() 
    {
        
        byte[] newpool = new byte[memoryPool.length + blockSize];
        System.arraycopy(memoryPool, 0, newpool, 0, memoryPool.length);
        if(freeBlockList.size()==0) 
        {   
            freeBlockList.add(new FreeBlock(memoryPool.length, blockSize));
        }
        else {
            FreeBlock lb = freeBlockList.get(freeBlockList.size()-1);//lastblock
            if(lb.start+lb.size == memoryPool.length) //it is at the end 
            {
                lb.setSize(lb.size+blockSize);
            }
            else 
            {
                freeBlockList.add(new FreeBlock(memoryPool.length, blockSize));
                
            }
        }
        memoryPool = newpool;
        System.out.println("Memory pool expanded to "+memoryPool.length+" bytes");
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
    void print()
    {
        
        if(freeBlockList.size() == 0) 
        {
            System.out.println("There are no freeblocks in the memory pool");
        }
        else 
        {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < freeBlockList.size(); i++) {
                FreeBlock block = freeBlockList.get(i);
                result.append("(").append(block.start).append(",").append(block.size).append(")");
                
                if (i < freeBlockList.size() - 1) {
                    result.append(" -> "); // Add arrow except for the last block
                }
            }

            System.out.println(result);
        }
    }
}

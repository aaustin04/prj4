// -------------------------------------------------------------------------
/**
 * This class manages the memory pool witha Doubly Linked List of free blocks,
 * allowing for inserting removing and merging blocks.
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
        private int start;
        private int size;

        FreeBlock(int start, int size)
        {
            this.start = start;
            this.size = size;

        }


        public void setStart(int nS)
        {
            this.start = nS;
        }


        public void setSize(int s)
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
     *            the seminar serialized
     * @param semSize
     *            the size of the smerinar
     * @return the handle where the seminar was added to the mem pool.
     */
    public Handle insert(byte[] sem, int semSize)
    {
        Handle handle = null;

        for (int i = 0; i < freeBlockList.size(); i++)
        {

            FreeBlock block = freeBlockList.get(i);

            if (block.size >= semSize)
            {
                // Insert the seminar into the storage
                System.arraycopy(sem, 0, memoryPool, block.start, semSize);
                handle = new Handle(block.start, semSize);
                // Update the free block list
                if (block.size == semSize)
                {
                    // Exact fit, remove the block
                    freeBlockList.remove(i);

                }
                else
                {
                    // Partial fit, reduce the size of the block
                    block.setStart(block.start + semSize);
                    block.setSize(block.size - semSize);
                }

                return handle;
            }
        }
        if (handle == null) // no space for this seminar expand memory pool.
        {
            expand();
            handle = insert(sem, semSize);
        }
        return handle;
    }


    // ----------------------------------------------------------
    /**
     * Return the length of the record associated with theHandle
     * 
     * @param theHandle
     *            takes in the records start and length
     * @return the length of the record
     */
    public int length(Handle theHandle)
    {
        return 0;
    }


    // ----------------------------------------------------------
    /**
     * Free a block at the position specified by theHandle. Merge adjacent free
     * blocks.
     * 
     * @param theHandle
     *            the handle of a record.
     */
    public void remove(Handle theHandle)
    {
        int index = 0;

        // get the index to add the free block in a sorted order
        for (int i = 0; i < freeBlockList.size(); i++)
        {
            FreeBlock free = freeBlockList.get(i);
            if (free.start > theHandle.getStart())
            {
                index = i;
                break;
            }
            index = i + 1;
        }

        // Insert the freeblock at the index
        freeBlockList.add(
            index,
            new FreeBlock(theHandle.getStart(), theHandle.getLength()));

        // Merge
        merge();
    }


    // ----------------------------------------------------------
    /**
     * Merges adjacent blocks together
     */
    public void merge()
    {
        if (freeBlockList.size() > 1)
        {
            DoubleLL<FreeBlock> mergedList = new DoubleLL<FreeBlock>();
            FreeBlock prev = null;

            for (int i = 0; i < freeBlockList.size(); i++)
            {
                FreeBlock curr = freeBlockList.get(i);
                if (prev == null)
                {
                    // Start with the first block
                    prev = curr;
                }
                else if (prev.start + prev.size == curr.start)
                {
                    // Blocks are adjacent, merge them
                    prev.size += curr.size;
                }
                else
                {
                    // No adjacency, add the current block to the merged list
                    // and move to the next
                    mergedList.add(prev);
                    prev = curr;
                }
            }

            // Add the last block
            if (prev != null)
            {
                mergedList.add(prev);
            }

            // Replace free block list with the merged list
            freeBlockList = mergedList;
        }

    }


    // ----------------------------------------------------------
    /**
     * expands the memory pool by the blocksize;
     */
    public void expand()
    {

        byte[] newpool = new byte[memoryPool.length + blockSize];
        System.arraycopy(memoryPool, 0, newpool, 0, memoryPool.length);

        freeBlockList.add(new FreeBlock(memoryPool.length, blockSize));

        merge(); // merge the block we just added.

        memoryPool = newpool;
        System.out
            .println("Memory pool expanded to " + memoryPool.length + " bytes");
    }


    // ----------------------------------------------------------
    /**
     * Dump a printout of the freeblock list
     */
    public void print()
    {

        if (freeBlockList.size() == 0)
        {
            System.out.println("There are no freeblocks in the memory pool");
        }
        else
        {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < freeBlockList.size(); i++)
            {
                FreeBlock block = freeBlockList.get(i);
                result.append("(").append(block.start).append(",")
                    .append(block.size).append(")");

                if (i < freeBlockList.size() - 1)
                {
                    result.append(" -> "); // Add arrow except for the last
                                           // block
                }
            }

            System.out.println(result);
        }
    }
}

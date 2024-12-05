// -------------------------------------------------------------------------
/**
 * Controller Method for the BST and BinTrees, managed the system.
 * 
 * @author Andres Zaidan
 * @author Austin Anderson
 * @version Oct 1, 2024
 */
public class Controller
{
    // ~ Fields ................................................................
    private Hash<Seminar> seminarHash;
    private int hashSize;
    private int memSize;
    private MemManager memManager;

    // ----------------------------------------------------------
    /**
     * Create a new Controller object.
     * 
     * @param mem
     *            amount of memory coming into controller
     * @param hash
     *            size of has coming in from input
     */
    // ~ Constructors ..........................................................
    public Controller(int mem, int hash) // takes world size parameter when we
                                         // implement
    // bin tree
    {
        this.seminarHash = new Hash<Seminar>(hash);
        this.hashSize = hash;
        this.memSize = mem;
        this.memManager = new MemManager(mem);
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * insert method for inserting seminars into the binary tree and bin tree
     * 
     * @param semId
     *            id
     * @param semTitle
     *            title
     * @param date
     *            date
     * @param length
     *            length
     * @param x
     *            x
     * @param y
     *            y
     * @param cost
     *            cost
     * @param keywords
     *            keywords
     * @param description
     *            description
     * @param sem
     *            seminar object
     * @throws Exception
     */
    public void insert(
        int semId,
        String semTitle,
        String date,
        int length,
        double x,
        double y,
        double cost,
        String[] keywords,
        String description,
        Seminar sem)
        throws Exception
    {
        if (sem == null)
        {
            return;
        }

        if (seminarHash.find(semId))
        {
            System.out.println(
                "Insert FAILED - There is already a record with ID " + semId);
        }
        else
        {
            byte[] serialized = sem.serialize();
            Handle h = memManager.insert(sem.serialize(), serialized.length);
            sem.setHandle(h);

            seminarHash.insert(semId, sem);
            System.out.println("Successfully inserted record with ID " + semId);
            System.out.println(sem.toString());
            System.out.println("Size: " + sem.serialize().length);
            sem.setSize(sem.serialize().length);
        }

    }


    // ----------------------------------------------------------
    /**
     * Delete method, deletes from binary tree and bin tree.
     * 
     * @param semId
     *            id to look for id to look for
     */
    public void delete(int semId)
    {

        Record<Seminar> sem = seminarHash.getRecord(semId);
        seminarHash.remove(semId);

        if (sem != null)
        {
            memManager.remove(sem.value().getHandle());
            System.out.println(
                "Record with ID " + semId
                    + " successfully deleted from the database");
        }

        else
        {
            System.out.println(
                "delete FAILED -- There is no record with ID " + semId);
        }

    }


    // ----------------------------------------------------------
    /**
     * searches for an id in the idtree
     * 
     * @param id
     *            id to look for
     */
    public void searchID(int id)
    {
        if (seminarHash.find(id))
        {
            Seminar sem = seminarHash.getRecord(id).value();
            System.out.println("Found record with ID " + id + ":");
            System.out.println(sem.toString());
        }
        else
        {
            System.out
                .println("Search FAILED -- There is no record with ID " + id);
        }

    }


    // ----------------------------------------------------------
    /**
     * Takes in the type of tree we want to print, prints it with correct
     * formatting.
     * 
     * @param printType
     *            the type of print
     */
    public void print(String printType)
    {
        switch (printType)
        {
            case "hashtable":
                System.out.println("Hashtable:");
                seminarHash.print();
                break;

            case "blocks":
                System.out.println("Freeblock List:");
                memManager.print();
                break;

            default:
                System.out.println("Unknown print type: " + printType);
                break;
        }
    }
}

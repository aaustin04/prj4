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
    private int worldSize;

    // ----------------------------------------------------------
    /**
     * Create a new Controller object.
     * 
     * @param world
     *            the size of the bin tree.
     */
    // ~ Constructors ..........................................................
    public Controller(int world) // takes world size parameter when we implement
                                 // bin tree
    {
        this.seminarHash = new Hash<Seminar>(world);
        this.worldSize = world;
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
            seminarHash.insert(semId, sem);
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
// public void searchID(int id)
// {
// if (idTree.find(id) != null)
// {
// if (idTree.find(id) == id)
// {
// System.out.println("Found record with ID " + id + ":");
// System.out.println(idTree.findSeminar(id));
// }
//
// }
// else
// {
// System.out
// .println("Search FAILED -- There is no record with ID " + id);
// }
// }

    // ----------------------------------------------------------
    /**
     * searches for all seminars between a range of costs.
     * 
     * @param minCost
     *            the mincost
     * @param maxCost
     *            the maxcost
     */
// public void searchCost(int minCost, int maxCost)
// {
// // should print 3.
// int num = costTree.searchRange(minCost, maxCost);
// if (num != 0)
// {
// System.out.println("" + num + " nodes visited in this search");
// }
// }

    // ----------------------------------------------------------
    /**
     * searches for all seminars between a range of dates
     * 
     * @param startDate
     *            the startdate
     * @param endDate
     *            the enddate
     */
// public void searchDate(String startDate, String endDate)
// {
// int num = dateTree.searchRange(startDate, endDate);
// if (num != 0)
// {
// System.out.println("" + num + " nodes visited in this search");
// }
// }

    // ----------------------------------------------------------
    /**
     * searches for all seminars that match a keyword.
     * 
     * @param keyword
     *            the keyword
     */
// public void searchKeyword(String keyword)
// {
//
// keywordTree.searchRange(keyword, keyword);
//
// }

    // ----------------------------------------------------------
    /**
     * search method for bintree
     * 
     * @param x
     *            the x val
     * @param y
     *            the y val
     * @param radius
     *            the radius
     */
// public void searchLocation(int x, int y, int radius)
// {
// binTree.find(x, y, radius);
// }


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
                System.out.println("Hash Table:");
                seminarHash.print();
                break;
            default:
                System.out.println("Unknown print type: " + printType);
                break;
        }
    }
}

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
    private Lab14BinarySearchTree<Integer, Seminar> idTree;
    private Lab14BinarySearchTree<String, Seminar> dateTree;
    private Lab14BinarySearchTree<Integer, Seminar> costTree;
    private Lab14BinarySearchTree<String, Seminar> keywordTree;
    private int worldSize;
    private BinTree binTree;

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
        this.idTree = new Lab14BinarySearchTree<Integer, Seminar>();
        this.dateTree = new Lab14BinarySearchTree<String, Seminar>();
        this.costTree = new Lab14BinarySearchTree<Integer, Seminar>();
        this.keywordTree = new Lab14BinarySearchTree<String, Seminar>();
        this.worldSize = world;
        this.binTree = new BinTree(world);
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * insert method for inserting seminars into the binary tree and bin tree
     * 
     * @param sem
     *            seminar object
     */
    public void insert(Seminar sem)
    {

        if (sem != null)
        {

            if (sem.x() < 0 || sem.x() >= this.worldSize)
            {
                System.out.println(
                    "Insert FAILED - Bad x, y coordinates: " + sem.x() + ", "
                        + sem.y());
                return;
            }
            if (sem.y() < 0 || sem.y() >= this.worldSize)
            {
                System.out.println(
                    "Insert FAILED - Bad x, y coordinates: " + sem.x() + ", "
                        + sem.y());
                return;
            }

            if (idTree.find(sem.id()) == null)
            {

                idTree.insert(sem.id(), sem);
                dateTree.insert(sem.date(), sem);
                costTree.insert(sem.cost(), sem);
                binTree.insert(sem);
                for (String keyword : sem.keywords())
                {
                    keywordTree.insert(keyword, sem);
                }
                System.out.println(
                    "Successfully inserted record with ID " + sem.id());
                System.out.println(sem.toString());

            }
            else
            {
                System.out.println(
                    "Insert FAILED - There is already a record with ID "
                        + sem.id());
            }

        }
    }


    // ----------------------------------------------------------
    /**
     * Delete method, deletes from binary tree and bin tree.
     * 
     * @param id
     *            id to look for
     */
    public void delete(int id)
    {

        Seminar sem = idTree.findSeminar(id);
        idTree.remove(id);

        if (sem != null)
        {

            System.out.println(
                "Record with ID " + id
                    + " successfully deleted from the database");

            dateTree.remove(sem.date(), sem);

            costTree.remove(sem.cost(), sem);

            for (String keyword : sem.keywords())
            {
                keywordTree.remove(keyword, sem);
            }

            binTree.delete(sem);
        }

        else
        {
            System.out
                .println("delete FAILED -- There is no record with ID " + id);
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
        if (idTree.find(id) != null)
        {
            if (idTree.find(id) == id)
            {
                System.out.println("Found record with ID " + id + ":");
                System.out.println(idTree.findSeminar(id));
            }

        }
        else
        {
            System.out
                .println("Search FAILED -- There is no record with ID " + id);
        }
    }


    // ----------------------------------------------------------
    /**
     * searches for all seminars between a range of costs.
     * 
     * @param minCost
     *            the mincost
     * @param maxCost
     *            the maxcost
     */
    public void searchCost(int minCost, int maxCost)
    {
        // should print 3.
        int num = costTree.searchRange(minCost, maxCost);
        if (num != 0)
        {
            System.out.println("" + num + " nodes visited in this search");
        }
    }


    // ----------------------------------------------------------
    /**
     * searches for all seminars between a range of dates
     * 
     * @param startDate
     *            the startdate
     * @param endDate
     *            the enddate
     */
    public void searchDate(String startDate, String endDate)
    {
        int num = dateTree.searchRange(startDate, endDate);
        if (num != 0)
        {
            System.out.println("" + num + " nodes visited in this search");
        }
    }


    // ----------------------------------------------------------
    /**
     * searches for all seminars that match a keyword.
     * 
     * @param keyword
     *            the keyword
     */
    public void searchKeyword(String keyword)
    {

        keywordTree.searchRange(keyword, keyword);

    }


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
    public void searchLocation(int x, int y, int radius)
    {
        binTree.find(x, y, radius);
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
            case "ID":
                System.out.println("ID Tree:");
                idTree.printTree();

                break;
            case "location":
                System.out.println("Location Tree:");
                // implement logic
                binTree.print();
                break;
            case "cost":
                System.out.println("Cost Tree:");
                costTree.printTree();
                break;
            case "date":
                System.out.println("Date Tree:");
                dateTree.printTree();
                break;
            case "keyword":
                System.out.println("Keyword Tree:");
                keywordTree.printTree();
                break;
            default:
                System.out.println("Unknown print type: " + printType);
                break;
        }
    }
}

import java.io.File;
import java.util.Scanner;

// On my honor:
// - I have not used source code obtained from another current or
// former student, or any other unauthorized source, either
// modified or unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.
// -------------------------------------------------------------------------
/**
 * CommandProcessor class, processing the input file instructions line by line,
 * calling the Controller methods for functionality.
 * 
 * @author Andres Zaidan
 * @author Austin Anderson
 * @version Sep 11, 2024
 */
public class CommandProcessor
{
    // ~ Fields ................................................................
    private Controller controller;

    // ~ Constructors ..........................................................
    /**
     * Constructor for the CommandProcessor class. Initializes the
     * CommandProcessor with a Controller object.
     * 
     * @param control
     *            The Controller object used to perform operations based on the
     *            commands.
     */
    public CommandProcessor(Controller control)
    {
        this.controller = control;
    }

    // ~Public Methods ........................................................


    /**
     * Parses the input file line by line and processes the commands found in
     * the file. Based on the command type, the corresponding Controller method
     * is called.
     * 
     * @param filename
     *            The name of the input file containing the commands.
     */
    public void beginParsingByLine(String filename)
    {
        try
        {
            Scanner sc = new Scanner(new File(filename));
            Scanner scancmd; // Declare two scanners, one to read the file and
                             // one to read each line
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                scancmd = new Scanner(line);
                if (!scancmd.hasNext())
                {
                    continue;
                }
                String cmd = scancmd.next(); // Get the command on each line
                switch (cmd)
                {

                    case "insert":

                        int id = scancmd.nextInt();
                        String title = sc.nextLine().trim();
                        if (!sc.hasNextLine())
                        {
                            break;
                        }
                        line = sc.nextLine();
                        scancmd = new Scanner(line);
                        String date = scancmd.next().trim();
                        int length = scancmd.nextInt();
                        short x = scancmd.nextShort();
                        short y = scancmd.nextShort();
                        int cost = scancmd.nextInt();

                        if (!sc.hasNextLine())
                        {
                            break;
                        }

                        String[] keywords = sc.nextLine().trim().split("\\s+");

                        if (!sc.hasNextLine())
                        {
                            break;
                        }

                        String description = sc.nextLine().trim();
                        Seminar sem = new Seminar(
                            id,
                            title,
                            date,
                            length,
                            x,
                            y,
                            cost,
                            keywords,
                            description);
                        controller.insert(sem);

                        break;

                    case "delete":
                        int num = scancmd.nextInt();
                        controller.delete(num);
                        break;

                    case "print":
                        String printType = scancmd.next().trim();
                        controller.print(printType);

                        break;

                    case "search":
                        String searchType = scancmd.next().trim();
                        switch (searchType)
                        {
                            case "ID":
                                int searchID = scancmd.nextInt();
                                controller.searchID(searchID);

                                break;
                            case "keyword":
                                String keyword = scancmd.next().trim();
                                System.out.println(
                                    "Seminars matching keyword " + keyword
                                        + ":");
                                controller.searchKeyword(keyword);

                                break;
                            case "cost":
                                int minCost = scancmd.nextInt();
                                int maxCost = scancmd.nextInt();

                                System.out.println(
                                    "Seminars with costs in range " + minCost
                                        + " to " + maxCost + ":");
                                controller.searchCost(minCost, maxCost);
                                // not exactly sure why this doesnt work yet.

                                break;
                            case "location":
                                int searchX = scancmd.nextInt();
                                int searchY = scancmd.nextInt();
                                int radius = scancmd.nextInt();
                                System.out.println(
                                    "Seminars within " + radius + " units of "
                                        + searchX + ", " + searchY + ":");
                                controller
                                    .searchLocation(searchX, searchY, radius);

                                break;
                            case "date":
                                String startDate = scancmd.next().trim();
                                String endDate = scancmd.next().trim();
                                System.out.println(
                                    "Seminars with dates in range " + startDate
                                        + " to " + endDate + ":");
                                controller.searchDate(startDate, endDate);
                                break;
                            default:
                                System.out.println(
                                    "Unknown search type: " + searchType);
                                break;
                        }
                        break;

                    default:
                        System.out.println("Unrecognized input: " + cmd);
                        break;
                }
            }
            sc.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

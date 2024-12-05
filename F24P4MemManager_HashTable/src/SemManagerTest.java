
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
import student.TestCase;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class was designed to test the GraphProject
 * 
 * @author Andres Zaidan
 * @author Austin Anderson
 * @version Nov 15, 2024
 */
public class SemManagerTest
    extends TestCase
{
    // ----------------------------------------------------------
    /**
     * Read contents of a file into a string
     * 
     * @param path
     *            File name
     * @return the string
     * @throws IOException
     */
    static String readFile(String path)
        throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }


    /**
     * Set up the tests that follow.
     */
    public void setUp()
    { // Nothing needed yet

    }


    /**
     * Example 2: This method runs on a command sample IO file You will write
     * similar test cases using different text files
     *
     * @throws Exception
     */
    public void testSampleIO()
        throws Exception
    {
        // Setting up all the parameters
        String[] args = new String[3];
        args[0] = "512";
        args[1] = "8";
        args[2] = "administracion.txt";

        // Invoke main method of our Graph Project
        SemManager.main(args);

        // Actual output from your System console
        String actualOutput = systemOut().getHistory();

        // Expected output from file
        String expectedOutput = readFile("administracionOut.txt");

        // Compare the two outputs

        assertFuzzyEquals(expectedOutput, actualOutput);

    }


    /**
     * Example 2: This method runs on a command sample IO file You will write
     * similar test cases using different text files
     *
     * @throws Exception
     */
    public void testSampleIO2()
        throws Exception
    {
        // Setting up all the parameters
        String[] args = new String[3];
        args[0] = "512";
        args[1] = "8";
        args[2] = "P4SimpSample_input.txt";

        // Invoke main method of our Graph Project
        SemManager.main(args);

        // Actual output from your System console
        String actualOutput = systemOut().getHistory();

        // Expected output from file
        String expectedOutput = readFile("P4SimpSample_output.txt");

        // Compare the two outputs

        assertFuzzyEquals(expectedOutput, actualOutput);

    }

}

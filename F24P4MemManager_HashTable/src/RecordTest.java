
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

// -------------------------------------------------------------------------
/**
 * Test Class for the Record Class, Tests both Getter and Setter methods to
 * check functionality.
 * 
 * @author Andres Zaidan
 * @version Sep 11, 2024
 */
public class RecordTest extends TestCase {
    // ~ Fields ................................................................
    private Record<Integer> testRecord;
    private int testNum;

    // ~ setUp ..........................................................
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        testNum = 1;
        testRecord = new Record<Integer>(1, testNum);
    }


    // ~Test Methods ........................................................
    /**
     * Test methods for both Key and Node Getter methods.
     */
    public void testGetters() {
        assertTrue(testNum == testRecord.value());
        assertEquals(1, testRecord.key());
    }


    // ----------------------------------------------------------
    /**
     * test value is null
     */
    public void testNull() {
        Record<Integer> n = new Record<Integer>(1, null);
        assertNull(n.value());
    }


    // ----------------------------------------------------------
    /**
     * compare
     */
    public void testCompare() {
        assertEquals(0, testRecord.compareTo(testRecord));
    }

}

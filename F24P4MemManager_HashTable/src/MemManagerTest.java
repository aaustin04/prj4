
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
public class MemManagerTest extends TestCase {
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................
    /**
     * initialized the test fixture
     */
    public void setUp() {
        // nothing is needed
    }


    // ----------------------------------------------------------
    /**
     * Tests the constructor and fields
     */
    public void testConstructor() {
        MemManager test = new MemManager(8);
        assertEquals(8, test.getMem().length);
        assertEquals(8, test.getBlockSize());
        assertNotNull(test.freeBlockList());
    }


    // ----------------------------------------------------------
    /**
     * Tests the insert method
     */
    public void testInsert() {
        MemManager manager = new MemManager(100);
        byte[] seminar = new byte[30];
        Handle handle = manager.insert(seminar, 30);

        assertNotNull(handle);
        assertEquals(0, handle.getStart());
        assertEquals(30, handle.getLength());

        assertEquals(1, manager.freeBlockList().size());
    }


    /**
     * Tests the insert method
     */
    public void testInsertnull() {
        MemManager manager = new MemManager(5);
        byte[] seminar = new byte[30];
        Handle handle = manager.insert(seminar, 30);

        assertNotNull(handle);
        assertEquals(0, handle.getStart());
        assertEquals(30, handle.getLength());

        assertEquals(0, manager.freeBlockList().size());
    }


    // ----------------------------------------------------------
    /**
     * test expand
     */
    public void testExpand() {
        MemManager manager = new MemManager(100);
        byte[] seminar1 = new byte[50];
        byte[] seminar2 = new byte[60];

        manager.insert(seminar1, 50);
        assertEquals(1, manager.freeBlockList().size());

        Handle handle2 = manager.insert(seminar2, 60);

        assertEquals(200, manager.getMem().length);
        assertEquals(1, manager.freeBlockList().size());
    }


    // ----------------------------------------------------------
    /**
     * Tests the remove methods
     */
    public void testRemove() {
        MemManager manager = new MemManager(100);
        byte[] seminar1 = new byte[40];
        byte[] seminar2 = new byte[30];
        byte[] seminar3 = new byte[20];

        Handle handle1 = manager.insert(seminar1, 40);
        Handle handle2 = manager.insert(seminar2, 30);
        Handle handle3 = manager.insert(seminar3, 20);

        manager.remove(handle2);

        assertEquals(2, manager.freeBlockList().size());
    }


    // ----------------------------------------------------------
    /**
     * Tests merge
     */
    public void testMergingBlocks() {
        MemManager manager = new MemManager(100);
        byte[] seminar1 = new byte[30];
        byte[] seminar2 = new byte[40];
        byte[] seminar3 = new byte[20];

        Handle handle1 = manager.insert(seminar1, 30);
        Handle handle2 = manager.insert(seminar2, 40);
        Handle handle3 = manager.insert(seminar3, 20);

        manager.remove(handle1);

        manager.remove(handle2);

        assertEquals(2, manager.freeBlockList().size());

        manager.remove(handle3);

        assertEquals(1, manager.freeBlockList().size());
    }


    // ----------------------------------------------------------
    /**
     * tests print
     */
    public void testPrint() {
        MemManager manager = new MemManager(100);
        byte[] seminar1 = new byte[30];
        byte[] seminar2 = new byte[40];

        manager.insert(seminar1, 30);
        manager.insert(seminar2, 40);

        manager.print();

        String expected = "(70,30)";
        String output = systemOut().getHistory();

        assertFuzzyEquals(expected, output);
    }

}

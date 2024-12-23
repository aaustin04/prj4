
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

/**
 * TestClass for Hash class, tests its functionality.
 * 
 * @author Andres Zaidan
 * @version 2, Sept 2024
 */
public class HashTest extends TestCase {

    private Hash<String> testHash;
    private Hash<String> hash;

    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        testHash = new Hash<>(4);
        hash = new Hash<>(4);

    }

//
// /**
// * Tests the Insert Method
// */
// public void testInsert() {
// // insert no colision
// testHash.insert("a", null);
// assertEquals(1, testHash.getNumOfRecords());
// assertTrue(testHash.find("a"));
// assertEquals("a", testHash.getAllRecords()[1].getKey());
// testHash.insert("b", null);
// assertEquals(2, testHash.getNumOfRecords());
//
// // insert with tombstone
// testHash.remove("a");
// assertEquals(1, testHash.getNumOfRecords());
// testHash.insert("a", null);
// assertEquals(2, testHash.getNumOfRecords());
//
// // with collision
// testHash.insert("D", null);
// assertEquals(3, testHash.getNumOfRecords());
// }
//
//
// /**
// * Tests inserting with collison and tombstone
// */
// public void testInsertCollisionTombstone() {
// testHash.insert("a", null);
// assertEquals(1, testHash.getNumOfRecords());
// testHash.insert("b", null);
// assertEquals(2, testHash.getNumOfRecords());
// testHash.remove("b");
// assertEquals(1, testHash.getNumOfRecords());
// assertEquals("a", testHash.getAllRecords()[1].getKey());
// assertEquals("TOMBSTONE", testHash.getAllRecords()[2].getKey());
// assertEquals(1, testHash.getNumOfRecords());
// testHash.insert("a", null);
// assertEquals(2, testHash.getNumOfRecords());
// assertEquals("a", testHash.getAllRecords()[2].getKey());
//
// }
//
//
// /**
// * Tests Inserting
// */
// public void testInsertFirst() {
// testHash.insert("a", null);
// assertEquals(1, testHash.getNumOfRecords());
// testHash.insert("a", null);
// assertEquals(2, testHash.getNumOfRecords());
// testHash.insert("b", null);
// assertEquals(3, testHash.getNumOfRecords());
// }
//
//
// /**
// * Tests removing.
// */
// public void testRemoveA() {
// testHash.insert("a", null);
// testHash.remove("b");
// assertEquals(1, testHash.getNumOfRecords());
// testHash.remove("a");
// assertEquals(0, testHash.getNumOfRecords());
//
// }
//
//
// /**
// * Tests removing when there are no items in the HashTable
// */
// public void testRemoveNoItems() {
// assertEquals(0, testHash.getNumOfRecords());
// testHash.remove("a");
// assertEquals(0, testHash.getNumOfRecords());
// assertNull(testHash.getAllRecords()[0]);
// assertNull(testHash.getAllRecords()[1]);
// assertNull(testHash.getAllRecords()[2]);
// assertNull(testHash.getAllRecords()[3]);
// }
//
//
// /**
// * Tests removing when there is a Tombstone
// */
// public void testRemoveTombstone() {
// testHash.insert("a", null);
// assertEquals(1, testHash.getNumOfRecords());
//
// testHash.insert("a", null);
// assertEquals(2, testHash.getNumOfRecords());
//
// testHash.remove("a");
// assertEquals(1, testHash.getNumOfRecords());
// assertEquals("TOMBSTONE", testHash.getAllRecords()[1].getKey());
//
// testHash.remove("a");
// assertEquals(0, testHash.getNumOfRecords());
// assertEquals("TOMBSTONE", testHash.getAllRecords()[2].getKey());
//
// }
//
//
// /**
// * Tests removing when key is diffrent
// */
// public void testRemoveKeyisdiffrent() {
// testHash.insert("TOMBSTONE", null);
// testHash.insert("a", null);
// testHash.insert("b", null);
// testHash.remove("TOMBSTONE");
// assertEquals(2, testHash.getNumOfRecords());
//
// }
//
//
// /**
// * Tests Removing when key matches
// */
// public void testRemoveKeyMatches() {
// testHash.insert("a", null);
// assertTrue(testHash.find("a"));
// testHash.insert("b", null);
// assertTrue(testHash.find("b"));
// testHash.insert("b", null);
// assertTrue(testHash.find("b"));
// testHash.remove("b");
// assertTrue(testHash.find("b"));
// testHash.remove("b");
// assertFalse(testHash.find("b"));
//
// }
//
//
// /**
// * Tests removing when the key does not match.
// */
// public void testRemoveKeyDoesNotMatch() {
// testHash.insert("b", null);
// assertTrue(testHash.find("b"));
// testHash.insert("c", null);
// assertTrue(testHash.find("c"));
//
// testHash.remove("a");
// assertTrue(testHash.find("c"));
// assertTrue(testHash.find("b"));
// assertEquals(2, testHash.getNumOfRecords());
//
// }
//
//
// /**
// * Tests removing the same item twice
// */
// public void testRemovetwice() {
// testHash.insert("a", null);
// assertTrue(testHash.find("a"));
// testHash.insert("b", null);
// assertTrue(testHash.find("b"));
// testHash.insert("b", null);
// assertTrue(testHash.find("b"));
// testHash.insert("a", null);
// assertTrue(testHash.find("a"));
//
// testHash.remove("b");
// assertTrue(testHash.find("b"));
// testHash.remove("b");
// assertFalse(testHash.find("b"));
//
// }
//
//
// /**
// * Tests the find method
// */
// public void testFind() {
// testHash.insert("a", null);
// testHash.insert("b", null);
// assertTrue(testHash.find("b"));
// testHash.remove("b");
// assertTrue(testHash.find("a"));
// assertFalse(testHash.find("TOMBSTONE"));
// assertFalse(testHash.find("b"));
// }
//
//
// /**
// * Tests the resize method.
// */
// public void testResize() {
// testHash.insert("a", null);
// assertEquals(1, testHash.getNumOfRecords());
// assertEquals(4, testHash.getAllRecords().length);
//
// testHash.insert("b", null);
// assertEquals(2, testHash.getNumOfRecords());
//
// testHash.insert("c", null);
// assertEquals(8, testHash.getAllRecords().length);
// assertEquals(3, testHash.getNumOfRecords());
//
// testHash.insert("d", null);
// assertEquals(4, testHash.getNumOfRecords());
// assertEquals(8, testHash.getAllRecords().length);
//
// testHash.remove("a");
// assertEquals(3, testHash.getNumOfRecords());
// assertEquals(8, testHash.getAllRecords().length);
//
// testHash.insert("e", null);
// assertEquals(4, testHash.getNumOfRecords());
// assertEquals(8, testHash.getAllRecords().length);
//
// testHash.insert("f", null);
// assertEquals(5, testHash.getNumOfRecords());
// assertEquals(16, testHash.getAllRecords().length);
// }
//
//
// /**
// * Tests the Printing method
// */
// public void testPrint() {
//
// testHash.insert("a", null);
// testHash.insert("b", null);
// testHash.insert("c", null);
//
// testHash.print();
//
// String output = systemOut().getHistory();
//
// String expectedOutput = "1: |a|\n" + "2: |b|\n" + "3: |c|\n";
//
// assertFuzzyEquals(expectedOutput, output);
// }
//
//
// /**
// * Tests printing when there is a Tombstone in the HashTable
// */
// public void testPrintWithTombstone() {
//
// testHash.insert("a", null);
// testHash.insert("b", null);
// testHash.insert("c", null);
//
// testHash.remove("b");
//
// testHash.print();
//
// String output = systemOut().getHistory();
//
// String expectedOutput = "1: |a|\n" + "2: TOMBSTONE\n" + "3: |c|\n";
//
// assertFuzzyEquals(expectedOutput, output);
// }
//
//
// /**
// * Test printing when no items in hashtable
// */
// public void testPrintEmpty() {
//
// testHash.print();
//
// String output = systemOut().getHistory();
//
// String expectedOutput = "";
//
// assertFuzzyEquals(expectedOutput, output);
// }
//
//
// /**
// * Tests getter methods
// */
// public void testGetters() {
// assertEquals("TOMBSTONE", testHash.getTombstone().getKey());
// assertEquals(0, testHash.getNumOfRecords());
// assertNull(testHash.getAllRecords()[0]);
// }
//
//
// /**
// * Check out the sfold method
// *
// * @throws Exception
// * either a IOException or FileNotFoundException
// */
// public void testSfold() throws Exception {
// assertTrue(Hash.h("a", 10000) == 97);
// assertTrue(Hash.h("b", 10000) == 98);
// assertTrue(Hash.h("aaaa", 10000) == 1873);
// assertTrue(Hash.h("aaab", 10000) == 9089);
// assertTrue(Hash.h("baaa", 10000) == 1874);
// assertTrue(Hash.h("aaaaaaa", 10000) == 3794);
// assertTrue(Hash.h("Long Lonesome Blues", 10000) == 4635);
// assertTrue(Hash.h("Long Lonesome Blues", 10000) == 4159);
// assertTrue(Hash.h("long Lonesome Blues", 10000) == 4667);
// }


    // ----------------------------------------------------------
    /**
     * IDk what this method does.
     */
    public void setUp1() {
        testHash = new Hash<>(4);
    }


    // ----------------------------------------------------------
    /**
     * Tests inserting
     */
    public void testInsertConditions() {

        testHash.insert(1, "A");
        testHash.insert(2, "B");
        testHash.insert(3, "C");
        assertEquals(8, testHash.getAllRecords().length);
        assertEquals(3, testHash.getNumOfRecords());
        testHash.remove(1);
        assertEquals(testHash.getTombstone(), testHash.getAllRecords()[1]);
        testHash.insert(1, "A1");
        assertEquals("A1", testHash.getAllRecords()[1].value());
        assertEquals(3, testHash.getNumOfRecords());

        testHash.insert(9, "D");
        assertEquals("B", testHash.getAllRecords()[2].value());
        assertEquals(4, testHash.getNumOfRecords());

        testHash.insert(17, "E");
        assertEquals("C", testHash.getAllRecords()[3].value());
        assertEquals(5, testHash.getNumOfRecords());
    }


    // ----------------------------------------------------------
    /**
     * Hopefully tests the arithmetic?
     */
    public void testPosCalculationMutations() {
        testHash = new Hash<>(8);

        testHash.insert(1, "A");
        testHash.insert(9, "B");

        assertEquals("A", testHash.getAllRecords()[1].value());
        assertEquals("B", testHash.getAllRecords()[2].value());

        int home = Hash.h(1, 8);
        int i = 1;
        int mutatedPos = ((home - (((i * i) + i) / 2))) % 8;
        assertEquals(0, mutatedPos);
        assertNull(testHash.getAllRecords()[mutatedPos]);

        int mutatedPos1 = ((home + (((i * i) - i) * 2))) % 8;
        assertEquals(1, mutatedPos1);
        assertNotSame("A", testHash.getAllRecords()[mutatedPos]);

        int mutatedPos2 = ((home + (((i / i) + i) * 2))) % 8;
        assertEquals(5, mutatedPos2);
        assertNotSame("A", testHash.getAllRecords()[mutatedPos]);

        int mutatedPos3 = ((home + (((i - i) / i) * 2))) % 8;
        assertEquals(1, mutatedPos3);
        assertNotSame("A", testHash.getAllRecords()[mutatedPos]);

    }


    /**
     * Tests insert again mor mutations
     */
    @SuppressWarnings("unchecked")
    public void testInsert1() {
        testHash.insert(1, "a");
        assertEquals(1, testHash.getNumOfRecords());
        assertTrue(testHash.find(1));
        assertEquals(1, testHash.getAllRecords()[1].key());
        testHash.insert(2, "b");
        assertEquals(2, testHash.getNumOfRecords());
        testHash.remove(1);
        assertEquals(1, testHash.getNumOfRecords());
        testHash.insert(1, "a");
        assertEquals(2, testHash.getNumOfRecords());
        testHash.insert(5, "D");
        assertEquals(3, testHash.getNumOfRecords());
    }


    // ----------------------------------------------------------
    /**
     * Tests the collisions
     */
    @SuppressWarnings("unchecked")
    public void testInsertCollisionTombstone1() {
        testHash.insert(1, "a");
        assertEquals(1, testHash.getNumOfRecords());
        testHash.insert(2, "b");
        assertEquals(2, testHash.getNumOfRecords());
        testHash.remove(2);
        assertEquals(1, testHash.getNumOfRecords());
        assertEquals(1, testHash.getAllRecords()[1].key());
        assertEquals(testHash.getTombstone(), testHash.getAllRecords()[2]);
        testHash.insert(2, "b");
        assertEquals(2, testHash.getNumOfRecords());
        assertEquals(2, testHash.getAllRecords()[2].key());
    }


    // ----------------------------------------------------------
    /**
     * Tests inserting the first
     */
    public void testInsertFirst1() {
        testHash.insert(1, "a");
        assertEquals(1, testHash.getNumOfRecords());
        testHash.insert(2, "b");
        assertEquals(2, testHash.getNumOfRecords());
        testHash.insert(3, "c");
        assertEquals(3, testHash.getNumOfRecords());
    }


    // ----------------------------------------------------------
    /**
     * Tests remove
     */
    public void testRemove() {
        testHash.insert(1, "a");
        testHash.remove(2);
        assertEquals(1, testHash.getNumOfRecords());
        testHash.remove(1);
        assertEquals(0, testHash.getNumOfRecords());
    }


    // ----------------------------------------------------------
    /**
     * Tests remove on a no item hash table
     */
    public void testRemoveNoItems() {
        assertEquals(0, testHash.getNumOfRecords());
        testHash.remove(1);
        assertEquals(0, testHash.getNumOfRecords());
        for (int i = 0; i < 4; i++) {
            assertNull(testHash.getAllRecords()[i]);
        }
    }


    // ----------------------------------------------------------
    /**
     * Remove tombstones
     */
    public void testRemoveTombstone() {
        testHash.insert(1, "a");
        assertEquals(1, testHash.getNumOfRecords());
        testHash.remove(1);
        assertEquals(0, testHash.getNumOfRecords());
        assertEquals(testHash.getTombstone(), testHash.getAllRecords()[1]);
    }


    // ----------------------------------------------------------
    /**
     * Tests find method
     */
    public void testFind() {
        testHash.insert(1, "a");
        testHash.insert(2, "b");
        assertTrue(testHash.find(2));
        testHash.remove(2);
        assertFalse(testHash.find(2));
        assertTrue(testHash.find(1));
    }


    // ----------------------------------------------------------
    /**
     * Tests resize
     */
    public void testResize() {
        testHash.insert(1, "a");
        assertEquals(4, testHash.getAllRecords().length);
        testHash.insert(2, "b");
        testHash.insert(3, "c");
        assertEquals(8, testHash.getAllRecords().length);
        assertEquals(3, testHash.getNumOfRecords());
    }


    // ----------------------------------------------------------
    /**
     * Tests print
     */
    public void testPrint() {
        testHash.insert(1, "a");
        testHash.insert(2, "b");
        testHash.insert(3, "c");
        testHash.print();
        testHash.remove(1);
        testHash.print();

    }

    // mine


    /**
     * Test insert
     */
    public void testInsert2() {

        hash.insert(1, "Record1");
        assertEquals(1, hash.getNumOfRecords());
        assertEquals("Record1", hash.getRecord(1).value());

        hash.insert(5, "Record2");
        assertEquals(2, hash.getNumOfRecords());
        assertEquals("Record2", hash.getRecord(5).value());

        hash.insert(9, "Record3");
        hash.insert(13, "Record4");
        assertEquals(4, hash.getNumOfRecords());
        assertEquals(8, hash.getAllRecords().length);
    }


    /**
     * Test remove
     */
    public void testRemove1() {
        hash.insert(1, "Record1");
        hash.insert(5, "Record2");
        hash.remove(1);

        assertEquals(1, hash.getNumOfRecords());
        assertEquals(-1, hash.getAllRecords()[1].key());

        assertFalse(hash.find(1));

        hash.insert(1, "Record3");
        assertEquals(2, hash.getNumOfRecords());
        assertEquals("Record3", hash.getRecord(1).value());
    }


    /**
     * Tests find
     */
    public void testFind1() {
        hash.insert(1, "Record1");
        hash.insert(5, "Record2");

        assertTrue(hash.find(1));
        assertTrue(hash.find(5));

        assertFalse(hash.find(9));

        hash.remove(1);
        assertFalse(hash.find(1));
    }


    /**
     * Tests resize.
     */
    public void testResize1() {
        hash.insert(1, "Record1");
        hash.insert(5, "Record2");
        hash.insert(9, "Record3");

        assertEquals(3, hash.getNumOfRecords());
        assertEquals(8, hash.getAllRecords().length);

        assertEquals("Record1", hash.getRecord(1).value());
        assertEquals("Record2", hash.getRecord(5).value());
        assertEquals("Record3", hash.getRecord(9).value());
    }


    /**
     * Test getRecord
     */
    public void testGetRecord() {
        hash.insert(1, "Record1");

        assertNotNull(hash.getRecord(1));
        assertEquals("Record1", hash.getRecord(1).value());

        assertNull(hash.getRecord(9));
    }


    /**
     * Tests inserting, removing, and reinserting
     */
    public void testInsertRemoveReinsert() {
        hash.insert(1, "Record1");
        hash.remove(1);
        hash.insert(5, "Record2");
        hash.insert(1, "Record3");

        assertEquals(2, hash.getNumOfRecords());
        assertTrue(hash.find(1));
        assertEquals("Record3", hash.getRecord(1).value());
    }


    /**
     * Tests collisions
     */
    public void testCollision() {
        hash.insert(1, "Record1");
        hash.insert(5, "Record2");
        hash.insert(9, "Record3");

        assertEquals(3, hash.getNumOfRecords());
        assertEquals("Record1", hash.getRecord(1).value());
        assertEquals("Record2", hash.getRecord(5).value());
        assertEquals("Record3", hash.getRecord(9).value());
    }


    /**
     * Tests the getterss
     */
    public void testGetters() {
        hash.insert(1, "Record1");
        assertEquals(1, hash.getNumOfRecords());
        assertNotNull(hash.getAllRecords());

        hash.remove(1);
        assertEquals(0, hash.getNumOfRecords());
    }

}

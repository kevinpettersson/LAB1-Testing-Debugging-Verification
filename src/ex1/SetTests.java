package ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SetTests {
    @Test
    void TestInsertEmptySet() {
        // expected output: arr = [2]
        var set = new Set();
        set.insert(2);
        int[] arr = set.toArray();
        assertEquals(1, arr.length);
        assertEquals(2, arr[0]);
    }

    @Test
    void TestInsertDuplicateElement() {
        // expected output: arr = [5, 5]
        var set = new Set();
        set.insert(5);
        set.insert(5);
        int[] arr = set.toArray();
        assertEquals(2, arr.length);
        assertEquals(5, arr[0]);
        assertEquals(5, arr[1]);
    }

    @Test
    void TestInsertElementLessThanAllOtherElements() {
        // expected output: arr = [2,5,2]
        var set = new Set();
        set.insert(5);
        set.insert(2);
        int[] arr = set.toArray();
        assertEquals(3, arr.length);
        assertEquals(2, arr[0]);
        assertEquals(5, arr[1]);
        assertEquals(2, arr[2]);
    }

    @Test
    void TestInsertElementGreaterThanAllOtherElements() {
        //expected output: arr = [5,6]
        var set = new Set();
        set.insert(5);
        set.insert(6);
        int[] arr = set.toArray();
        assertEquals(2, arr.length);
        assertEquals(5, arr[0]);
        assertEquals(6, arr[1]);
    }

    @Test
    void TestInsertElementInTheMiddle() {
        //expected output: arr = [5,6,7] (6 placed at middle index of the list)
        // Det är någon random bugg här???? fattar verkligen inte
        var set = new Set();
        set.insert(6);
        set.insert(7);
        set.insert(5);
        int[] arr = set.toArray();
        assertEquals(3, arr.length);
        assertEquals(5, arr[0]);
        assertEquals(6, arr[1]);
        assertEquals(7, arr[2]);
    }



    /*
        member-method tests
     */

    @Test
    void TestMemberElementNotPresentInSet() {
        //expected output: false, since 2 was never inserted in the list.
        var set  = new Set();
        set.insert(5);
        assertFalse(set.member(2));
    }

    @Test
    void TestMemberEmptySet() {
        // expected output: false, since 4 was never inserted in the list.
        var set = new Set();
        assertFalse(set.member(4));
    }

    @Test
    void TestMemberPresentInSet(){
        // expected output: true, since 5 was inserted into the list.
        var set = new Set();
        set.insert(4);
        set.insert(5);
        assertTrue(set.member(5));
    }

    /*
        intersect-method tests
     */

    @Test
    void intersectTestOneElementExistInBothSets() {
        // expected output: [5], since it's the only element that exists in both sets.
        var a = new Set();
        var s = new Set();

        a.insert(4);
        a.insert(5);
        s.insert(5);

        a.intersect(s);
        int[] arr = a.toArray();
        assertEquals(1, arr.length);
        assertEquals(5, arr[0]);
    }

    /*
        distinctClosed-method tests
     */

    @Test
    void distinctClosed() {
    }
}
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
        // expected output: arr = [2,5]
        var set = new Set();
        set.insert(2);
        set.insert(5);
        set.insert(5);
        int[] arr = set.toArray();
        assertEquals(2, arr.length);
        assertEquals(2, arr[0]);
        assertEquals(5, arr[1]);
    }

    @Test
    void TestInsertElementLessThanAllOtherElements() {
        // expected output: arr = [1,2,5]
        var set = new Set();
        set.insert(5);
        set.insert(2);
        set.insert(1);
        int[] arr = set.toArray();
        assertEquals(3, arr.length);
        assertEquals(1, arr[0]);
        assertEquals(2, arr[1]);
        assertEquals(5, arr[2]);
    }

    @Test
    void TestInsertElementGreaterThanAllOtherElements() {
        //expected output: arr = [2,5,6]
        var set = new Set();
        set.insert(5);
        set.insert(2);
        set.insert(6);
        int[] arr = set.toArray();
        assertEquals(3, arr.length);
        assertEquals(2, arr[0]);
        assertEquals(5, arr[1]);
        assertEquals(6, arr[2]);
    }

    @Test
    void TestInsertElementInTheMiddle() {
        //expected output: arr = [5,6,7] (6 placed at middle index of the list)
        var set = new Set();
        set.insert(7);
        set.insert(5);
        set.insert(6);
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
        //expected output: false, since 2 was never inserted in the set.
        var set  = new Set();
        set.insert(5);
        assertFalse(set.member(2));
    }

    @Test
    void TestMemberEmptySet() {
        // expected output: false, since 4 was never inserted in the set.
        var set = new Set();
        assertFalse(set.member(4));
    }

    @Test
    void TestMemberPresentInSet(){
        // expected output: true, since 5 was inserted into the set.
        var set = new Set();
        set.insert(4);
        set.insert(5);
        assertTrue(set.member(5));
    }

    /*
        intersect-method tests
     */

    @Test
    void intersectTestOneCommonElement() {
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

    @Test
    void intersectTestBothEmpty() {
        // expected output: arr = []
        var a = new Set();
        var s = new Set();

        a.intersect(s);
        int[] arr = a.toArray();
        assertEquals(0, arr.length);
    }

    @Test
    void intersectTestOneSetEmpty() {
        // expteced output: arr = [].
        var a = new Set();
        var s = new Set();

        s.insert(4);
        s.insert(5);
        a.intersect(s);
        int[] arr = a.toArray();
        assertEquals(0, arr.length);
    }
    @Test
    void intersectTestAllElementsCommon(){
        // expected output: [3,4,5]
        var a = new Set();
        var s = new Set();

        s.insert(3);
        s.insert(4);
        s.insert(5);
        a.insert(3);
        a.insert(4);
        a.insert(5);

        a.intersect(s);
        int[] arr = a.toArray();

        assertEquals(3, arr.length);
        assertEquals(3, arr[0]);
        assertEquals(4, arr[1]);
        assertEquals(5, arr[2]);
    }




        @Test
        void intersectTestNoElementsCommon() {
        // expetced output : arr = []
        var a = new Set();
        var s = new Set();

        a.insert(1);
        a.insert(2);
        a.insert(3);

        s.insert(6);
        s.insert(7);
        s.insert(8);

        a.intersect(s);
        int[] arr = a.toArray();
        //assertEquals(2, arr[0]);
        assertEquals(0, arr.length);

        }

    @Test
    void intersectTestNoElementsCommonn() {
        // expetced output : arr = []
        var a = new Set();
        var s = new Set();

        a.insert(6);
        a.insert(7);
        a.insert(8);

        s.insert(1);
        s.insert(2);
        s.insert(3);

        a.intersect(s);
        int[] arr = a.toArray();
        //assertEquals(2, arr[0]);
        assertEquals(0, arr.length);

    }


    @Test
    void intersectTestTest() {
        var a = new Set();
        var s = new Set();

        a.insert(1);
        a.insert(8);

        s.insert(5);
        s.insert(6);
        s.insert(8);

        a.intersect(s);
        int[] arr = a.toArray();
        assertEquals(1, arr.length);
        assertEquals(arr[0], 8);

    }


    /*
        distinctClosed-method tests
     */

    @Test
    void distinctClosed() {
    }
}
package ex1;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class SetTests {

    @Test
    void TestInsertElementLessAndNotEqual() {
        // Ska resultera till arr = [2,5,2]
        var set = new Set();
        set.insert(5);
        set.insert(2);
        int[] arr = set.toArray();
        assertEquals(2, arr[0]);
        assertEquals(5, arr[1]);
        assertEquals(2, arr[2]);
    }

    @Test
    void TestInsertElementEqual() {
        // Ska resultera till arr = [5, 5]
        var set = new Set();
        set.insert(5);
        set.insert(5);
        int[] arr = set.toArray();
        assertEquals(5, arr[0]);
        assertEquals(5, arr[1]);
    }
    @Test
    void TestInsertElementGreaterAndNotEqual() {
        //Ska resultera till arr = [5,6]
        var set = new Set();
        set.insert(5);
        set.insert(6);
        int[] arr = set.toArray();
        assertEquals(5, arr[0]);
        assertEquals(6, arr[1]);
    }

    /*
        member-method tests
     */

    @Test
    void TestMemberInputNotPresent() {
        var set  = new Set();
        set.insert(5);
        assertFalse(set.member(2));
    }

    @Test
    void TestMemberEmptyList() {
        var set = new Set();
        assertFalse(set.member(4));
    }

    @Test
    void TestMemberPresentInList(){
        var set = new Set();
        set.insert(4);
        set.insert(5);
        assertTrue(set.member(5));
    }

    /*
        intersect-method tests
     */

    @Test
    void intersectFirstTest() {
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
package ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SetTests {
    /*
        toArray-method tests
     */
    @Test
     void testForLoopZeroIterations() {
        var set = new Set();
        int[] arr = set.toArray();
        assertEquals(0, arr.length);
    }
    @Test
    void testForLoopOneIteration(){
        var set = new Set();
        set.insert(2);
        int[] arr = set.toArray();
        assertEquals(1, arr.length);
    }
    @Test
    void testForLoopMultipleIterations(){

    }
    @Test
    void testAllIndicesFromListToArray(){

    }

    /*
        insert-method tests
     */

    @Test
    void insert() {
    }

    /*
        member-method tests
     */

    @Test
    void member() {
    }

    /*
        intersect-method tests
     */

    @Test
    void intersect() {
    }

    /*
        distinctClosed-method tests
     */

    @Test
    void distinctClosed() {
    }
}
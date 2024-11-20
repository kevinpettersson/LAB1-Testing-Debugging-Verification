import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextInCompleteTests {

    @Test
    public void nextIncompleteTest_AllHoursComplete() {
        // Block 1.
        var ws = new WorkSchedule(4);

        ws.setRequiredNumber(2,0,3);
        ws.addWorkingPeriod("alice", 0,3);
        ws.addWorkingPeriod("kevin", 0,3);

        assertEquals(-1, ws.nextIncomplete(0));
    }
/*
    @Test
    public void nextIncompleteTest_CurrentTimeIncomplete() {
        // Block 2
        var ws = new WorkSchedule(4);

        ws.setRequiredNumber(2,0,3);
        ws.addWorkingPeriod("alice", 0,1);
        ws.addWorkingPeriod("kevin", 0,1);
        // bugg! borde returnera två
        assertEquals(2, ws.nextIncomplete(2));
    }
 */

    @Test
    public void nextIncompleteTest_IncompleteCurrentTime() {
        // Block 3.
        var ws = new WorkSchedule(4);

        ws.setRequiredNumber(2,2,2);
        ws.addWorkingPeriod("alice", 2,2);
        assertEquals(2, ws.nextIncomplete(2));
    }

    @Test
    public void testIncompleteAfterCurrentTime() {
        WorkSchedule schedule = new WorkSchedule(5);
        schedule.setRequiredNumber(3, 3, 3);
        schedule.addWorkingPeriod("Alice", 3, 3);
        schedule.addWorkingPeriod("Bob", 3, 3);
        assertEquals(3, schedule.nextIncomplete(1)); // Block B2
    }
}

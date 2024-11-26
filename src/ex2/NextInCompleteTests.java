import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NextInCompleteTests {

    @Test
    public void nextIncompleteAllHoursFilledAndCurrentTimeEqualsToZero(){
        // Block 1
        var ws = new WorkSchedule(7);

        ws.setRequiredNumber(2,0,5);
        ws.addWorkingPeriod("kevin", 0, 5);
        ws.addWorkingPeriod("alice", 0, 5);

        assertEquals(-1, ws.nextIncomplete(0));

    }
    @Test
    public void nextIncompleteNoRequiredWorkers(){
        // Block 2
        var ws = new WorkSchedule(7);
        assertEquals(-1, ws.nextIncomplete(0));
    }
    @Test
    public void nextIncomplete_NotAllHoursFilled(){
        // Block 3
        var ws = new WorkSchedule(7);

        ws.setRequiredNumber(2,0,5);
        ws.addWorkingPeriod("kevin", 0, 2);
        ws.addWorkingPeriod("alice", 0, 5);
        // BUG, should be assertEquals(3, ws.nextIncomplete(0));
        assertEquals(5, ws.nextIncomplete(0));
    }

    @Test
    public void nextIncompleteNoAddedWorkers(){
        // Block 3
        var ws = new WorkSchedule(7);
        ws.setRequiredNumber(2,0,5);
        // Bug! should return closetst hour to current time but returns last hour.
        // should be assertEquals(0, ws.nextIncomplete(0));
        assertEquals(5, ws.nextIncomplete(0));
    }
    @Test
    public void nextIncompleteAllHoursFilledAndCurrentTimeWithinValidRange(){
        // Block 4
        var ws = new WorkSchedule(7);

        ws.setRequiredNumber(2,0,5);
        ws.addWorkingPeriod("kevin", 0, 5);
        ws.addWorkingPeriod("alice", 0, 5);

        assertEquals(-1, ws.nextIncomplete(2));
    }

    @Test
    public void nextIncompleteTest_CurrentTimeLessThanZero(){
        // Border case
        var ws = new WorkSchedule(7);

        ws.setRequiredNumber(2,0,5);
        ws.addWorkingPeriod("kevin", 0, 5);
        ws.addWorkingPeriod("alice", 0, 5);
        // Bug, should still return -1, since -1 is an invalid hour.
        //should be assertEquals(-1, ws.nextIncomplete(-1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> ws.nextIncomplete(-1));
    }

    @Test
    public void nextIncompleteTest_CurrentTimeBiggerThanTotalHours(){
        // Border case
        var ws = new WorkSchedule(7);

        ws.setRequiredNumber(2,0,5);
        ws.addWorkingPeriod("kevin", 0, 5);
        ws.addWorkingPeriod("alice", 0, 5);
        assertEquals(-1, ws.nextIncomplete(11));
    }
}

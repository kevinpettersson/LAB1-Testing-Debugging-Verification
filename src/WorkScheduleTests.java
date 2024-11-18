import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorkScheduleTests {

    @Test
    public void setRequiredNumberTestInputsAllZero() {
        // starttime == endtime.
        WorkSchedule ws = new WorkSchedule(2);
        ws.setRequiredNumber(0,0,0);
        assertFalse(ws.addWorkingPeriod("kevin", 0, 1));
    }

    @Test
    public void setRequiredNumberTestStartTimeBiggerThanEndTime() {
        // starttime > endtime.
        WorkSchedule ws = new WorkSchedule(4);
        ws.setRequiredNumber(2,3,2);
        assertFalse(ws.addWorkingPeriod("kevin", 0, 1));
    }

    @Test
    public void setRequiredNumberTestNemployeeBiggerThanWorkingEmployees() {
        // starttime < endtime && working employees > nemployee. (BUG !!!)
        WorkSchedule ws = new WorkSchedule(4);

        ws.setRequiredNumber(3,0,3);

        ws.addWorkingPeriod("1", 0, 3);
        ws.addWorkingPeriod("2", 0, 3);
        ws.addWorkingPeriod("3", 0, 3);

        ws.setRequiredNumber(2,0,3);
        // bug
        assertNotEquals(2,ws.workingEmployees(0,3).length);
    }

    @Test
    public void setRequiredNumberTestNemployeeSmallerThanWorkingEmployees() {
        // starttime < endtime && working employees < nemployee.
        WorkSchedule ws = new WorkSchedule(4);

        ws.setRequiredNumber(2,0,3);

        ws.addWorkingPeriod("1", 0, 3);
        ws.addWorkingPeriod("2", 0, 3);

        ws.setRequiredNumber(3,0,3);
        // bug
        assertEquals(2,ws.workingEmployees(0,3).length);
    }










    @Test
    public void nextIncompleteTest() {

    }
}

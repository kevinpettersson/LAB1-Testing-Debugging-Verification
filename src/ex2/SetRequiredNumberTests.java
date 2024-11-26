import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetRequiredNumberTests {

    @Test
    public void setRequiredNumberTest_StartLessOrEqualToEnd() {
        // Block 1
        // starttime <= endtime
        WorkSchedule ws = new WorkSchedule(5);
        //set nemployee = 2 and startime <= endtime
        ws.setRequiredNumber(2,0,2);

        // verify expected results
        for (int i = 0; i < 2; i++) {
            WorkSchedule.Hour result = ws.readSchedule(i);
            assertEquals(2, result.requiredNumber);
        }
        // verify hours outside required that they remain unchanged.
        for (int i = 3; i < 5; i++) {
            WorkSchedule.Hour result = ws.readSchedule(i);
            assertEquals(0, result.requiredNumber);
        }
    }

    @Test
    public void setRequiredNumberTest_StartEqualToEnd() {
        // Block 1
        // starttime == endtime
        WorkSchedule ws = new WorkSchedule(3);
        //set nemployee = 2 and startime = endtime
        ws.setRequiredNumber(2,0,0);

        // verify expected results
        WorkSchedule.Hour result = ws.readSchedule(0);
        assertEquals(2, result.requiredNumber);
    }

    @Test
    public void setRequiredNumberTest_StartBiggerThanEnd() {
        // Block 2
        // starttime > endtime
        WorkSchedule ws = new WorkSchedule(4);
        ws.setRequiredNumber(2,4,1);

        // verify expected output , it's unchanged since starttime > endtime.
        for (int i = 0; i < 4; i++) {
            WorkSchedule.Hour result = ws.readSchedule(i);
            assertEquals(0, result.requiredNumber);
        }
    }

    @Test
    public void setRequiredNumberTest_NemployeeSmallerThanWorkingEmployees() {
        // Block 3
        // workingEmployees.lenght() > nemployee. (BUG !!!)
        WorkSchedule ws = new WorkSchedule(4);

        ws.setRequiredNumber(3,0,3);

        ws.addWorkingPeriod("1", 0, 3);
        ws.addWorkingPeriod("2", 0, 3);
        ws.addWorkingPeriod("3", 0, 3);

        // set new required to 2 for houres 0-3, should trim the list of employees to 2.
        ws.setRequiredNumber(2,0,3);
        // bug, should be assertEquals here, the trimming logic does not work properly here.
        assertNotEquals(2,ws.workingEmployees(0,3).length);
        // verify that required number is 2 even though we have 3 employees
        for (int i = 0; i < 4; i++) {
            WorkSchedule.Hour result = ws.readSchedule(i);
            assertEquals(2, result.requiredNumber);
        }
    }

    @Test
    public void setRequiredNumberTestNemployeeBiggerThanOrEqualToWorkingEmployees() {
        // Block 4
        // working employees < nemployee.
        WorkSchedule ws = new WorkSchedule(4);

        ws.setRequiredNumber(2,0,3);

        ws.addWorkingPeriod("1", 0, 3);
        ws.addWorkingPeriod("2", 0, 3);

        ws.setRequiredNumber(3,0,3);

        // verify that current working employees are still 2 since we didn't add anything.
        assertEquals(2,ws.workingEmployees(0,3).length);
        // verify that required number == 3
        for (int i = 0; i < 4; i++) {
            WorkSchedule.Hour result = ws.readSchedule(i);
            assertEquals(3, result.requiredNumber);
        }
    }

    @Test
    public void setRequiredNumberTest_NemployeeZero() {
        WorkSchedule ws = new WorkSchedule(4);
        ws.setRequiredNumber(3, 0, 3);
        ws.addWorkingPeriod("Alice", 0, 3);

        ws.setRequiredNumber(0, 0, 3);

        // here the trimming logic works fine when nemeployee == 0. (no bug here)
        for (int i = 0; i < 4; i++) {
            WorkSchedule.Hour result = ws.readSchedule(i);
            assertEquals(0, result.requiredNumber);
            assertEquals(0, result.workingEmployees.length);
        }
    }
}

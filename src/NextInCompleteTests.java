import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextInCompleteTests {

    @Test
    public void nextIncompleteTest_ValidCurrentTime() {
        // Block 1.
        WorkSchedule ws = new WorkSchedule(4);
        ws.setRequiredNumber(2, 0, 4);
        ws.addWorkingPeriod("Alice", 0, 0);
        ws.addWorkingPeriod("Kevin", 0, 1);

        assertEquals(2, ws.nextIncomplete(0)); // Expected output: 0
    }
}

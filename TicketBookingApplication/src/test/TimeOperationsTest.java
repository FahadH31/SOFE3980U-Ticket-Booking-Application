package test;

import main.TimeOperations;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TimeOperationsTest {

    @Test
    public void convertTimeFormat12to24() {
        // Test converting from 12-hour format to 24-hour format
        TimeOperations operations1 = new TimeOperations();
        String time24Hour = operations1.convertTimeFormat("10:00 AM", true);
        assertEquals("10:00", time24Hour);
    }

    @Test
    public void convertTimeFormat24to24() {
        // Test converting from 24-hour format to 24-hour format (no conversion needed)
        TimeOperations operations1 = new TimeOperations();
        String time24Hour = operations1.convertTimeFormat("14:00", false);
        assertEquals("14:00", time24Hour);
    }

    @Test
    public void convertTimeFormat12to12() {
        // Test converting from 12-hour format to 12-hour format (no conversion needed)
        TimeOperations operations1 = new TimeOperations();
        String time12Hour = operations1.convertTimeFormat("10:00 AM", false);
        assertEquals("10:00 AM", time12Hour);
    }

    @Test
    public void convertTimeFormat24to12() {
        // Test converting from 24-hour format to 12-hour format
        TimeOperations operations1 = new TimeOperations();
        String time12Hour = operations1.convertTimeFormat("14:00", true);
        assertEquals("2:00 PM", time12Hour);
    }
}

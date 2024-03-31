import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlightOperationsTest {

    private FlightOperations flightOperations;

    @BeforeEach
    void setUp() {
        flightOperations = new FlightOperations();
    }

    @Test
    void bookFlightValid() {
        FlightOperations flightOperations = new FlightOperations();
        assertTrue(flightOperations.bookFlight(1, "n", 0, 1, 1));
    }

    @Test
    void bookFlightInvalid() {
        FlightOperations flightOperations = new FlightOperations();
        assertFalse(flightOperations.bookFlight(-4, "n", 0, 1, 1));
    }

    @Test
    void bookFlightInvalidTripType() {
        FlightOperations flightOperations = new FlightOperations();
        assertFalse(flightOperations.bookFlight(1, "n", 0, 3, 1));
    }

    @Test
    void bookValidMultistop() {
        FlightOperations flightOperations = new FlightOperations();
        assertTrue(flightOperations.bookFlight(1, "y", 2, 1, 1));
    }

    @Test
    void bookInvalidMultistopSameFlight() {
        FlightOperations flightOperations = new FlightOperations();
        assertFalse(flightOperations.bookFlight(1, "y", 1, 1, 1));
    }

    @Test
    void bookInvalidMultistopSecondFlightNotFound() {
        FlightOperations flightOperations = new FlightOperations();
        assertFalse(flightOperations.bookFlight(1, "y", 0, 1, 1));
    }
    @Test
    void testCalculateTotalFlightTimeSameDay() {
        Flight flight = new Flight("New York", "Los Angeles", "08:00", "12:30");
        int totalFlightTime = flightOperations.calculateTotalFlightTime(flight);
        assertEquals(4, totalFlightTime);
    }

    @Test
    void testCalculateTotalFlightTimeNextDay() {
        Flight flight = new Flight("New York", "Los Angeles", "23:00", "03:00");
        int totalFlightTime = flightOperations.calculateTotalFlightTime(flight);
        assertEquals(4, totalFlightTime);
    }

    @Test
    void testCalculateTotalFlightTimeNegativeDifference() {
        Flight flight = new Flight("New York", "Los Angeles", "18:00", "10:00");
        int totalFlightTime = flightOperations.calculateTotalFlightTime(flight);
        assertEquals(16, totalFlightTime);
    }

    @Test
    void testCalculateTotalFlightTimeMidnightDeparture() {
        Flight flight = new Flight("New York", "Los Angeles", "00:00", "04:00");
        int totalFlightTime = flightOperations.calculateTotalFlightTime(flight);
        assertEquals(4, totalFlightTime);
    }

    @Test
    void convertTimeFormat12HourFormat() {
        String time = "13:30";
        String convertedTime = flightOperations.convertTimeFormat(time, 1);
        assertEquals("1:30 PM", convertedTime);
    }

    @Test
    void convertTimeFormat24HourFormat() {
        String time = "13:30";
        String convertedTime = flightOperations.convertTimeFormat(time, 2);
        assertEquals("13:30", convertedTime);
    }
}

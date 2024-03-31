package test;

import main.Flight;
import main.FlightOperations;
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
    void testBookFlightOneWay12HourFormat() {
        assertTrue(flightOperations.bookFlight());
    }

    @Test
    void testBookFlightRoundTrip24HourFormat() {
        assertTrue(flightOperations.bookFlight());
    }

    @Test
    void testBookFlightInvalidFlightChoice() {
        assertFalse(flightOperations.bookFlight());
    }

    @Test
    void testBookFlightInvalidMultistopChoice() {
        assertFalse(flightOperations.bookFlight());
    }

    @Test
    void testBookFlightInvalidSecondFlightChoice() {
        assertFalse(flightOperations.bookFlight());
    }

    @Test
    void testCalculateTotalFlightTime() {
        Flight flight = new Flight("New York", "Los Angeles", "08:00", "11:00");
        int totalFlightTime = flightOperations.calculateTotalFlightTime(flight);
        assertEquals(3, totalFlightTime);
    }

    @Test
    void testConvertTimeFormat12HourFormat() {
        String time = "13:30";
        String convertedTime = flightOperations.convertTimeFormat(time, 1);
        assertEquals("1:30 PM", convertedTime);
    }

    @Test
    void testConvertTimeFormat24HourFormat() {
        String time = "13:30";
        String convertedTime = flightOperations.convertTimeFormat(time, 2);
        assertEquals("13:30", convertedTime);
    }

    @Test
    void testValidateFlightInvalidRoundTripOrOneWay() {
        assertFalse(flightOperations.validateFlight(1, "n", 0, 0, 1));
    }

    @Test
    void testValidateFlightInvalidTimeFormat() {
        assertFalse(flightOperations.validateFlight(1, "n", 0, 1, 0));
    }

    @Test
    void testValidateFlightValidOneWay() {
        assertTrue(flightOperations.validateFlight(1, "n", 0, 1, 1));
    }

    @Test
    void testValidateFlightValidRoundTrip() {
        assertTrue(flightOperations.validateFlight(1, "n", 0, 2, 1));
    }

    @Test
    void testValidateFlightValidMultistop() {
        assertTrue(flightOperations.validateFlight(1, "y", 2, 1, 1));
    }

    @Test
    void testValidateFlightInvalidMultistopSameFlight() {
        assertFalse(flightOperations.validateFlight(1, "y", 1, 1, 1));
    }
}

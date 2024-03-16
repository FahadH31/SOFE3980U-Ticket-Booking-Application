package test;
import main.Flight;
import main.FlightOperations;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.*;

public class FlightOperationsTest {
    @Test
    public void bookFlightValidInput() {
        // Test valid input parameters
        FlightOperations bookingSystem = new FlightOperations();
        boolean isBooked = bookingSystem.bookFlight("JFK", "LAX", "10:00", "13:00", true, false);
        assertTrue(isBooked);
    }

    @Test
    public void bookFlightInvalidInput1() {
        // Test invalid input parameters
        FlightOperations bookingSystem = new FlightOperations();
        boolean isBooked = bookingSystem.bookFlight("", "LAX", "10:00", "13:00", true, false);
        assertFalse(isBooked);
    }

    @Test
    public void bookFlightInvalidInput2() {
        // Test invalid input parameters
        FlightOperations bookingSystem = new FlightOperations();
        boolean isBooked = bookingSystem.bookFlight("LAX", "", "10:00", "13:00", true, false);
        assertFalse(isBooked);
    }

    @Test
    public void bookFlightInvalidInput3()  {
        // Test validating an invalid flight
        FlightOperations bookingSystem = new FlightOperations();
        boolean isValid = bookingSystem.bookFlight("LAX", "LAX", "10:00", "13:00", false, false);
        assertFalse(isValid);
    }

    @Test
    public void calculateTotalFlightTimeOfMultipleFlights() {
        // Test calculating total flight time
        FlightOperations bookingSystem = new FlightOperations();
        Flight flight1 = new Flight("JFK", "LAX", "10:00", "13:00", false);
        Flight flight2 = new Flight("LAX", "SFO", "14:00", "16:00", false);
        List<Flight> flights = Arrays.asList(flight1, flight2);
        int totalFlightTime = bookingSystem.calculateTotalFlightTime(flights);
        assertEquals(5, totalFlightTime);
    }

    @Test
    public void calculateTotalFlightTimeOfSingleFlight() {
        // Test calculating total flight time with only one flight
        FlightOperations bookingSystem = new FlightOperations();
        Flight flight = new Flight("JFK", "LAX", "10:00", "13:00", false);
        List<Flight> flights = Arrays.asList(flight);
        int totalFlightTime = bookingSystem.calculateTotalFlightTime(flights);
        assertEquals(3, totalFlightTime);
    }

    @Test
    public void calculateTotalFlightTimeWithNoFlights() {
        // Test calculating total flight time with an empty list of flights
        FlightOperations bookingSystem = new FlightOperations();
        List<Flight> flights = Arrays.asList();
        int totalFlightTime = bookingSystem.calculateTotalFlightTime(flights);
        assertEquals(0, totalFlightTime);
    }
}

package main;

import java.util.List;

public class FlightOperations {
    public boolean bookFlight(String origin, String destination, String departureTime, String arrivalTime, boolean roundTrip, boolean multiStop) {
        // Enable user to book multi-stop/direct and round-trip/one way tickets.
        return false;
    }

    public int calculateTotalFlightTime(List<Flight> flights) {
        return 0;
    }

    private boolean validateFlight(String origin, String destination, String departureTime, String arrivalTime) {
        // Ensure flight is valid (ex. origin/destination aren't the same)
        // To be used in bookFlight method
        return false;
    }
}

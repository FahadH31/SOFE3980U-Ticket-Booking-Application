package main;

public class Flight {
    private String origin;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private boolean multiStop;

    public Flight(String origin, String destination, String departureTime, String arrivalTime, boolean multiStop) {
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.multiStop = multiStop;
    }

    // Getters
    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public boolean isMultiStop() {
        return multiStop;
    }
}

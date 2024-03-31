import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlightOperations person1 = new FlightOperations();

        // Input Scanner
        Scanner inputs = new Scanner(System.in);
        int secondFlightChoice = 0;

        // Program Interaction
        System.out.println();
        System.out.println("Welcome to the Flight Ticket Booking Application.");
        System.out.println("Listed below are the available weekly flights.");

        //Flights Output
        System.out.println("==========================================");
        for (int i = 0; i< FlightOperations.weeklyFlights.length; i++){
            System.out.println();
            System.out.println("Flight " + (i+1) + ":");
            System.out.println("Origin:\t\t\t" + FlightOperations.weeklyFlights[i].getOrigin());
            System.out.println("Destination:\t" + FlightOperations.weeklyFlights[i].getDestination());
            System.out.println("Departure Time:\t" + FlightOperations.weeklyFlights[i].getDepartureTime());
            System.out.println("Arrival Time:\t" + FlightOperations.weeklyFlights[i].getArrivalTime());
        }
        System.out.println();
        System.out.println("==========================================");

        // Prompts to gather information
        System.out.println("Please select the flight you'd like to book (1-" + FlightOperations.weeklyFlights.length + ")" );
        int flightChoice = inputs.nextInt();
        inputs.nextLine(); // Consume newline character
        System.out.println("\nWould you like to make this a multi-stop flight? (y/n)");
        String multistop = inputs.nextLine();
        if (multistop.equals("y")){
            System.out.println("\nWhich flight would you like to add to your existing flight? (1-" + FlightOperations.weeklyFlights.length + ")" );
            secondFlightChoice = inputs.nextInt();
        }
        System.out.println("\nWould you like your ticket to be one-way [1], or round-trip [2]?");
        int roundTripOrOneWay = inputs.nextInt();
        System.out.println("\nWould you like your ticket in 12h [1] or 24h [2] format?");
        int timeFormat = inputs.nextInt();

        person1.bookFlight(flightChoice, multistop, secondFlightChoice, roundTripOrOneWay, timeFormat);
    }
}

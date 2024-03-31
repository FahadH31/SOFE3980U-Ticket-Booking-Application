package main;

import java.util.Scanner;

public class FlightOperations {
    // Flights Array List
    public static Flight[] weeklyFlights = {
            new Flight("New York", "Los Angeles", "08:00", "11:00"),
            new Flight("Los Angeles", "Chicago", "12:00", "15:00"),
            new Flight("Chicago", "Miami", "16:00", "19:00"),
            new Flight("Miami", "London", "20:00", "10:00")
    };

    public boolean bookFlight() {
        // Input Scanner
        Scanner inputs = new Scanner(System.in);
        int secondFlightChoice = 0;
        // Program Interaction
        System.out.println();
        System.out.println("Welcome to the Flight Ticket Booking Application.");
        System.out.println("Listed below are the available weekly flights.");
        //Flights Output
        System.out.println("==========================================");
        for (int i = 0; i<weeklyFlights.length;i++){
            System.out.println();
            System.out.println("Flight " + (i+1) + ":");
            System.out.println("Origin:\t\t\t" + weeklyFlights[i].getOrigin());
            System.out.println("Destination:\t" + weeklyFlights[i].getDestination());
            System.out.println("Departure Time:\t" + weeklyFlights[i].getDepartureTime());
            System.out.println("Arrival Time:\t" + weeklyFlights[i].getArrivalTime());
        }
        System.out.println();
        System.out.println("==========================================");
        // Prompts to gather information
        System.out.println("Please select the flight you'd like to book (1-" + weeklyFlights.length + ")" );
        int flightChoice = inputs.nextInt();
        inputs.nextLine(); // Consume newline character
        System.out.println("\nWould you like to make this a multi-stop flight? (y/n)");
        String multistop = inputs.nextLine();
        if (multistop.equals("y")){
            System.out.println("\nWhich flight would you like to add to your existing flight? (1-" + weeklyFlights.length + ")" );
            secondFlightChoice = inputs.nextInt();
        }
        System.out.println("\nWould you like your ticket to be one-way [1], or round-trip [2]?");
        int roundTripOrOneWay = inputs.nextInt();
        System.out.println("\nWould you like your ticket in 12h [1] or 24h [2] format?");
        int timeFormat = inputs.nextInt();

        // Send flight for validation
        boolean isValidFlight;
        // To determine if a second flight was entered.
        if (multistop.equals("y")) {
            isValidFlight= validateFlight(flightChoice, multistop, secondFlightChoice, roundTripOrOneWay, timeFormat);
        }
        else {
            isValidFlight = validateFlight(flightChoice, multistop, 0, roundTripOrOneWay, timeFormat);
        }

        // If validation fails.
        if (!isValidFlight){
            System.out.println("Booking Failed.");
            return false;
        }

        System.out.println("Booking Successful. Here is your ticket: ");
        // Calculate Flight Time
        int totalFlightTime;
        int totalFlightTime2 = 0;
        if (multistop.equals("y")) {
            totalFlightTime = calculateTotalFlightTime(weeklyFlights[flightChoice-1]);
            totalFlightTime2 = calculateTotalFlightTime(weeklyFlights[flightChoice-1]);
        }
        else {
            totalFlightTime = calculateTotalFlightTime(weeklyFlights[flightChoice-1]);
        }
        // Print Ticket
        printTicket(flightChoice, multistop, secondFlightChoice, roundTripOrOneWay, totalFlightTime, totalFlightTime2, timeFormat);
        return true;
    }

    public int calculateTotalFlightTime(Flight flight) {
            int departureHour = Integer.parseInt(flight.getDepartureTime().split(":")[0]);
            int departureMinute = Integer.parseInt(flight.getDepartureTime().split(":")[1]);
            int arrivalHour = Integer.parseInt(flight.getArrivalTime().split(":")[0]);
            int arrivalMinute = Integer.parseInt(flight.getArrivalTime().split(":")[1]);

            int flightTimeMinutes = (arrivalHour * 60 + arrivalMinute) - (departureHour * 60 + departureMinute);
            if (flightTimeMinutes < 0) {
                // Arrival time is on the next day
                flightTimeMinutes += 24 * 60;
            }

            // Convert flight time to hours
            int flightTimeHours = flightTimeMinutes / 60;

            return flightTimeHours;
    }

    public boolean validateFlight(int flightChoice, String multistop, int secondFlightChoice, int roundTripOrOneWay, int timeFormat) {
        // Error if Entered Flight Doesn't Exist
        if (flightChoice <= 0 || flightChoice > weeklyFlights.length) {
            System.out.println("Error In Ticket Validation: Entered Flight Not Found");
            return false;
        }
        // If Multistop Selected
        if (multistop.equals("y")) {
            // Error if Entered Second Flight Doesn't Exist
            if (flightChoice == secondFlightChoice){
                System.out.println("Error In Ticket Validation: Selected First Flight and Second Flight are the same ");
            }

            if (secondFlightChoice <= 0 || secondFlightChoice > weeklyFlights.length) {
                System.out.println("Error In Ticket Validation: Entered Second Flight Not Found");
                return false;
            }

            // Error if the destination of first flight != origin of second flight.
            if (!weeklyFlights[flightChoice - 1].getDestination().equals(weeklyFlights[secondFlightChoice - 1].getOrigin())) {
                System.out.println("Error In Ticket Validation: Flight " + flightChoice + " does not connect to Flight " + secondFlightChoice + ".");
                return false;
            }
        }
        // Error if Invalid Option for Trip Type Selected
        if ((roundTripOrOneWay<1) || (roundTripOrOneWay>2)) {
            System.out.println("Error In Ticket Validation: Invalid Option for Trip Type Selected");
        }

        // Error if Invalid Option for Trip Type Selected
        if ((timeFormat<1) || (timeFormat>2)) {
            System.out.println("Error In Ticket Validation: Invalid Option for Ticket Time Format Selected");
        }

        // If no errors are triggered
        return true;
    }

    private void printTicket(int flightChoice, String multistop, int secondFlightChoice, int roundTripOrOneWay, int totalFlightTime, int totalFlightTime2, int timeFormat) {
        System.out.println("\n------------------------ Ticket Details ------------------------");
        System.out.println("Flight Route: " + weeklyFlights[flightChoice - 1].getOrigin() + " -> " + weeklyFlights[flightChoice - 1].getDestination());

        // Format departure and arrival times based on the user's preference
        String departureTime = convertTimeFormat(weeklyFlights[flightChoice - 1].getDepartureTime(), timeFormat);
        String arrivalTime = convertTimeFormat(weeklyFlights[flightChoice - 1].getArrivalTime(), timeFormat);

        System.out.println("Departure Time: " + departureTime);
        System.out.println("Arrival Time: " + arrivalTime);
        System.out.println("Flight Time: " + totalFlightTime + " hours");

        if (multistop.equals("y")) {
            System.out.println("\nSecond Flight Route: " + weeklyFlights[secondFlightChoice - 1].getOrigin() + " -> " + weeklyFlights[secondFlightChoice - 1].getDestination());

            // Format departure and arrival times for the second flight based on the user's preference
            String secondDepartureTime = convertTimeFormat(weeklyFlights[secondFlightChoice - 1].getDepartureTime(), timeFormat);
            String secondArrivalTime = convertTimeFormat(weeklyFlights[secondFlightChoice - 1].getArrivalTime(), timeFormat);

            System.out.println("Departure Time: " + secondDepartureTime);
            System.out.println("Arrival Time: " + secondArrivalTime);
            System.out.println("Flight Time: " + totalFlightTime2 + " hours");
            System.out.println("\nTotal Flight Time: " + (totalFlightTime + totalFlightTime2) + " hours");
        }

        if (roundTripOrOneWay == 1) {
            System.out.println("\nType: One-way");
        } else if (roundTripOrOneWay == 2) {
            System.out.println("\nType: Return");
        }

        System.out.println("------------------------ Thank You! ------------------------");
    }

    // Method to format time based on user preference
    public String convertTimeFormat(String time, int timeFormat) {
        if (timeFormat == 1) { // 12-hour format
            int hours = Integer.parseInt(time.split(":")[0]);
            String suffix = (hours >= 12) ? "PM" : "AM";
            hours = (hours > 12) ? hours - 12 : hours;
            return hours + ":" + time.split(":")[1] + " " + suffix;
        } else { // 24-hour format
            return time;
        }
    }

}

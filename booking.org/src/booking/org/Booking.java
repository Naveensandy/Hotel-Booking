package booking.org;

import java.util.Scanner;


class Booking {
    private String customerName;
    private int numberOfAdults;
    private int numberOfChildren;
    private int numberOfDays;

    public Booking(String customerName, int numberOfAdults, int numberOfChildren, int numberOfDays) {
        this.customerName = customerName;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.numberOfDays = numberOfDays;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public double calculateTotalCost() {
        if (numberOfAdults < 0) {
            System.out.println("Invalid input for number of adults");
            return -1;
        }

        if (numberOfChildren < 0) {
            System.out.println("Invalid input for number of children");
            return -1;
        }

        if (numberOfDays <= 0) {
            System.out.println("Invalid input for number of days");
            return -1;
        }

        double adultCost = numberOfAdults * 1000 * numberOfDays;
        double childCost = numberOfChildren * 650 * numberOfDays;

        return adultCost + childCost;
    }
}

 class ResortBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the customer details");
        String input = scanner.nextLine();

        String[] inputArray = input.split(":");

        if (inputArray.length != 4) {
            System.out.println("Invalid input format. Please provide valid input.");
            return;
        }

        String customerName = inputArray[0];
        int numberOfAdults = Integer.parseInt(inputArray[1]);
        int numberOfChildren = Integer.parseInt(inputArray[2]);
        int numberOfDays = Integer.parseInt(inputArray[3]);

        Booking booking = new Booking(customerName, numberOfAdults, numberOfChildren, numberOfDays);

        double totalCost = booking.calculateTotalCost();
        if (totalCost != -1) {
            System.out.println(customerName + " your booking is confirmed and the total cost is " + totalCost);
        }
    }
}


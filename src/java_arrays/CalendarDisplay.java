package java_arrays;

import java.util.Scanner;

public class CalendarDisplay {

    // Array to store month names
    static String[] months = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    // Array to store days in months (non-leap year)
    static int[] days = {
            0, 31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
    };

    // Method to check leap year
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    // Method to get number of days in a month
    public static int getNumberOfDays(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29; // February in a leap year
        }
        return days[month];
    }

    // Method to calculate first day of the month using Gregorian algorithm
    public static int getFirstDay(int month, int year) {
        int d = 1; // first day
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (d + x + (31*m0)/12) % 7;
        return d0; // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
    }

    // Method to display the calendar
    public static void displayCalendar(int month, int year) {
        System.out.println("     " + months[month] + " " + year);
        System.out.println(" Su Mo Tu We Th Fr Sa");

        int firstDay = getFirstDay(month, year);
        int numberOfDays = getNumberOfDays(month, year);

        // Print leading spaces
        for (int i = 0; i < firstDay; i++) {
            System.out.print("   ");
        }

        // Print days of the month
        for (int day = 1; day <= numberOfDays; day++) {
            System.out.printf("%3d", day);
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        displayCalendar(month, year);
    }
}

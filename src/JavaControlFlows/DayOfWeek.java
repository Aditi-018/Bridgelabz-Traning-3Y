package JavaControlFlows;

public class DayOfWeek {
    public static void main(String[] args) {
        // Take inputs from command line arguments
        int m = Integer.parseInt(args[0]); // month (1=Jan, 2=Feb, ...)
        int d = Integer.parseInt(args[1]); // day
        int y = Integer.parseInt(args[2]); // year

        // Step 1: Apply given formulas
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;

        // Step 2: Print result (0=Sunday, 1=Monday, ..., 6=Saturday)
        System.out.println("Day of week: " + d0);
    }
}

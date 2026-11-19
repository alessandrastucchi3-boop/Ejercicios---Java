import java.util.Scanner;

/*
 * CINEMA TICKET ANALYZER
 *
 * A Java program that analyzes ticket sales across five cinema sessions.
 *
 * It calculates the total and average number of tickets sold,
 * identifies the session with the highest sales, and counts
 * the sessions with more than 50 tickets sold.
 *
 * The program is structured into reusable static methods,
 * demonstrating method declarations, parameters, return values,
 * arrays, and basic input validation with exception handling.
 */

public class CinemaTicketAnalyzer {

    public static int[] readSales(int numSession) {
    int[] session = new int[numSession];
    Scanner scanner = new Scanner(System.in);
    for(int i = 0; i < session.length; i++) {
        boolean validation = false;
        do {
            try {
                System.out.println("How many sales per session? ");
                session[i] = Integer.parseInt(scanner.nextLine());
                if(session[i] >= 0) {
                    validation = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: please enter a valid integer.");
            }
        } while (!validation);

    }
    scanner.close();
    return session;
}

public static int calculateTotal(int[] array) {
    int sum = 0;
    for(int i = 0; i < array.length; i++) {
        sum += array[i];
    }
    return sum;
}

public static float calculateAverage(int[] array) {
    float avg = (float)calculateTotal(array)/array.length;
    return avg;
}

public static int findMaximum(int[] array) {
    int max = array[0];
    for(int i = 0; i < array.length; i++) {
        if(array[i] > max) {
            max = array[i];
        }
    }
    return max;
}

public static int countHighSales(int[] array) {
    int count = 0;
    for(int i = 0; i < array.length; i++) {
        if(array[i] > 50) {
            count += 1;
        }
    }
    return count;
}

    public static void main(String[] args) {
        int[] sales = readSales(5);
        int total = calculateTotal(sales);
        float avg = calculateAverage(sales);
        int max = findMaximum(sales);
        int count = countHighSales(sales);

        System.out.println("Total tickets sold: " + total);
        System.out.printf("Average sales per session: %.2f%n", avg);
        System.out.println("Maximum tickets sold in one session: " + max);
        System.out.println("Sessions with more than 50 sales: " + count);
    }
}

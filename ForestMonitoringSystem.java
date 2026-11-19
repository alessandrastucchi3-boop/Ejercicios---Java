import java.util.Scanner;

/*
 * FOREST MONITORING SYSTEM
 *
 * A Java program that records the number of saplings found
 * across seven forest plots.
 *
 * It calculates the total and average number of saplings,
 * identifies the maximum and minimum counts, and tracks
 * plots based on specific population thresholds.
 *
 * Includes input validation and exception handling using
 * try-catch to ensure only non-negative integers are accepted.
 */

public class ForestMonitoringSystem {
    public static void main(String[] args) {
        int[] saplingsPerPlot = new int[7];
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < saplingsPerPlot.length; i ++) {
            boolean validation = false;
            do {
                System.out.println("How many trees per plot? ");
                try {
                    saplingsPerPlot[i] = Integer.parseInt(scanner.nextLine());
                    if(saplingsPerPlot[i] >= 0) {
                        validation = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: the data should be an integer.");
                }
            } while (!validation);
        }

        int sumSaplings = 0;
        for(int i = 0; i < saplingsPerPlot.length; i ++) {
            sumSaplings += saplingsPerPlot[i];
        }

        float avgSaplings = (float)sumSaplings/saplingsPerPlot.length;

        int maxSaplings = saplingsPerPlot[0];
        for(int i = 0; i < saplingsPerPlot.length; i ++) {
            if(saplingsPerPlot[i] > maxSaplings) {
                maxSaplings = saplingsPerPlot[i];
            }
        }

        int minSaplings = saplingsPerPlot[0];
        for(int i = 0; i < saplingsPerPlot.length; i ++) {
            if(saplingsPerPlot[i] < minSaplings) {
                minSaplings = saplingsPerPlot[i];
            }
        }

        int count30 = 0;
        int count10 = 0;
        int count0 = 0;
        for(int i = 0; i < saplingsPerPlot.length; i ++) {
            if(saplingsPerPlot[i] > 30) {
                count30 += 1;
            }
            if(saplingsPerPlot[i] < 10) {
                count10 += 1;
            }
            if(saplingsPerPlot[i] == 0) {
                count0 += 1;
            }
        }


        System.out.println("Total saplings: " + sumSaplings);
        System.out.printf("Average per plot saplings: %.2f%n", avgSaplings);
        System.out.println("Maximum saplings in a plot: " + maxSaplings);
        System.out.println("Minimum saplings in a plot: " + minSaplings);
        System.out.println("Plot with less than 10 saplings: " + count10);
        System.out.println("Plot with more than 30 saplings: " + count30);
        System.out.println("Plot with 0 saplings: " + count0);

        scanner.close();
    }
}

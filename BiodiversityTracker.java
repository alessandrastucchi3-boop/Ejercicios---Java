import java.util.Scanner;

/*
 * BIODIVERSITY TRACKER
 *
 * A Java program that records wildlife observations over seven days.
 * It calculates the total and average number of animals observed,
 * identifies the maximum and minimum daily observations, and counts
 * the days that meet specific observation thresholds.
 *
 * Includes input validation and exception handling to ensure
 * that only valid, non-negative integers are accepted.
 */

public class BiodiversityTracker {
    public static void main(String[] args) {
        int[] animalsObserved = new int[7];
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i < animalsObserved.length; i++) {
            boolean validInput = false;
            do {
                System.out.printf("Animal observed on day %d: ", (i+1));                   
                try {
                    animalsObserved[i] = Integer.parseInt(scanner.nextLine());
                    if(animalsObserved[i] >= 0) {
                        validInput = true;
                    } else {
                        validInput = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: el dato tiene que ser un numero entero.");
                }
            } while (!validInput);
        }

        int totalAnimals = 0;
        for(int i=0; i < animalsObserved.length; i++) {
            totalAnimals += animalsObserved[i];
        }

        float dailyAverage = ((float)totalAnimals/animalsObserved.length);

        int maxObservation = animalsObserved[0];
        for(int i=0; i < animalsObserved.length; i++) {
            if(animalsObserved[i] > maxObservation) {
                maxObservation = animalsObserved[i];
            }
        }
        
        int minObservation = animalsObserved[0];
        for(int i=0; i < animalsObserved.length; i++) {
            if(animalsObserved[i] < minObservation) {
                minObservation = animalsObserved[i];
            }
        }

        int count10 = 0;
        int count20 = 0;
        for(int i=0; i < animalsObserved.length; i++) {
            if (animalsObserved[i] > 20) {
                count20 += 1;
            }
            if (animalsObserved[i] < 10) {
                count10 += 1;
            }
        }

        System.out.println("Total observations: " + totalAnimals);
        System.out.printf("Daily average: %.2f%n", dailyAverage);
        System.out.println("Maximum observations: " + maxObservation);
        System.out.println("Minimum observations: " + minObservation);
        System.out.println("Days with more than 20 observations: " + count20);
        System.out.println("Days with less than 10 observations: " + count10);

        scanner.close();
    }
}
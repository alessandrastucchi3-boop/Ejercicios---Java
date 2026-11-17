import java.util.Scanner;

public class SistemaMonitorizacionMetereologica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[] temperatures = new float[7];
        float sumTemperature = 0;

        for(int i = 0; i < temperatures.length; i++) {
        System.out.print("Temperature: ");
        float t = Float.parseFloat(scanner.nextLine());
        temperatures[i] = t;
        sumTemperature += temperatures[i];
        }

        float avgTemperature = sumTemperature / temperatures.length;

        float maxTemperature = temperatures[0];
        for (float temperature : temperatures) {
            if(temperature > maxTemperature) {
                maxTemperature = temperature;
            }
        }

        float minTemperature = temperatures[0];
        for (float temperature : temperatures) {
            if(temperature < minTemperature) {
                minTemperature = temperature;
            }
        }

        int count = 0;
        for(float temperature : temperatures) {
            if(temperature < 0) {
                count += 1;
            }
        }
        System.out.printf("%d dias por debajo de 0°C%n", count);

        System.out.printf("La media de temperatura es %.2f 0°C%n", avgTemperature);
        System.out.println("La maxima es " + maxTemperature + " 0°C");
        System.out.println("La minima es " + minTemperature + " 0°C");
        scanner.close();
    }
}

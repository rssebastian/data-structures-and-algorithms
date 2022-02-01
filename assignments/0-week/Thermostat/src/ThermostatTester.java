import java.util.Scanner;

public class ThermostatTester {
    public static void main(String[] args) throws TemperatureOutofRange {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Create your new thermostat! \r\nSet the lowest possible temperature: ");
        int low = keyboard.nextInt();
        System.out.print("Set the highest possible temperature: ");
        int high = keyboard.nextInt();
        Thermostat t = new Thermostat(low, high);
        System.out.printf("Your new thermostat has a low of %d and a high of %d.%n", low, high);
        System.out.print("Please set a temperature: ");
        int temp = keyboard.nextInt();
        try {
            t.setTemperature(temp);
            System.out.printf("Enjoy relaxing at %d degrees!", temp);
        } catch (TemperatureOutofRange e) {
            System.out.println(e.getMessage());
            secondChance(low, high);
        }
        keyboard.close();
    }

    public static void secondChance(int low, int high) throws TemperatureTooLow, TemperatureTooHigh {
        Scanner keyboard = new Scanner(System.in);
        boolean validTemp = false;
        while (!validTemp) {
            try {
                System.out.print("Please input a new temperature: ");
                int temp = keyboard.nextInt();
                if (temp < low) {
                    throw new TemperatureTooLow();
                } else if (temp > high) {
                    throw new TemperatureTooHigh();
                } else {
                    validTemp = true;
                    System.out.printf("Enjoy relaxing at %d degrees!", temp);
                }
            } catch (TemperatureTooLow e) {
                System.out.println(e.getMessage());
            } catch (TemperatureTooHigh e) {
                System.out.println(e.getMessage());
            }
        }
        keyboard.close();

    }
}

// TEST CASE OUTPUT
// ----------------------------
// Create your new thermostat!
// Set the lowest possible temperature: 10
// Set the highest possible temperature: 50
// Your new thermostat has a low of 10 and a high of 50.
// Please set a temperature: 6
// That temperature is too low for this thermostat!
// Please input a new temperature: 60
// That temperature is too high for this thermostat!
// Please input a new temperature: 40
// Enjoy relaxing at 40 degrees!
// ----------------------------
// Create your new thermostat!
// Set the lowest possible temperature: -50
// Set the highest possible temperature: 150
// Your new thermostat has a low of -50 and a high of 150.
// Please set a temperature: -100
// That temperature is too low for this thermostat!
// Please input a new temperature: 200
// That temperature is too high for this thermostat!
// Please input a new temperature: 100
// Enjoy relaxing at 100 degrees!

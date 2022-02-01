public class TemperatureOutofRange extends Exception {
    public TemperatureOutofRange() {
        super("The temperature is out of this thermostat's range!");
    }

    public TemperatureOutofRange(String message) {
        super(message);
    }
}

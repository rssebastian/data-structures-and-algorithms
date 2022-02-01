public class TemperatureTooHigh extends TemperatureOutofRange {
    public TemperatureTooHigh() {
        super("That temperature is too high for this thermostat!");
    }

    public TemperatureTooHigh(String message) {
        super(message);
    }
}

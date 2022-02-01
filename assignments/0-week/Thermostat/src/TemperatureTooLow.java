public class TemperatureTooLow extends TemperatureOutofRange {
    public TemperatureTooLow() {
        super("That temperature is too low for this thermostat!");
    }

    public TemperatureTooLow(String message) {
        super(message);
    }
}

public class Thermostat {
    private int temperature;
    private int low;
    private int high;

    public Thermostat(int l, int h) {
        low = l;
        high = h;
    }

    public void setTemperature(int temp) throws TemperatureTooLow, TemperatureTooHigh {
        if (temp < low) {
            throw new TemperatureTooLow();
        } else if (temperature > high) {
            throw new TemperatureTooHigh();
        } else {
            temperature = temp;
        }

    }

    public int getTemperature() {
        return temperature;
    }
}

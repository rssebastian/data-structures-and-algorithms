public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int totalHours;

    public HourlyEmployee() {
        super();
    }

    public HourlyEmployee(String fn, String ln) {
        super(fn, ln);
    }

    public HourlyEmployee(String fn, String ln, String dept) {
        super(fn, ln, dept);
    }

    public HourlyEmployee(String fn, String ln, String dept, double hr) {
        super(fn, ln, dept);
        hourlyRate = hr;
    }

    public HourlyEmployee(String fn, String ln, String dept, double hr, int th) {
        super(fn, ln, dept);
        hourlyRate = hr;
        totalHours = th;
    }

    public int getHours() {
        return totalHours;
    }

    public void setHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hr) {
        hourlyRate = hr;
    }

    public void printHours() {
        if (totalHours > 0) {
            System.out.println("Total Hours over 4 weeks: " + getHours());
        } else {
            System.out.println("This employee has not worked for the past 4 weeks");
        }
    }

    public void printWeeklyAverage() {
        if (totalHours > 0) {
            System.out.println("Average Hours per week: " + getHours() / 4);
        } else {
            System.out.println("This employee has not worked for the past 4 weeks");
        }
    }

    public void printTotalWages() {
        System.out.printf("This employee earned $%.2f for the past 4 weeks.%n", getHours() * getHourlyRate());
    }

}

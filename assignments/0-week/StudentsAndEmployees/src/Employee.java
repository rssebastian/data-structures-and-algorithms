// Superclass for FulltimeEmployee & HourlyEmployee
// Subclass of Person
public class Employee extends Person {
    private String department;

    public Employee() {
        super();
    }

    public Employee(String fn, String ln) {
        super(fn, ln);
    }

    public Employee(String fn, String ln, String dept) {
        super(fn, ln);
        department = dept;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String dept) {
        department = dept;
    }

    public String toString() {
        return (super.toString() + ", Department: " + getDepartment());
    }
}

public class Person {
    private String firstName, lastName;
    private long idNumber;

    private static long idCounter = 1000;

    Person() {
        idCounter++;
        idNumber = idCounter;
    }

    Person(String fn, String ln) {
        firstName = fn;
        lastName = ln;
        idCounter++;
        idNumber = idCounter;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fn) {
        firstName = fn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String ln) {
        lastName = ln;
    }

    public long getID() {
        return idNumber;
    }

    public void printFn() {
        System.out.println(firstName);
    }

    public void printLn() {
        System.out.println(lastName);
    }

    public void printID() {
        System.out.println(idNumber);
    }

    public String toString() {
        return firstName + " " + lastName + ", ID#: " + idNumber;
    }
}

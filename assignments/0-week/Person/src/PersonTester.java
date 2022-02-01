public class PersonTester {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setFirstName("Jon");
        p1.setLastName("Johnson");
        System.out.println(p1);

        Person p2 = new Person("Ben", "Benson");
        System.out.println(p2);

        Person p3 = new Person();
        p3.setFirstName("Peter");
        p3.setLastName("Petersen");
        System.out.println(p3);
    }
}

// TEST CASE OUTPUT
// Jon Johnson, ID#: 1001
// Ben Benson, ID#: 1002
// Peter Petersen, ID#: 1003
